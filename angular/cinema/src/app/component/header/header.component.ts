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

  stringAccess: any = sessionStorage.getItem('access');
  currentAccess: number = Number(this.stringAccess);


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
  }
    
}
