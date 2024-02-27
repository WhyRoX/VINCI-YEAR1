const express = require('express');
const router = express.Router();

const Exoplanet = require('../models/Exoplanet.js');


/* GET exoplanets index. */
router.get('/', function (req, res, next) {
    const exoplanetsTable = Exoplanet.list();
    res.render('exoplanets/index.hbs', { exoplanetsTable });
});


/* POST add exoplanet. */
// router.post('/add', (req, res) => {
//     Exoplanet.save({
//         unique_name: req.body.unique_name,
//         hclass: req.body.hclass,
//         discovery_year: req.body.discovery_year,
//         ist: req.body.ist,
//         pclass: req.body.pclass
//     });

//     res.redirect('/exoplanets');
// });
router.post('/add', function (req, res, next) {
    console.log("POST ADD EXOPLANET");
    Exoplanet.save({
        unique_name: req.body.unique_name,
        hclass: req.body.hclass,
        discovery_year: req.body.discovery_year
    });

    res.redirect('/exoplanets');
});


/* GET search exoplanet. */
router.get('/search', function (req, res, next) {
    const uniqueNameExoplanetParam = req.query.unique_name;
    let min3charOK = false;
    let exoplanetsTable = null;
    if (uniqueNameExoplanetParam.length >= 3) {
        min3charOK = true;
        exoplanetsTable = Exoplanet.search(uniqueNameExoplanetParam);
    }

    res.render('exoplanets/index.hbs', { exoplanetsTable, min3charOK });
});

router.post('/delete', (req, res, next) => {
    console.log("id Exoplanète à supprimer : " + req.body.exoplanet_id);
    Exoplanet.delete(req.body.exoplanet_id);
    res.redirect('/exoplanets');
});


let details = null;
/* GET details exoplanet. */
/*router.get('/details', function (req, res, next) {
    console.log("GET DETAILS EXOPLANET");
    // convert string req.query.id to int
    // another solution is to use == instead of === in if instruction
    let id = parseInt(req.query.exoplanet_id);
    details = Exoplanet.findById(id);
    res.render('exoplanets/details.hbs', { details });
// essayer en enlevant exoplanet:
});*/
/*router.get('/details', (req, res) => { 
    const liste1=[];
    let no="";
    let po="";
  
    const element=Exoplanet.findById(req.query.exoplanet_id);
  
    if(isNaN(req.query.exoplanet_id)){ 
      no="it's not a number";
    }
  
    else{
      if(el==null){ 
      po="Aucune Exoplanète correspondante à cet ID !";
    }
    else liste1.push(el);
  }
    
    res.render('exoplanets/details.hbs', {liste1,no,po});
    
  });*/
// router.get('/details', (req, res) => {
//     let id = parseInt(req.query.exoplanet_id);
//     const details = Exoplanet.findById(id);
//     if (details !== null) {
//         res.render('exoplanets/index.hbs', { details });
//     }
// });
router.get('/details', function (req, res, next) {
    console.log("GET DETAILS EXOPLANET");
    // convert string req.query.id to int
    // another solution is to use == instead of === in if instruction
    const exoplanetIdParam = parseInt(req.query.exoplanet_id);
    let exoplanetFound = Exoplanet.findById(exoplanetIdParam);
    res.render('exoplanets/details.hbs', { exoplanetFound });

});

router.get('/filter', function (req, res, next) {
    const filter = req.query.filter;
    let exoplanetsTableFilter = [];
    if (filter === "Filtrer par hclass") {
      console.log("GET FILTER EXOPLANET HCLASS");
      exoplanetsTableFilter = Exoplanet.searchByHclass(req.query.hclass);
    }
    if (filter === "Filtrer par année") {
      console.log("GET FILTER EXOPLANET ANNEE");
      const discoveryYearParam = parseInt(req.query.discovery_year);
      exoplanetsTableFilter = Exoplanet.searchByYear(discoveryYearParam);
      }
    // param exoplanetsTable must be the same but with a different value (table filtering)
    res.render('exoplanets/index.hbs', { exoplanetsTable: exoplanetsTableFilter });
});

  

// display form to update exoplanet
router.get('/update', function (req, res, next) {
    console.log("GET UPDATE EXOPLANET");
    const exoplanetIdParam = parseInt(req.query.exoplanet_id);
    const exoplanetFound = Exoplanet.findById(exoplanetIdParam);
    res.render('exoplanets/update.hbs', { exoplanet: exoplanetFound });
});


/* POST update exoplanet. */
router.post('/update', function (req, res, next) {
    console.log("POST UPDATE EXOPLANET");
    Exoplanet.save({
        exoplanet_id: parseInt(req.body.exoplanet_id),
        unique_name: req.body.unique_name,
        hclass: req.body.hclass,
        discovery_year: parseInt(req.body.discovery_year),
        ist: parseFloat(req.body.ist),
        pclass: req.body.pclass
    });

    res.redirect('/exoplanets');
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