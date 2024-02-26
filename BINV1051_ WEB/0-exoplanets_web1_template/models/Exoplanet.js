const db = require('../models/db_conf'); 

module.exports.list = () => {
    return db.prepare("SELECT * FROM exoplanets").all();
    //return db.prepare("SELECT * FROM exoplanets").all();

};

  
module.exports.save = (data) => {
    const stmt_insert = db.prepare('INSERT INTO EXOPLANETS(unique_name, hclass, discovery_year) VALUES (?, ?, ?)');
    //run -> return infos about changes made
    const info = stmt_insert.run(data.unique_name, data.hclass, data.discovery_year);
};



module.exports.search = (uniqueName) => {

    return db.prepare('SELECT * FROM EXOPLANETS WHERE unique_name LIKE ?').all(uniqueName + '%');
}


module.exports.delete = (id) => {
    const info = db.prepare('DELETE FROM EXOPLANETS WHERE exoplanet_id = ?').run(id);
    console.log("exoplanet model delete" + info.changes);
};


module.exports.findById = (id) => {
    return db.prepare("SELECT * FROM exoplanets WHERE exoplanet_id = ?").get(id);
};

