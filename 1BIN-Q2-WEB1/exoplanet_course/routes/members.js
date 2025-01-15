const express = require('express');
const router = express.Router();

const User = require('../models/User.js');

router.get('/', (req, res, next) => {
    console.log("MEMBER INDEX");
    console.log("session variable : " + JSON.stringify(req.session));
    if (req.session.login) {
        const user = User.find(req.session.login);
        res.render('members/index', { user });
    }
    else {
        res.redirect('/users');
    }
});

module.exports = router;