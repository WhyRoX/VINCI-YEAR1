const express = require('express');
const router = express.Router();

const User = require('../models/User.js');

router.get('/', (req, res, next) => {
    console.log("ADMIN INDEX");
    console.log("session variable : " + JSON.stringify(req.session));
    if (req.session.admin) {
        res.render('admin/index', { listUsers: User.list() });
    }
    else {
        res.redirect('/members');
    }
});

router.post('/enableAccount', (req, res, next) => {
    if (req.session.admin) {
        User.enableAccount(req.body.id);
        res.redirect('/admin');
    }
    else {
        res.redirect('/members');
    }
});

router.post('/disableAccount', (req, res, next) => {
    if (req.session.admin) {
        User.disableAccount(req.body.id);
        res.redirect('/admin');
    }
    else {
        res.redirect('/members');
    }
});




module.exports = router;