import { Component, OnInit } from '@angular/core';
import { User } from '../../class/user'
import { UserService } from '../../service/user.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService) { 
    //this.userService.findAll().then( data => { this.users = data }).catch( error => { console.log("Promise rejected with Error: ", error)})
  }

  users: User[] = [];

  ngOnInit(): void {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
    
  } 

  deleteByIdUser(user: User) {

    //Appel du service delete by id avec en paramètre le User selectionné à partir du tableau => voir service

    if (confirm("Are you sure you want to delete " + user.pseudo + " User ?")) {
      console.log(user.id);
      this.userService.deleteById(user.id);
      this.users.splice(0,1);
    }
    else {
      console.log("Delete User ABORTED");
    }
  }

  track(index: number, user: User) {
    return user.id;
  }

}
