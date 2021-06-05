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
    if( sessionStorage.getItem('access') === null )
      this.persist('access','0');
  }

  persist(key:string,value:any)
  {
    sessionStorage.setItem(key,value);
  }
}