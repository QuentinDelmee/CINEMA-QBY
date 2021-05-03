console.log("test");

/*J'ai mis en premier dans ma balise form :
                        <form onsubmit="return maFonction()">*/

function maFonction(){
    /*Quand on va appuyez sur le boutton valider on récupère tout
         ===> donc je récupère mes id (un par un)
     */
    //pseudo
    let valuePseudo = document.getElementById('pseudo').value;
    console.log(valuePseudo);
  
    // confirmation pseudo
    let valueConfirmPseudo = document.getElementById('confirm-pseudo').value;
    console.log(valueConfirmPseudo);

    // email
    let valueEmail = document.getElementById('email').value;
    console.log(valueEmail);

    // confirmation email
    let valueConfirmEmail = document.getElementById('confirm-email').value;
    console.log(valueConfirmEmail);

    // mot de passe 
    let valueMotDePasse = document.getElementById('motdepasse').value;
    console.log(valueMotDePasse);

    // confirmation mot de passe 
    let valueConfirmMotDePasse = document.getElementById('confirm-motdepasse').value;
    console.log(valueConfirmMotDePasse);

    if (valuePseudo === valueConfirmPseudo){
        if (valueEmail === valueConfirmEmail){
            if (valueMotDePasse === valueConfirmMotDePasse){
                alert('Vos données sont envoyés à la BDD :)')
            } else {
                alert("Merci de vérifier vos saisies de mot de passe !");
            }
        } else {
            alert("Merci de vérifier vos saisies d'email !");
        } 
    } else {
        alert("Merci de vérifier que les pseudo soient identiques !");
    }

    return false;
}


/* 
    Question :
        - Il y a un texte,
        - list de résponses [],
        - création de question, / fonction
        - désactiver la question (lorsqu"on  adéja répondu), / fonction
        - supprimer la question, / fonction

Il faut être capable de :
        - Créer / supprimer une fonction
        - Savoir quand on a répondu à une question
        - Savoir si la réponse est correcte ou non (priviligier le switch)
*/

const Question = function (questionBobjet){
    this.value ={
        text: 'Question : Quel est le nom de notre formateur ib pour la POEC DU 15/03/2021 au 07/06/2021 ?';
        reponse :[]

    }
}



