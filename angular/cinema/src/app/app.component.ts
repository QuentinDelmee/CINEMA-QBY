import { Component } from '@angular/core';
import { CinemaRoom } from './class/cinema-room';
import { Movie } from './class/movie';
import { Product } from './class/product';
import { Quizz } from './class/quizz';
import { Seat } from './class/seat';
import { Session } from './class/session';
import { CinemaRoomService } from './service/cinema-room.service';
import { MovieService } from './service/movie.service';
import { ProductService } from './service/product.service';
import { QuizzService } from './service/quizz.service';
import { SeatService } from './service/seat.service';
import { SessionService } from './service/session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cinema';


  constructor(private movieS:MovieService,private sessionS:SessionService,private quizzS:QuizzService,private cinemaRoomS:CinemaRoomService, private seatS:SeatService, private productS:ProductService)
  {
    this.persist('access','6');
  }

  persist(key:string,value:any)
  {
    localStorage.setItem(key,value);
  }
}