import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../../class/user'
import { UserService } from '../../../service/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  constructor(private route: Router, private userService: UserService) { }


  message: string = '';
  loginStatus: any;
  hide = true;
  error: string = '';
  hintPseudo: string = 'test';


  pwd = new FormControl('', [Validators.required]);
  pseudo = new FormControl('', [Validators.required]);
  
  getErrorMessage() {

    if (this.pwd.hasError('required')) {
      return 'You must enter a value';
    }
    if (this.pseudo.hasError('required')) {
      return 'You must enter a value';
    }

    return ;
  }


  userJSON: any = {
  };


  ngOnInit(): void {
    this.message = '';
  }

  messagePseudo: string = "Votre Pseudo # Votre ID"


  onSubmit() {

     this.userJSON = {
      "id":0,
      "idSecurityLevel": {},
      "pseudo": this.pseudo.value,
      "pwd": this.pwd.value,
      "idPerson": {}
      };

    //Vérification de la présence d'un # dans le champ pseudo
    if (this.userJSON.pseudo.indexOf('#') > -1) {
      this.error = '';

      //Recupération du speudo et split
      let id: any = this.userJSON.pseudo.split("#", 2)

      //Extraction de l'id et pseudo et affectation au json
      this.userJSON.pseudo = id[0]
      this.userJSON.id = id[1];


      //Création de l'objet User à partir du JSON
      let credentials: User = new User(this.userJSON);
      console.log(credentials);

      //Appel du WebService
      this.userService.login(credentials).subscribe(data => { this.loginStatus = data; this.login(); });

    }
    else { this.error = 'Il manque le #'; }
  }

  login() {

    if (this.loginStatus) {

      let currentUser: User;
      this.userService.findById(this.userJSON.id).subscribe(data => {
        currentUser = data;
        sessionStorage.setItem("currentUser", JSON.stringify(currentUser));
        const access: number = currentUser.idSecurityLevel.id;
        sessionStorage.setItem("access", access.toString());
        if (access < 6) {
          this.route.navigate(['/user']);
        }
        else {
          this.route.navigate(['/admin']);
        }
      });

      //window.location.reload() ;
    }
    else{
      alert('Login or password are wrong please try again with correct informations !')
    }

  }

}
