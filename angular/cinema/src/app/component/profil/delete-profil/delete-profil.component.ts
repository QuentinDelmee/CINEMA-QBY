import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/class/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-delete-profil',
  templateUrl: './delete-profil.component.html',
  styleUrls: ['./delete-profil.component.scss']
})
export class DeleteProfilComponent implements OnInit {

  constructor(private personService: PersonService) { }

  selectedPerson: Person = new Person({});

  persons: Person[] = [];

  ngOnInit(): void {
    this.personService.findAll().subscribe(data => { this.persons = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Person ?")) {
      console.log(this.selectedPerson) ;
      this.personService.delete(this.selectedPerson.id).subscribe() ;
    }
    else {
      console.log("Delete Person ABORTED");
    }
  }

}
