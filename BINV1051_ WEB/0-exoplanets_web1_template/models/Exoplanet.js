const db = require('../models/db_conf'); 

let listeExoplanetes = []

module.exports.list = () => {
    const stmt_all = db.prepare("SELECT exoplanet_id, unique_name , hclass, discovery_year, ist, pclass FROM exoplanets;");
    return stmt_all.all();
};

  
module.exports.add = (exoplanet) => {
    const stmt_insert = db.prepare('INSERT INTO exoplanets (unique_name, hclass, discovery_year, ist, pclass) VALUES (?, ?, ?, ? ,?)');
    //run -> return infos about changes made
    const info = stmt_insert.run(exoplanet.unique_name, exoplanet.hclass, exoplanet.discovery_year, exoplanet.ist, exoplanet.pclass);
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
