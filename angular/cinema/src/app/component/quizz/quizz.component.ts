import { Component, OnInit } from '@angular/core';
import { Quizz } from '../../class/quizz'
import { QuizzService } from '../../service/quizz.service'

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrls: ['./quizz.component.scss']
})
export class QuizzComponent implements OnInit {

  constructor(private quizzService: QuizzService) { }

  score:number = 0;
  //Permet de récupérer le nombre du quizz en cours


  nbStatus:number = 0;

  test:string = '';
  quizz: Quizz[] = [];
  trueAnswer:string = '';
  btnColor1 = 'primary';
  btnColor2 = 'primary';
  btnColor3 = 'primary';
  btnColor4 = 'primary';

  answer = '';

  currentQuizz:Quizz = new Quizz({});


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


  onSubmit(nb:number){
    this.restartTimer();

    //Vérification rep
    if(nb === this.currentQuizz.trueAnswer){
      this.score += 1;
      console.log('cetait juste', this.score)
    }
    else{console.log('cetait mauvais')}
    
    //Gérer partie visuel des boutons

    //Etape suivante
    this.startTimerForResult();
    

  }

  //Fonction pour lancer compte à rebour pour rechercher
  startTimerForSearch() {
    this.interval = setInterval(() => {
      if(this.time > 0) {
        this.time--;
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
    this.answer = this.currentQuizz.explanation
    this.time = 10;
    this.interval = setInterval(() => {
      if(this.time > 0) {
        this.time--;
      } else {
        this.answer = "";
        this.restartTimer();
        this.nextQuizz();
      }
    },1000)
  }

restartTimer(){
  clearInterval(this.interval)
  this.time = 10;
}
}
