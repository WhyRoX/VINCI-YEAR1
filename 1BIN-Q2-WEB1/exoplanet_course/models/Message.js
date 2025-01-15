const messagesTable = [];

module.exports.list = () => {
    return messagesTable;
};

module.exports.save = (data) => {
    data.id = messagesTable.length + 1;
    data.nbLikes = 0;
    messagesTable.push(data);
};

module.exports.like = (id) => {
    for (let message of messagesTable) {
        if (message.id == id) {
            message.nbLikes++;
            break;
        }
    }
};

