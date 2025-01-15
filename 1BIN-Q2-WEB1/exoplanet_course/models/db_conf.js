// file db_conf.js in models

const db = require('better-sqlite3')('/opt/web1_23-24/db/exoplanets.db', { verbose: console.log });
// const db = require('better-sqlite3')('/home/olivier/exoplanets.db', { verbose: console.log });

module.exports = db;
