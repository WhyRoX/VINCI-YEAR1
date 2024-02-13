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


module.exports = router;
