import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/class/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  persons : Person[] = [];

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.personService.findAll().subscribe(data => { this.persons = data; });
  }


}
