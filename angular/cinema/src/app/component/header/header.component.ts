import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router, RoutesRecognized, NavigationEnd  } from '@angular/router';
import { filter } from 'rxjs/internal/operators';
import { SignInComponent } from '../visitor/sign-in/sign-in.component';

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

  stringAccess: any = sessionStorage.getItem('access');
  currentAccess: number = Number(this.stringAccess);

  access: boolean[] = [true, false, false, false, false, false, false];


  persist(key: string, value: any) {
    sessionStorage.setItem(key, value);
  }

  logout() {
    sessionStorage.clear();
    this.persist('access', '0');
  }

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
        this.currentAccess = Number(sessionStorage.getItem('access')) ;
        
    });

    if (window.location.href.match("home")?.length) {
      this.currentPage[0] = true;
      this.previousPage = 0;
    }
    else if (window.location.href.match("movie")?.length) {
      this.currentPage[1] = true;
      this.previousPage = 1;
    }
    else if (window.location.href.match("timetable")?.length) {
      this.currentPage[2] = true;
      this.previousPage = 2;
    }
    else if (window.location.href.match("product")?.length) {
      this.currentPage[3] = true;
      this.previousPage = 3;
    }
    else if (window.location.href.match("signin")?.length) {
      this.currentPage[4] = true;
      this.previousPage = 4;
    }
    else if (window.location.href.match("signup")?.length) {
      this.currentPage[5] = true;
      this.previousPage = 5;
    }
    else if (window.location.href.match("quizz-page")?.length) {
      this.currentPage[6] = true;
      this.previousPage = 6;
    }
    else if (window.location.href.match("user")?.length) {
      this.currentPage[7] = true;
      this.previousPage = 7;
    }
    else if (window.location.href.match("admin")?.length) {
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
