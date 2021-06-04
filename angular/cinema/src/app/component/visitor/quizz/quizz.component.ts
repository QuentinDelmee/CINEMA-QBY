import { Component, OnInit } from '@angular/core';
import { Quizz } from '../../../class/quizz'
import { QuizzService } from '../../../service/quizz.service'

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrls: ['./quizz.component.scss']
})
export class QuizzComponent implements OnInit {

  constructor(private quizzService: QuizzService) { }

  progressBar:number = 100;
  score:number = 0;
  //Permet de récupérer le nombre du quizz en cours

  //Numéro du quizz
  nbStatus:number = 0;

  //Stockage des quizz récupéré de la bdd
  quizz: Quizz[] = [];

  //
  trueAnswer:string = '';
  showAnswer = '';
  answer = '';

  //Récupération du quizz en cours avec accès au données (Questions/Réponses ...) 
  currentQuizz:Quizz = new Quizz({});

  //Variables pour les temporisations
  time:number = 10;
  interval:any ;

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

  shuffleArray(arr:any) {
    arr.sort(() => Math.random() - 0.5);
  }



  nextQuizz(){
    if(this.nbStatus < this.quizz.length){
      this.currentQuizz = this.quizz[this.nbStatus];
      this.nbStatus++
      this.startTimerForSearch()
    }
  }

  correction(){
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
         //statements; 
         break; 
      } 
   } 
    
  }

  //Fonction pour lancer compte à rebour pour rechercher
  startTimerForSearch() {
    this.interval = setInterval(() => {
      if(this.progressBar > 0) {
        this.progressBar -= 10;
      } else {
        //Compteur à réinitialisé
        this.restartTimer();
        //Affichage de la reponse et début compte à rebour pour l'affichage du resultat
        this.startTimerForResult();
      }
    },1000)
  }

  //Fonction pour lancer compte à rebour pour afficher la réponse
  startTimerForResult() {
    this.correction();
    this.answer = this.currentQuizz.explanation
    this.time = 10;
    this.interval = setInterval(() => {
      if(this.progressBar < 100) {
        this.progressBar+=10;

      } else {
        this.showAnswer = "";
        this.answer = "";
        this.restartTimer();
        this.nextQuizz();
      }
    },1000)
  }

restartTimer(){
  clearInterval(this.interval)
}
}
