const express = require("express");
const dotenv = require("dotenv");
const jwt = require("jsonwebtoken");
const bodyParser = require("body-parser");

dotenv.config();
const app = express();
app.use(bodyParser.json());

const users = [
    { username: process.env.USER1_NAME, password: process.env.USER1_PASS },
    { username: process.env.USER2_NAME, password: process.env.USER2_PASS },
];

// Login endpoint
app.post("/login", (req, res) => {
    const { username, password } = req.body;

    // for each u in users
    const user = users.find(
        (u) => u.username === username && u.password === password
    );

    if (!user) {
        return res.status(401).json({ message: "Geçersiz kullanıcı adı veya şifre" });
    }

    const token = jwt.sign({ username: user.username }, process.env.JWT_SECRET, {
        expiresIn: "1h",
    });

    res.json({ token });
});

// Token doğrulama
app.get("/profile", (req, res) => {
    const authHeader = req.headers["authorization"];
    if (!authHeader) return res.sendStatus(403);

    const token = authHeader.split(" ")[1];

    jwt.verify(token, process.env.JWT_SECRET, (err, decoded) => {
        if (err) return res.sendStatus(403);
        res.json({ message: `Merhaba ${decoded.username}` });
    });
});

app.listen(4000, () => console.log("Auth API çalışıyor: http://localhost:4000"));
