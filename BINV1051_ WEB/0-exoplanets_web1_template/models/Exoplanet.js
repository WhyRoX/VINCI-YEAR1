const db = require('../models/db_conf'); 

module.exports.list = () => {
    return db.prepare("SELECT * FROM exoplanets").all();
    //return db.prepare("SELECT * FROM exoplanets").all();

};

  
/*module.exports.save = (data) => {
    const stmt_insert = db.prepare('INSERT INTO EXOPLANETS(unique_name, hclass, discovery_year, ist, pclass) VALUES (?, ?, ?, ?, ?)');
    //run -> return infos about changes made
    const info = stmt_insert.run(data.unique_name, data.hclass, data.discovery_year, data.ist, data.pclass);
};*/
module.exports.save = (data) => {
    console.log("SAVE :" + JSON.stringify(data));
    //no id => add exoplanet
    if (data.exoplanet_id === undefined) {
        const stmt = db.prepare('INSERT INTO EXOPLANETS(unique_name, hclass, discovery_year, ist, pclass) VALUES (?, ?, ?, ?, ?)');
        const info = stmt.run(data.unique_name, data.hclass, data.discovery_year, data.ist, data.pclass);
        console.log("exoplanet model save" + info.changes);
    }
    // id => update exoplanet
    else {
        const stmt = db.prepare('UPDATE EXOPLANETS SET unique_name = ?, hclass = ?, discovery_year = ?, ist = ?, pclass = ? WHERE exoplanet_id = ?');
        const info = stmt.run(data.unique_name, data.hclass, data.discovery_year, data.ist, data.pclass);
        console.log("exoplanet model save update" + info.changes);

    }




};




module.exports.search = (uniqueName) => {

    return db.prepare('SELECT * FROM EXOPLANETS WHERE unique_name LIKE ?').all(uniqueName + '%');
}


module.exports.delete = (exoplanet_id) => {
    const info = db.prepare('DELETE FROM EXOPLANETS WHERE exoplanet_id = ?').run(exoplanet_id);
    console.log("exoplanet model delete" + info.changes);
};


module.exports.findById = (id) => {
    return db.prepare("SELECT * FROM exoplanets WHERE exoplanet_id = ?").get(id);
};


module.exports.searchByHclass = (hclass) => {
    return db.prepare('SELECT * FROM EXOPLANETS WHERE hclass = ?').all(hclass);
}

module.exports.searchByYear = (year) => {
    return db.prepare('SELECT * FROM EXOPLANETS WHERE discovery_year = ?').all(year);
}


