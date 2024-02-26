const express = require('express');
const router = express.Router();

const Exoplanet = require('../models/Exoplanet.js');


/* GET exoplanets index. */
router.get('/', (req, res) => {
    const listeExoplanetes = Exoplanet.list();
  res.render('exoplanets/exoplanets.hbs', { listeExoplanetes });
});

/* POST add exoplanet. */
router.post('/add', (req, res) => {
    Exoplanet.add({
      unique_name: req.body.unique_name,
      hclass: req.body.hclass,
      discovery_year: req.body.discovery_year,
      ist: req.body.ist,
      pclass: req.body.pclass
    });
    res.redirect('/exoplanets');
});



/* GET search exoplanet. */
router.get('/search', (req, res) => {
    const uniqueNameExoplanetParam = req.query.unique_name;
    let details = null;
    if (uniqueNameExoplanetParam.lenght >= 3) {
        min3charOK = true;
        details = Exoplanet.search(uniqueNameExoplanetParam);
    }

    res.render('exoplanets/index.hbs', { listeExoplanetes, min3charOK, exoplanet : details });
});

router.post('/delete', (req, res, next) => {
    console.log("id Exoplanète à supprimer : " + req.body.exoplanet_id);
    Exoplanet.delete(req.body.exoplanet_id);
    res.redirect('/exoplanets');
});


/* GET details exoplanet. */
router.get('/details', function (req, res, next) {
    console.log("GET DETAILS EXOPLANET");
    // convert string req.query.id to int
    // another solution is to use == instead of === in if instruction
    const exoplanetIdParam = parseInt(req.query.exoplanet_id);
    const details = Exoplanet.findById(exoplanetIdParam);
    res.render('exoplanets/details.hbs', { exoplanet: details });

});


/*router.get('/details', (req, res) => {
    let errorType = null;
    let id = parseInt(req.query.exoplanet_id);
    if (isNaN(id)) {
        errorType = "entier";
        res.render('error.hbs', { message: "Erreur l'id n'est pas un entier", errorType: errorType });
        return;
    }
    details = Exoplanet.findById(id);
    if (details !== null) {
        res.render('exoplanets/index.hbs', { details });
    } else {
        errorType = "inexistant"; // i'm not actually using it, since I just use an else in the error.hbs
        res.render('error.hbs', { message: "Aucune Exoplanète correspondante à cet ID !", errorType: errorType });
    }
});*/

  
  
module.exports = router;