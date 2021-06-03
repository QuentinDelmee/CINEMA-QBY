import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrls: ['./quizz.component.scss']
})
export class QuizzComponent implements OnInit {

  test:string = '';
  quizz: any = { };
  maVariable:string = '';
  constructor() { }

  ngOnInit(): void {

  }

  onSubmit(nb:number){

  }

}
