// app.js
const express = require("express");
const sqlite3 = require("sqlite3").verbose();
const bodyParser = require("body-parser");
const path = require("path");

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());
app.use(express.static("public")); // serve HTML files from public folder

// Database setup
const db = new sqlite3.Database("people.db");

db.serialize(() => {
    db.run(`CREATE TABLE IF NOT EXISTS people (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    surname TEXT NOT NULL
  )`);
});

// API: Add record
app.post("/add", (req, res) => {
    const { name, surname } = req.body;
    if (!name || !surname) {
        return res.status(400).json({ error: "Name and surname are required" });
    }
    db.run("INSERT INTO people (name, surname) VALUES (?, ?)", [name, surname], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ id: this.lastID, name, surname });
    });
});

// API: List records
app.get("/list-data", (req, res) => {
    db.all("SELECT * FROM people", [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json(rows);
    });
});

// Serve pages
app.get("/add", (req, res) => {
    res.sendFile(path.join(__dirname, "public", "add.html"));
});

app.get("/list", (req, res) => {
    res.sendFile(path.join(__dirname, "public", "list.html"));
});

// Start server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});

/*

npm init -y
npm install express sqlite3 body-parser
node app.js


curl -X POST http://localhost:3000/add -H "Content-Type: application/json" -d '{"name":"Ali","surname":"Yılmaz"}'


curl http://localhost:3000/list


*/