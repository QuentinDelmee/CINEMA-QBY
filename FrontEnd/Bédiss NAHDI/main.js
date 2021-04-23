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




