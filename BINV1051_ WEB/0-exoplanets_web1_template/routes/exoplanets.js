const express = require('express');
const router = express.Router();
const Exoplanet = require('../models/Exoplanet.js');


let searchResult = null;
let searched = false;
router.get('/', (req, res) => {
    const found = searchResult !== null;
    const listeExoplanetes = Exoplanet.list();
  res.render('exoplanets/exoplanets.hbs', { listeExoplanetes, searchResult, found, searched });
});

router.post('/add', (req, res) => {
    const newExoplanet = {
      unique_name: req.body.unique_name,
      hclass: req.body.hclass,
      discovery_year: req.body.discovery_year,
      ist: req.body.ist,
      pclass: req.body.pclass
    };
    Exoplanet.add(newExoplanet);
    res.redirect('/exoplanets');
});

router.get('/search', (req, res) => {

    const planet = Exoplanet.search(req.query.unique_name);
    if (planet !== null) {
        searched = true;
        searchResult = planet.unique_name;
    } else {
        searchResult = null;
    }

    res.redirect('/exoplanets');
  });

router.get('/details', (req, res) => {
    let errorType = null;
    let id = parseInt(req.query.exoplanet_id);
    if (isNaN(id)) {
        errorType = "entier";
        res.render('error.hbs', { message: "Erreur l'id n'est pas un entier", errorType: errorType });
        return;
    }
    details = Exoplanet.findById(id);
    if (details !== null) {
        res.render('exoplanets/exoplanets.hbs', { details });
    } else {
        errorType = "inexistant"; // i'm not actually using it, since I just use an else in the error.hbs
        res.render('error.hbs', { message: "Aucune Exoplanète correspondante à cet ID !", errorType: errorType });
    }
});
  
  
module.exports = router;