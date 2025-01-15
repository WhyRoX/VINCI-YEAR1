const express = require('express');
const router = express.Router();

const Exolune = require('../models/Exolune.js');

/* GET exolunes page. */
router.get('/', (req, res) => {
    console.log("Je passe par la route /exolunes");
    res.render('exolunes/index.hbs', { exolunesList: Exolune.list() });
});

module.exports = router;