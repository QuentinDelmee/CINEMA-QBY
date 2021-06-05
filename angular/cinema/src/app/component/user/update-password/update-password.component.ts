import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/class/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-update-profil',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.scss']
})
export class UpdatePasswordComponent implements OnInit {

  constructor(private userService: UserService){}

 message:string = '';
 loginStatus:any;
 hide = true;
 error:string = '';
 hintPseudo:string = 'test';
 newPassword:string = '' ;

 signInJSON: any = {
   "id":0,
   "pseudo": '',
   "pwd": '',
   "idPerson": {},
   "idSecurityLevel": {}
 };

 user:User = new User( {"id":42,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":42,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )


 
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
     this.message = 'Password Updated' ;
     this.user.pwd = this.newPassword ;
     this.userService.save(this.user).subscribe();
   }
   else{
     this.message = 'Error Wrong Password or Login';
   }
   
 }

 verifForm()
 {
   return this.error;
 }

}
