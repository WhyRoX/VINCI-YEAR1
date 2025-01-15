
const db = require('../models/db_conf.js');

module.exports.save = (data) => {
    console.log(data);
    const stmt = db.prepare('INSERT INTO users(name, firstname, email, password) VALUES (?, ?, ?, ?)');
    const info = stmt.run(data.name, data.firstname, data.email, data.password);
    console.log("user model save member" + info.changes);
}

module.exports.find = (email) => {
    console.log(email);
    const stmt = db.prepare('SELECT * FROM users WHERE email = ?');
    // get -> only one record
    return stmt.get(email);
}

module.exports.list = () => {
    const stmt = db.prepare('SELECT * FROM users');
    return stmt.all();
}

module.exports.enableAccount = (id) => {
    const stmt = db.prepare('UPDATE users SET active=1 WHERE id_user = ?');
    return stmt.run(id);
}

module.exports.disableAccount = (id) => {
    const stmt = db.prepare('UPDATE users SET active=0 WHERE id_user = ?');
    return stmt.run(id);
}