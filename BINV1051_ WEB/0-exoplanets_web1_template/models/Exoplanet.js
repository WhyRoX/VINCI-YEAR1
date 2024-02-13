const { search } = require("../routes/exoplanets");

const listeExoplanetes = [];
let trappist = { id: 1, name: "TRAPPIST-1", hClass: "Mésoplanète", year: "2016", IST: 0.9, pClass: "Sous-terrienne chaude"};
let koi = { id: 2, name: "KOI-1686.01", hClass: "Mésoplanète", year: "2011", IST: 0.89, pClass: "Super-terrienne chaude" };
let lhs = { id: 3, name: "LHS 1723 b", hClass: "Mésoplanète", year: "2017", IST: 0.89, pClass: "Super-terrienne chaude" };
listeExoplanetes.push(trappist,koi,lhs);

module.exports.list = () => {
    return listeExoplanetes;
};
  
module.exports.add = (data) => {
    listeExoplanetes.push(data);
};



module.exports.search = (name) => {
    if (name) {
        for (planet of listeExoplanetes) {
            if(planet.name.toLocaleLowerCase().startsWith(name.toLocaleLowerCase())){  
                console.log("trouvé");
                return planet;
        }
      }
    }
    return null;
}
module.exports.findById = (id) => {
    let details = null;
    for (planet of listeExoplanetes) {
        if (planet.id === id) {
            details = planet;
            break;
        }
    }
    return details;
}

//module.exports.searchResult = searchResult;
//module.exports.searched = searched;
