'use strict'

for (let i = 0; i < 4; i++) {
	
}
setTimeout(init,3000);


function init(){

console.log('hello !');

}


//VAR GLOBAL
var indiceQuestion = 0;

//Créati n d'une fonction pour initialiser un quizz 
function createNewQuizz(){
	const verif = document.getElementById('verification');
	let chrono = document.getElementById('js-chrono');

	//Initialisation du formulaire
	verif.innerHTML = "";


	//POUR PLUS TARD Créer une fonction qui créra de façon automatique les dictionnaires avec clé valeur en fonction de la lecture d'un fichier JSON
	
	//tableau contenant des dictionnaires avec clé/valeurs qui contiennent les choix et questions réponses
	const quizDict = [
		{
			q: '<b>De quelle couleur est le cheval blanc ?<b>',
			choix:['blanc','vert','bleue','gris'],
			reponse:0
		}
		,
		{
			q: '<b>De quelle couleur est le cheval gris ?<b>',
			choix:['blanc','jaune','noir','gris'],
			reponse:3
		}
		,
		{
			q: '<b>5+3<b>',
			choix:['15','4+4','22','Je ne sais pas'],
			reponse:1
		}
	]

	//Création d'un indice aléatoire 
	 //getRndInteger(0, quizDict.length);
	 console.log('taille du quizz : ',quizDict.length);
	 console.log('indicequestion : ',indiceQuestion);

	if(indiceQuestion < quizDict.length){
		indiceQuestion = indiceQuestion + 1
	}

	//Récupération de la réponse en clair (gris ou vert ou bleu ...) par rapport au dictionaire et l'indice utilisé
	const reponse = quizDict[indiceQuestion].choix[quizDict[indiceQuestion].reponse];
	console.log('La rep au debut :', reponse)

	//Récupération à partir du DOM des éléments html pour effectuer des manipulations (Changer la question, Afficher les nouveaux choix des questions)
	const Question = document.getElementById('js-question');
	const ContenaireRadio = document.getElementById('js-contenaireRadio')

	//Vidage boutons radio pour éviter l'ajout à répétition de nouvelles balises radio
	while(ContenaireRadio.firstChild){
		ContenaireRadio.removeChild(ContenaireRadio.firstChild);
	}



	//Pour chaque choix issu de la clé choix du dictionnaire création d'une balise Radio
	for (const element of quizDict[indiceQuestion].choix) {
		const div = document.createElement('div');
		const radio = document.createElement('input');
		const label = document.createElement('label');

		//Affectation des valeurs aux properties sur les éléments html

		//Radio properties
		radio.type = "radio";
		radio.id = element;
		radio.name = "choix";
		
		//Affectation d'une valeur de type boolean de la propriété value (utile pour la vérification de réponse) 
		console.log('Boucle vérif des ID par balise : ', radio.id);
		if(radio.id === reponse){radio.value = true ; console.log('La radio est la vrai', radio.id)}
		else{radio.value = false; console.log('Les radios sont fausses', radio.id)};

		//Label properties
		label.for = element;
		label.innerText = element;


		//Ajout des balises radio et label dans la div
		div.appendChild(radio);
		div.appendChild(label);

		//Ajout de la balise div dans le contenaire
		ContenaireRadio.appendChild(div);
	}

	//Début compte à rebour
	

	//Affichage de la question vers l'html
	Question.innerHTML = '<b>'+quizDict[indiceQuestion].q+'</b>';

	return false;
}



//Fonction qui va vérifier le choix de l'utilisateur au moment de soumettre sa réponse choisi
function verif(){

	//Récupération sous forme de tableau des éléments Html portant l'attribut name
	const listeRadiosBtn = document.getElementsByName('choix');

	//Pour chaque élement (Radio) portant la valeur 'choix' de l'attribut Name
	for (const element of listeRadiosBtn) {

		if(element.value === "true"){var reponse = element.id;}
		//vérification de l'état du bouton radio choisi par l'utilisateur (Activé ou non) 
		if(element.checked === true){var choixUser = element.id; console.log('choix utilisateur :', choixUser);}
		//else{/* Vous n'avez pas selectionné de reponse*/}

		console.log('Valeur du radio :'+element.id+' est : '+element.value)
		//Récupération de la bonne réponse
		//var reponse = element.id; console.log('Fonction vérif la radio juste : ', element.id)}
		//else{var reponse = element.id; console.log('Fonction vérif la radio juste : ', element.id)};

	}


	const verif = document.getElementById('verification');

	if(choixUser === reponse){
		
		verif.innerText = 'C\'est trouvé ! la réponse était : '+reponse;
	}
	else{verif.innerText = 'C\'est perdu ! la réponse était :'+reponse;}

	return false;
}














//Fonction pour retourner un nombre aléatoire avec en parametre les limites mini et max inclu
function getRndInteger(minimum, maximum) {
    return Math.floor(Math.random() * (maximum - minimum)) + minimum;
}


//POUR LES PROCHAINES FOIS
/*
- Régler soucis de porter de variable pour la réponse choix
- Restructurer le dict pour faire en sorte d'utiliser l'ensemble des questions pour un seul quizz avec suivant/précedent etc ... (la gestion de l'aléatoire sera que pour sélectionner un quizz)
- Gérer l'interface
- Corriger code (refactor)
- Voir le css
*/	

/* lien utile : 
POUR OBJET : https://developer.mozilla.org/fr/docs/Web/JavaScript/Guide/Working_with_Objects
POUR GERER LE TEMPS ENTRE CHAQUE ACTIONS : https://www.xul.fr/ecmascript/settimeout.php#:~:text=SetTimeout%20et%20setInterval%3A%20Les%20d%C3%A9lais%20en%20JavaScript%201,peut%20%C3%AAtre%20un%20argument.%20...%204%20D%C3%A9monstration.%20
*/