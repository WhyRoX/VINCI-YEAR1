const express = require('express');
const router = express.Router();

const Message = require('../models/Message.js');

/* GET forum. */
router.get('/', function (req, res, next) {
    res.render('forum/index.hbs', { messagesTable: Message.list() });
});


/* POST add forum. */
router.post('/add', function (req, res, next) {
    console.log("POST ADD FORUM");
    Message.save({ message: req.body.message, author: req.body.author });
    res.redirect('/forum');
});

/* POST like message */
router.post('/like', function (req, res, next) {
    console.log("LIKE MESSAGE FORUM");
    Message.like(req.body.id);
    res.redirect('/forum');
});

module.exports = router;