 import { Component, OnInit } from '@angular/core';
 import { FormsModule, FormControl, Validators, FormGroup, FormBuilder  } from '@angular/forms';
import { User } from '../../class/user';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  constructor(private userService: UserService){}

  hide = true;

  signInJSON: any = {
    "id":0,
    "pseudo": '',
    "pwd": '',
    "idPerson":0,
    "idSecurityLevel":0
  };

  ngOnInit(): void {
  }


  onSubmit(){
    //Recupération du speudo et split
    let id:any = this.signInJSON.pseudo.split("#",2)

    //Extraction de l'id et affectation au json
    this.signInJSON.id = id[1];

    console.log(this.signInJSON);

    //Création de l'objet User à partir du JSON
    let credentials:User = new User( this.signInJSON );

    //Appel du WebService
    this.userService.login(credentials).subscribe();

  }

}
