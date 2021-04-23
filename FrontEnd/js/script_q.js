"use strict" ;

var currentPWD = 'test' ;


function formPseudo()
{
    const newP = document.getElementById('newpseudo').value ;
    const newE = document.getElementById('newemail').value ;
    const pwd = document.getElementById('pwd').value ;

    if( pwd === currentPWD )
    {
        if( newP  )
        {
            document.getElementById('pseudo').value = newP ;
            document.getElementById('newpseudo').value = '' ;
            console.log('Pseudo Changed') ;
        }
        if( newE )
        {
            document.getElementById('email').value = newE ;
            document.getElementById('newemail').value = '' ;
            console.log('Email Changed') ;
        }
    }
    else
    {
        alert('WRONG PASSWORD')
    }

    return false;
}


function formInfo()
{
    const fname = document.getElementById('fname').value ;
    const lname = document.getElementById('lname').value ;
    const birthdate = document.getElementById('date').value ;
    const genre = document.getElementById('genre').value ;
    const city = document.getElementById('city').value ;

    console.log(fname) ;
    console.log(lname) ;
    console.log(birthdate) ;
    console.log(genre) ;
    console.log(city) ;

    return false ;

}

function formMdP()
{
    const newPWD = document.getElementById('newpwd').value ;
    const cnewPWD = document.getElementById('cnewpwd').value ;
    const pwdact = document.getElementById('pwdact').value ;

    alert('OK') ;

    if( pwdact === currentPWD )
    {
        if( newPWD && cnewPWD && newPWD === cnewPWD )
        {
            currentPWD = newPWD ;
            console.log('PWD Changed: ' + newPWD) ;
        }
        else
        {
            alert('New Passwords does not match') ;
        }

    }
    else
    {
        alert('WRONG PASSWORD') ;
    }

    return false;
}