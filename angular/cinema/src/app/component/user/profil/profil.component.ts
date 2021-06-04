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

  user:User = new User( {"id":42,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{} ,"idSecurityLevel":{}} )

  constructor(private personService: PersonService) { }

  ngOnInit(): void {

  }


}
