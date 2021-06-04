import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/class/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-update-profil',
  templateUrl: './update-profil.component.html',
  styleUrls: ['./update-profil.component.scss']
})
export class UpdateProfilComponent implements OnInit {

  constructor(private personService: PersonService) { }

  selectedPerson: Person = new Person({});

  persons: Person[] = [];

  ngOnInit(): void {
    this.personService.findAll().subscribe(data => { this.persons = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to update this Person ?")) {
      this.personService.save(this.selectedPerson).subscribe();
    }
    else {
      console.log("Update Person ABORTED");
    }
  }

}
