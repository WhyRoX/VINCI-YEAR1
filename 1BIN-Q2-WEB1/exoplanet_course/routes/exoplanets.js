const express = require('express');
const router = express.Router();

const multer = require('multer')
const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, 'public/images');
    },
    filename: function (req, file, cb) {
        const date = new Date();
        const uniquePrefix = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + '-' + date.getHours() + '-' + date.getMinutes() + '-' + date.getSeconds();
        // Math.round(Math.random() * 1E9)
        cb(null, uniquePrefix + '-' + file.originalname);
    }
})
const upload = multer({ storage: storage });

const validator = require('validator');


const Exoplanet = require("../models/Exoplanet.js");

/* GET exoplanets index. */
router.get('/', function (req, res, next) {
    const exoplanetsTable = Exoplanet.list();
    res.render('exoplanets/index.hbs', { exoplanetsTable, errors: req.query.errors });
});


/* POST add exoplanet. */
router.post('/add', upload.single('imageExoplanet'), function (req, res, next) {
    console.log("POST ADD EXOPLANET");
    // validate name of explanet -> betweeen 3 and 100 character
    if (validator.isLength(req.body.uniqueNameExoplanet, { min: 3, max: 100 })) {
        console.log("req.file : " + JSON.stringify(req.file));
        let filename = null;
        // req.file must be undefined if no file given
        if (req.file === undefined) filename = null;
        else filename = 'images/' + req.file.filename;
        Exoplanet.save({
            uniqueName: req.body.uniqueNameExoplanet,
            hClass: req.body.hClassExoplanet,
            discoveryYear: req.body.discoveryYearExoplanet,
            image: filename
        });
        res.redirect('/exoplanets');
    }
    else {
        res.redirect('/exoplanets?errors= Le nom d\'une exoplanète doit faire entre 3 et 100 caractères');
    }
});


/* GET search exoplanet. */
router.get('/search', function (req, res, next) {
    console.log("GET SEARCH EXOPLANET");
    const uniqueNameExoplanetParam = req.query.uniqueNameExoplanet;
    let min3charOK = false;
    let exoplanetsTable = null;
    if (uniqueNameExoplanetParam.length >= 3) {
        min3charOK = true;
        exoplanetsTable = Exoplanet.search(uniqueNameExoplanetParam);
    }
    res.render('exoplanets/index.hbs', { exoplanetsTable, min3charOK });
});

router.post('/delete', (req, res, next) => {
    console.log("id Exoplanète à supprimer : " + req.body.id);
    Exoplanet.delete(req.body.id);
    res.redirect('/exoplanets');
});



/* GET details exoplanet. */
router.get('/details', function (req, res, next) {
    console.log("GET DETAILS EXOPLANET");
    // convert string req.query.id to int
    // another solution is to use == instead of === in if instruction
    const exoplanetIdParam = parseInt(req.query.id);
    const exoplanetFound = Exoplanet.findById(exoplanetIdParam);
    res.render('exoplanets/details.hbs', { exoplanet: exoplanetFound });

});


router.get('/filter', function (req, res, next) {
    const filter = req.query.filter;
    let exoplanetsTableFilter = [];
    if (filter === "Filtrer par hclass") {
        console.log("GET FILTER EXOPLANET HCLASS");
        exoplanetsTableFilter = Exoplanet.searchByHclass(req.query.hClassExoplanet);
    }
    if (filter === "Filtrer par année") {
        console.log("GET FILTER EXOPLANET ANNEE");
        const discoveryYearParam = parseInt(req.query.discoveryYearExoplanet);
        exoplanetsTableFilter = Exoplanet.searchByYear(discoveryYearParam);
    }
    // param exoplanetsTable must be the same but with a different value (table filtering)
    res.render('exoplanets/index.hbs', { exoplanetsTable: exoplanetsTableFilter });
});


// display form to update exoplanet
router.get('/update', function (req, res, next) {
    console.log("GET UPDATE EXOPLANET");
    const exoplanetIdParam = parseInt(req.query.id);
    const exoplanetFound = Exoplanet.findById(exoplanetIdParam);
    res.render('exoplanets/update.hbs', { exoplanet: exoplanetFound });
});


/* POST update exoplanet. */
router.post('/update', function (req, res, next) {
    console.log("POST UPDATE EXOPLANET");
    Exoplanet.save({
        id: parseInt(req.body.idExoplanet),
        uniqueName: req.body.uniqueNameExoplanet,
        hClass: req.body.hClassExoplanet,
        discoveryYear: parseInt(req.body.discoveryYearExoplanet),
        IST: parseFloat(req.body.ISTExoplanet),
        pClass: req.body.pClassExoplanet
    });

    res.redirect('/exoplanets');
});


module.exports = router;
