import { Component, OnInit } from '@angular/core';
import { FormsModule, FormControl, Validators, FormGroup, FormBuilder  } from '@angular/forms';
import { User } from '../../../class/user'
import { UserService } from '../../../service/user.service';

@Component({
 selector: 'app-sign-in',
 templateUrl: './sign-in.component.html',
 styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

 constructor(private userService: UserService){}

 message:string = '';
 loginStatus:any;
 hide = true;
 error:string = '';
 hintPseudo:string = 'test';


 signInJSON: any = {
   "id":0,
   "pseudo": '',
   "pwd": '',
   "idPerson": {},
   "idSecurityLevel": {}
 };

 
 ngOnInit(): void {
   this.message = '';
 }

 messagePseudo:string = "Votre Pseudo # Votre ID"


 onSubmit(){

   //Vérification de la présence d'un # dans le champ pseudo
   if(this.signInJSON.pseudo.indexOf('#') > -1){
     this.error = '';

     //Recupération du speudo et split
     let id:any = this.signInJSON.pseudo.split("#",2)

     //Extraction de l'id et pseudo et affectation au json
     this.signInJSON.pseudo = id[0]
     this.signInJSON.id = id[1];
     

     //Création de l'objet User à partir du JSON
     let credentials:User = new User( this.signInJSON );
     console.log(credentials);

     //Appel du WebService
     this.userService.login(credentials).subscribe(data => {this.loginStatus = data; console.log(data) ; this.login();});
     
   }
   else{this.error = 'Il manque le #'; this.verifForm()}
 }

 login(){
   
   if(this.loginStatus === true){
     this.message = 'Bonjour ' + (this.signInJSON.pseudo);
     
   }
   else{
     this.message = 'Bonjour les informations saisi semblent erronées';
   }
   
 }

 verifForm()
 {
   return this.error;
 }

}
