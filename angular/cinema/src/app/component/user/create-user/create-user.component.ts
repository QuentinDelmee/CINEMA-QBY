import { Component, OnInit } from '@angular/core';
import {User} from '../../../class/user'
import {UserService} from '../../../service/user.service'

import {SecurityLevel} from '../../../class/security-level'
import {SecurityLevelService} from '../../../service/security-level.service'

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  accountRoles: SecurityLevel[] = [];

  test = new SecurityLevel(1,);
  userJSON: any = {};


  constructor(private userService: UserService, private securityLevelService: SecurityLevelService) { }

  ngOnInit(): void {
    /*this.securityLevelService.findAll().subscribe(data => { this.accountRoles = data; 
    });*/
  }
  
  
  onSubmit(): void {

    console.log(this.userJSON);
    if (confirm("Are you sure you want to create this User ?")) {

      //Affectation du json à l'objet user
      let toPost: User = new User(this.userJSON);

      //appel du service pour créer le user
      this.userJSON.save(toPost).subscribe();
    }
    else {
      console.log("New User ABORTED");
    }

    this.userJSON = {} ;
    
  }

}
