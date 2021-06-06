import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/class/person';
import { User } from 'src/app/class/user';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;
  //user:User = new User( {"id":42,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":42,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )

  constructor(private personService: PersonService) { }

  ngOnInit(): void {

  }


}
