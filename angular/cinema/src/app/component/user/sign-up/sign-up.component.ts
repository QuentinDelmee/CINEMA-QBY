import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
import { User } from '../../../class/user';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  hide = true;
  
  userJSON: any = { "idPerson": {} };

  constructor(private userService: UserService) { }


  ngOnInit(): void {
  }

  
  email:FormControl = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  onSubmit(): void {
    console.log("TEST");
    this.userJSON.idPerson.email = this.email.value;
    console.log(this.userJSON);
    if (confirm("Are you sure you want to create this User ?")) {
      let toPost: User = new User(this.userJSON);
      this.userService.save(toPost).subscribe();
    }
    else {
      console.log("New User ABORTED");
    }

    this.userJSON = {} ;
  }




  
}
