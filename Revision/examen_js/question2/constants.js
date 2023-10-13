const { Router } = require("express");

const users = ["user1", "user2", "user3"];
const products = [
    {
        "id": 1,
        "name": "product1",
        "price": 10,
    },
    {
        "id": 2,
        "name": "product2",
        "price": 20,
    },
    {
        "id": 3,
        "name": "product3",
        "price": 30,
    },
    {
        "id": 4,
        "name": "product4",
        "price": 40,
    },
    {
        "id": 5,
        "name": "product5",
        "price": 50,
    },
];
let historique = [];
try {
  const historiqueData = fs.readFileSync('historique.json', 'utf8');
  historique = JSON.parse(historiqueData);
} catch (err) {
  console.error("Erreur lors de la lecture de l'historique :", err);
}

//L’opération doit prendre en entrée le pseudo de l’utilisateur, l’ID du produit acheté et la 
//quantité achetée. L’opération doit échouer si le pseudo n’est pas parmi les pseudos existants, 
//ainsi que si l’ID du produit n’est pas parmi les produits existants. Enregistrez l’achat dans 
//une liste sauvegardée dans un fichier historique.json
Router.get("/purchase" , (req, res) => {
    const { pseudo, id, quantity } = req.body;
    if (users.includes(pseudo) && products.includes(id)) {
        const purchase = {
            pseudo: pseudo,
            id: id,
            quantity: quantity,
        };
        console.log(purchase);
        fs.readFile('historique.json', 'utf8', function readFileCallback(err, data){
            if (err){
                console.log(err);
            } else {
            obj = JSON.parse(data); //now it an object
            obj.table.push(purchase); //add some data
            json = JSON.stringify(obj); //convert it back to json
            fs.writeFile('historique.json', json, 'utf8', callback); // write it back
        }});
        res.send(purchase);
        historique.json.push(purchase);
    } else {
        res.send("L’opération doit échouer si le pseudo n’est pas parmi les pseudos existants, ainsi que si l’ID du produit n’est pas parmi les produits existants.");
    }
});

//Cette opération doit avoir le chemin /purchases/:productId.
//L’opération doit prendre en entrée l’ID d’un produit. Elle doit échouer si l’ID du produit n’est 
//pas parmi les produits existants. Cette opération renvoie le pseudo de l’utilisateur ayant 
//acheté le plus d’unités de ce produit, selon la liste des achats enregistré dans le fichier 
//historique.json
Router.get("/purchases/:productId" , (req, res) => {
    const { productId } = req.params;
    if (products.includes(productId)) {
        const purchase = {
            productId: productId,
        };
        console.log(purchase);
        fs.readFile('historique.json', 'utf8', function readFileCallback(err, data){
            if (err){
                console.log(err);
            } else {
            obj = JSON.parse(data); //now it an object
            obj.table.push(purchase); //add some data
            json = JSON.stringify(obj); //convert it back to json
            fs.writeFile('historique.json', json, 'utf8', callback); // write it back
        }});
        res.send(purchase);
    } else {
        res.send("L’opération doit échouer si l’ID du produit n’est pas parmi les produits existants.");
    }
});

//Cette opération doit avoir le chemin /recommendations/:username.
//L’opération doit prendre en entrée le pseudo de l’utilisateur. Elle doit échouer si le pseudo 
//n’est pas parmi les pseudos existants. Cette opération renvoie le produit recommandé pour
//cet utilisateur. Pour cette maquette, choisissez un produit aléatoirement parmi la liste des 
//produits existants.
Router.get("/recommendations/:username" , (req, res) => {
    const { username } = req.params;
    if (users.includes(username)) {
        const recommendation = {
            username: username,
        };
        console.log(recommendation);
        res.send(recommendation);
    } else {
        res.send("L’opération doit échouer si le pseudo n’est pas parmi les pseudos existants.");
    }
});

module.exports = { users, products };