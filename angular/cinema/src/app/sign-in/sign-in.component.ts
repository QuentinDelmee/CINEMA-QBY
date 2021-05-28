 import { Component, OnInit } from '@angular/core';
 import {FormControl, Validators, FormGroup, ReactiveFormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  hide = true;

 myForm = new FormGroup({
    speudo: new FormControl('', [
      Validators.required
    ]),
    password: new FormControl('', [
      Validators.required
    ]),
  });

  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){
  };

}
