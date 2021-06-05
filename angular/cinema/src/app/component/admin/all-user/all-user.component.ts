import { Component, OnInit } from '@angular/core';
import { User } from '../../../class/user'
import { UserService } from '../../../service/user.service'

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.scss']
})
export class AllUserComponent implements OnInit {

  constructor(private userService: UserService) { }

  selectedUser:User = new User({ "idPerson":{}, "idSecurityLevel":{} }) ;
  users:User[] = [] ;

  //user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )


  ngOnInit(): void {
    this.findAll() ;
  }

  findAll()
  {
    this.userService.findAll().subscribe( data => { this.users = data ; console.log(data) })
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to update this Person ?")) {
      this.userService.save(this.selectedUser).subscribe();
      window.location.reload() ;
    }
    else {
      console.log("Update Person ABORTED");
    }
  }

  delete(user:User,index:number) {
    if (confirm("Are you sure you want to delete this Person ?")) {
      this.userService.deleteById(user.id);
      this.users.splice(index,1);
      window.location.reload() ;
    }
    else {
      console.log("Delete Person ABORTED");
    }
  }

}
