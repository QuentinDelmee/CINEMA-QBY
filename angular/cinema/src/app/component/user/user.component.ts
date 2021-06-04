import { Component, OnInit } from '@angular/core';
import { User } from '../../class/user'
import { UserService } from '../../service/user.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  hover:string = 'primary' ;

  constructor(private userService: UserService) { 
    //this.userService.findAll().then( data => { this.users = data }).catch( error => { console.log("Promise rejected with Error: ", error)})
  }


  ngOnInit(): void {
  } 



}
