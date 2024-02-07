const express = require('express');
const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  res.render('index.hbs');
});

let listeCommentaires = [];
let testttt = {
  message: "Bonjour, je suis un message",
  auteur: "Moi"
};
listeCommentaires.push(testttt);
router.get("/forum", (req, res) => {
  res.render("forum.hbs", {listeCommentaires});
});
router.post("/forum/add", (req, res) => {
  const newCom = {
    message: req.body.message,
    auteur: req.body.auteur
  };
  listeCommentaires.push(newCom);
  res.redirect("/forum");
});

router.post('/exoplanets/add', (req, res) => {
  const newExoplanet = {
    id: listeExoplanetes.length + 1,
    name: req.body.name,
    hClass: req.body.hClass,
    year: req.body.year
  };
  listeExoplanetes.push(newExoplanet);
  res.redirect('/exoplanets');
});
router.get('/exolunes', (req, res) => {
  let listeexolunes = [];
  let dhtauri = {
    name: "DH Tauri"};
  let kepler409 = {
    name: "Kepler-409"};
  let wasp49 = {
    name: "WASP-49"};
  listeexolunes.push(dhtauri, kepler409, wasp49);
  let ddd = new Date();
  let date = "Nous sommes le " + ddd.getDate() + "/" + ddd.getMonth() + "/" + ddd.getFullYear();
  res.render('exolunes.hbs', {listeexolunes, date});

});
router.get('/telescopes', (req, res) => {
  
  let listetelescopes = [];
  let grantelescopio = {
    name: "Gran Telescopio Canarias",
    location: "Espagne",
    size: "10.4"};
  let keck1 = {
    name: "Keck 1",
    location: "Etats-Unis",
    size: "9.8"
  };
  let seimei = {
    name: "Seimei",
    location: "Japon",
    size: "3.8"};
  let qqch = []
  let txt = { txt: "Il faut au minimum 3 télescopes dans le tableau" };
  let nbrDeTelescopes = 3;
  if (nbrDeTelescopes < 3) {
    listetelescopes.push(grantelescopio, keck1);
    qqch.push(txt);
  }
  else {
    listetelescopes.push(grantelescopio, keck1, seimei);
  };
  res.render('telescopes.hbs', { listetelescopes, qqch });

});

let listeExoplanetes = [];
let trappist = { id: 1, name: "TRAPPIST-1", hClass: "Mésoplanète", year: "2016", IST: 0.9, pClass: "Sous-terrienne chaude"};
let koi = { id: 2, name: "KOI-1686.01", hClass: "Mésoplanète", year: "2011", IST: 0.89, pClass: "Super-terrienne chaude" };
let lhs = { id: 3 , name: "LHS 1723 b", hClass: "Mésoplanète", year: "2017", IST: 0.89, pClass: "Super-terrienne chaude" };
listeExoplanetes.push(trappist, koi, lhs);

let searchResult = null;
let searched = false;
router.get('/exoplanets', (req, res) => {
  const found = searchResult !== null;
  res.render('exoplanets.hbs', { listeExoplanetes, searchResult, found, searched });
});


router.get('/exoplanets/search', (req, res) => {
  searchResult = null;
  searched = false;
  if (req.query.nam) {
    searched = true;
    for (planet of listeExoplanetes) {
      if(planet.name.toLocaleLowerCase().startsWith(req.query.name.toLocaleLowerCase())){  
        console.log("trouvé")
        found = planet;
        searchResult = planet.name;
        break;
      }
    }
  }
  
  res.redirect('/exoplanets');
});

router.get('/exoplanets/details', (req, res) => {
  let errorType = null;
  let id = parseInt(req.query.id);
  if (isNaN(id)) {
    errorType = "entier";
    res.render('error.hbs', {message: "Erreur l'id n'est pas un entier", errorType: errorType});
  } else {
    let found = false;
    let details = null;
    for (planet of listeExoplanetes) {
      if (planet.id === id) {
        found = true;
        details = planet;
        break;
      }
    }
    if (found) {
      res.render('exoplanets.hbs', {details: details, found: true});
    } else {
      errorType = "inexistant"; // i'm not actually using it, since I just use an else in the error.hbs
      res.render('error.hbs', {message: "Aucune Exoplanète correspondante à cet ID !", errorType: errorType});
    }
  }
});






module.exports = router;
