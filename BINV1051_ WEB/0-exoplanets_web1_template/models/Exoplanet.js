const db = require('../models/db_conf'); 

module.exports.list = () => {
    return db.prepare("SELECT * FROM exoplanets").all();
    //return db.prepare("SELECT * FROM exoplanets").all();

};

  
module.exports.add = (exoplanet) => {
    const stmt_insert = db.prepare('INSERT INTO exoplanets (unique_name, hclass, discovery_year, ist, pclass) VALUES (?, ?, ?, ? ,?)');
    //run -> return infos about changes made
    const info = stmt_insert.run(exoplanet.unique_name, exoplanet.hclass, exoplanet.discovery_year, exoplanet.ist, exoplanet.pclass);
};



module.exports.search = (unique_name) => {

    return db.prepare('SELECT * FROM exoplanets WHERE unique_name LIKE ?').all(unique_name + '%');
}


module.exports.delete = (id) => {
    const info = db.prepare('DELETE FROM exoplanets WHERE exoplanet_id = ?').run(id);
    console.log("exoplanet model delete" + info.changes);
};



/*module.exports.findById = (id) => {
    let details = null;
    for (planet of listeExoplanetes) {
        if (planet.exoplanet_id === id) {
            details = planet;
            break;
        }
    }
    return details;
}*/
module.exports.findById = (id) => {
    return db.prepare("SELECT * FROM exoplanets WHERE exoplanet_id = ?").get(id);
};

//module.exports.searchResult = searchResult;
//module.exports.searched = searched;
