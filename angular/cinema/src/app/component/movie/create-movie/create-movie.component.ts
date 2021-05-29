import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators, Form } from '@angular/forms';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.scss']
})
export class CreateMovieComponent implements OnInit {

  

  movieForm: FormGroup = new FormGroup({}) ;
  movieJSON: any = {} ;
  title: string = '' ;
  originalTitle: string = '' ;

  
  constructor(private fb: FormBuilder) { 
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log("TEST") ;
    this.movieForm = this.fb.group({
      title: this.title,
      originalTitle: this.originalTitle
    })
    console.log(this.title);
    console.log(this.originalTitle);
    console.log(this.movieForm.value) ;
    console.log(this.movieJSON) ;
  }

}
