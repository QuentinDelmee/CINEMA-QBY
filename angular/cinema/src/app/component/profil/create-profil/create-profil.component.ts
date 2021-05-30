import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/class/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-create-profil',
  templateUrl: './create-profil.component.html',
  styleUrls: ['./create-profil.component.scss']
})
export class CreateProfilComponent implements OnInit {

  personJSON: any = {};

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log("TEST");
    console.log(this.personJSON);
    if (confirm("Are you sure you want to create this Person ?")) {
      let toPost: Person = new Person(this.personJSON);
      this.personService.save(toPost).subscribe();
    }
    else {
      console.log("New Person ABORTED");
    }
  }

}
