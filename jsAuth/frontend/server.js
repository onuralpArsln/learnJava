import express from "express";
import bodyParser from "body-parser";
import fetch from "node-fetch";
import session from "express-session";
import path from "path";
import { fileURLToPath } from "url";

const app = express();

// __dirname tanımla (ESM için)
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// View ayarı
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({ extended: true }));

// Static dosyalar (CSS, JS, resim vs.)
app.use(express.static(path.join(__dirname, "public")));


// Session ayarı
app.use(
    session({
        secret: "supersecret", // production’da .env’den al
        resave: false,
        saveUninitialized: false,
    })
);

// Login sayfası
app.get("/", (req, res) => {
    res.render("login");
});

// Login post
app.post("/login", async (req, res) => {
    const { username, password } = req.body;

    const response = await fetch("http://localhost:4000/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
        const data = await response.json();
        req.session.token = data.token; // token session’da saklanıyor
        res.redirect("/user");
    } else {
        res.send("Giriş başarısız!");
    }
});

// Kullanıcı sayfası (korumalı)
app.get("/user", async (req, res) => {
    if (!req.session.token) return res.redirect("/");

    const response = await fetch("http://localhost:4000/profile", {
        headers: { Authorization: `Bearer ${req.session.token}` },
    });

    if (response.ok) {
        const data = await response.json();
        res.render("user", { message: data.message });
    } else {
        res.redirect("/");
    }
});

// Çıkış
app.get("/logout", (req, res) => {
    req.session.destroy(() => {
        res.redirect("/");
    });
});

app.listen(3000, () => console.log("Frontend çalışıyor: http://localhost:3000"));
