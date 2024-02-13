const express = require('express');
const router = express.Router();

const Exoplanet = require('../models/Exoplanet.js');

const listeExoplanetes = Exoplanet.list();
let searchResult = null;
let searched = false;
router.get('/', (req, res) => {
    const found = searchResult !== null;
  res.render('exoplanets/exoplanets.hbs', { listeExoplanetes, searchResult, found, searched });
});

router.post('/add', (req, res) => {
    const newExoplanet = {
      id: listeExoplanetes.length + 1,
      name: req.body.name,
      hClass: req.body.hClass,
      year: req.body.year
    };
    Exoplanet.add(newExoplanet);
    res.redirect('/exoplanets');
});

router.get('/search', (req, res) => {

    const planet = Exoplanet.search(req.query.name);
    if (planet !== null) {
        searched = true;
        searchResult = planet.name;
    } else {
        searchResult = null;
    }

    res.redirect('/exoplanets');
  });

router.get('/details', (req, res) => {
    let errorType = null;
    let id = parseInt(req.query.id);
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