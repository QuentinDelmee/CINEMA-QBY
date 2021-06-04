import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) {
  }

  currentPage: boolean[] = [false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false];
  previousPage: number = 0;

  stringAccess: any = sessionStorage.getItem('access') ;
  currentAccess:number =  Number(this.stringAccess) ;

  ngOnInit(): void {
    if (window.location.href.match("home-page")?.length) {
      this.currentPage[0] = true;
      this.previousPage = 0;
    }
    else if (window.location.href.match("movie-page")?.length){
      this.currentPage[1] = true;
      this.previousPage = 1;
    }
    else if (window.location.href.match("timetable-page")?.length){
      this.currentPage[2] = true;
      this.previousPage = 2;
    }
    else if (window.location.href.match("signin")?.length){
      this.currentPage[3] = true;
      this.previousPage = 3;
    }
    else if (window.location.href.match("signup")?.length){
      this.currentPage[4] = true;
      this.previousPage = 4;
    }
    else if (window.location.href.match("quizz-page")?.length){
      this.currentPage[5] = true;
      this.previousPage = 5;
    }
    else if (window.location.href.match("user/profil")?.length){
      this.currentPage[6] = true;
      this.previousPage = 6;
    }
    else if (window.location.href.match("user/reservation-page")?.length){
      this.currentPage[7] = true;
      this.previousPage = 7;
    }
    else if (window.location.href.match("admin")?.length){
      this.currentPage[8] = true;
      this.previousPage = 8;
    }
  }

  updatePage(index: number) {
    this.currentPage[this.previousPage] = false;
    this.currentPage[index] = true;
    this.previousPage = index;
  }
}
