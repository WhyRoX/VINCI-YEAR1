const express = require('express');
const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  console.log("Je passe par la route /");
  const today = new Date();
  /* Attention Date.now() est tentant mais renvoie une valeur numérique et non un objet Date
  donc impossible de faire ceci par exemple
  let now = Date.now(); 
  now.getFullYear()*/
  const todayString = "Nous sommes le " + today.getDate() + "/" + (today.getMonth() + 1) + "/" + today.getFullYear() + ".";
  const hourtodayString = "Il est " + today.getHours() + ":" + today.getMinutes() + " à Bruxelles";
  // today -> name of variable to pass to hbs
  // after : -> concatenation of two string as value of today
  res.render('index.hbs', { today: todayString + " " + hourtodayString });
});


module.exports = router;
