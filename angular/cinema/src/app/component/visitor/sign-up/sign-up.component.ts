import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { UserService } from '../../../service/user.service';
import { User } from '../../../class/user';
import { Person } from '../../../class/person'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  errorEmail:boolean = false;
  
  email = new FormControl('', [Validators.required, Validators.email]);
  pwd = new FormControl('', [Validators.required]);
  pseudo = new FormControl('', [Validators.required]);

  getErrorMessageEmail() {

    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  //Variable pour afficher le mdp
  hide = true;
 
  personJSON:any = {};
  persone:Person = new Person(this.personJSON);

  

  emailFree:any;

  constructor(private userService: UserService) { }


  ngOnInit(): void {
  }

  onSubmit(): void {

    let userJSON:any = {
      "id":0,
      "idSecurityLevel": {},
      "pseudo": this.pseudo.value,
      "pwd": this.pwd.value,
      "idPerson": {"email":this.email.value}
      };

    //Vérification du formulaire (clairement à améliorer ...)
    if(this.pwd.value.length > 5 && this.pseudo.value.length > 0 && !this.email.hasError('email') ){
    //Appel du service pour vérifier si l'email est déja utilisé
    this.userService.isEmailFree(this.email.value).subscribe(data => {this.emailFree = data;


    if(this.emailFree){
        console.log(userJSON);
        let toPost: User = new User(userJSON);
        this.userService.save(toPost).subscribe(data => {
          
        });
        userJSON = {};
        this.email = new FormControl('', [Validators.required, Validators.email]);
  }
  else{ alert('This email : '+ this.email.value + ' is already use, please try again with another !')}
  ;});
}
else{}
}


}
