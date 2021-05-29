import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators, Form } from '@angular/forms';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.scss']
})
export class CreateMovieComponent implements OnInit {

  movieJSON: any = {};

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log("TEST");
    console.log(this.movieJSON);
    if( confirm( "Are you sure you want to create this Movie ?") )
    {

    }
    else
    {

    }
  }

}
