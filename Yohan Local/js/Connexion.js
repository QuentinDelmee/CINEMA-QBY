'use strict'

init();

function init(){
console.log('hello !');

	
}

//Création d'une fonction pour initialiser un quizz 
function checkCredentials(){
	//Récupération des saisies formulaire

	const pseudo = document.getElementById('js-pseudo').value;
	const password = document.getElementById('js-password').value;
	const loginError = document.getElementById('js-loginError');

	loginError.hidden = true;

	//Plus tard créer ici une fonction allant vers JAVA avec en param pseudo et pwd crypté 
	const tempBddPseudo = "test";
	const tempBddPassword = "test";


	//Traitement des conditions
	if(pseudo === tempBddPseudo && password === tempBddPassword)
	{console.log("ok mdp et pseudo")}
	else{loginError.hidden = false ;loginError.innerHTML = "Erreur de connexion vérifiez vos informations d'identifications";}

	console.log("Pseudo ecrit : ",pseudo);
	console.log("Pseudo BDD : ",tempBddPseudo);

	console.log("MDP ecrit : ",password);
	console.log("MDP BDD : ",tempBddPassword);

	return false;
}



