 import { Component, OnInit } from '@angular/core';
 import { FormsModule, FormControl, Validators, FormGroup, FormBuilder  } from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  hide = true;

  signInJSON: any = {
    "pseudo": '',
    "password": ''
  };

  ngOnInit(): void {
  }


  onSubmit(){
    console.log(this.signInJSON);
  }

}
