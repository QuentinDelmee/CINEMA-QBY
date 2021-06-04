import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cinema';


  constructor()
  {
    this.persist('access','6');
  }

  persist(key:string,value:any)
  {
    sessionStorage.setItem(key,value);
  }
}