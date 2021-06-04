import { Component, OnInit } from '@angular/core';
import { Quizz } from '../../../class/quizz'
import { QuizzService } from '../../../service/quizz.service'


@Component({
  selector: 'app-quizz-on-phone',
  templateUrl: './quizz-on-phone.component.html',
  styleUrls: ['./quizz-on-phone.component.scss']
})
export class QuizzOnPhoneComponent implements OnInit {

  constructor(private quizzService: QuizzService) { }

  colorTab: string[] = ['primary', 'primary', 'primary', 'primary']
  nextBtnVisibility:boolean = true;



  score: number = 0;

  //Numéro actuel du quizz
  nbStatus: number = 0;

  //Stockage des quizz récupéré de la bdd
  quizz: Quizz[] = [];

  //
  trueAnswer: string = '';
  showAnswer = '';
  explanation = '';

  //Récupération du quizz en cours avec accès au données (Questions/Réponses ...) 
  currentQuizz: Quizz = new Quizz({});

  //Variables pour les temporisations
  time: number = 10;
  interval: any;

  /////////////////////////////////
  //         FUNCTIONS           //
  /////////////////////////////////

  ngOnInit(): void {
    this.quizzService.findAll().subscribe(data => {
      this.quizz = data;
      this.shuffleArray(this.quizz)
      this.nextQuizz()
    })
  }

  shuffleArray(arr: any) {
    arr.sort(() => Math.random() - 0.5);
  }



  nextQuizz() {
    if (this.nbStatus < this.quizz.length) {
      this.nextBtnVisibility = true;
      this.btnInitColor();
      this.currentQuizz = this.quizz[this.nbStatus];
      this.nbStatus++
      this.showAnswer = '';
      this.explanation = '';
    }
  }


  choiceUser(nb: number) {
    if (this.currentQuizz.trueAnswer === nb) {
      console.log('yes !');
    }
    else {
      console.log('no :(')
    }

    this.correction(nb);
  }


  correction(nb:number) {
    this.nextBtnVisibility = false;
    const answer:number = this.currentQuizz.trueAnswer ;

    if( nb === answer )
    {
      this.colorTab[nb-1] = 'accent' ;
    }
    else{
      this.colorTab[nb-1] = 'warn' ;
      this.colorTab[answer-1] = 'accent' ;
    }

      switch(this.currentQuizz.trueAnswer) { 

      case 1: {
        this.showAnswer = this.currentQuizz.answer1;
        break; 
      } 
      case 2: { 
        this.showAnswer = this.currentQuizz.answer2; 
        break; 
      }
      case 3: { 
        this.showAnswer = this.currentQuizz.answer3;
        break; 
      } 
      case 4: {
        this.showAnswer = this.currentQuizz.answer4;
        break; 
      } 
      default: { 
        break; 
      }

     }
    this.explanation = this.currentQuizz.explanation;

  }


  btnInitColor() {
    this.colorTab = ['primary', 'primary', 'primary', 'primary']
  }


}
