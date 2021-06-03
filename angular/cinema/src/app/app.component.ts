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
    let movies:Movie[] ;
    movieS.findAll().subscribe(data => { movies = data ; this.persist('movies',JSON.stringify(movies))}) ;
    let sessions:Session[] ;
    sessionS.findAll().subscribe(data => { sessions = data ; this.persist('sessions',JSON.stringify(sessions))});
    let quizz:Quizz[] ; 
    quizzS.findAll().subscribe(data => { quizz = data ; this.persist('quizz',JSON.stringify(quizz))}) ;
    let cinemaRoom:CinemaRoom[] ; 
    cinemaRoomS.findAll().subscribe(data => { cinemaRoom = data ; this.persist('cinemaRoom',JSON.stringify(cinemaRoom))}) ;
    let seats:Seat[] ;
    seatS.findAll().subscribe(data => { seats = data ; this.persist('seats',JSON.stringify(seats))}) ;
    let products:Product[] ;
    productS.findAll().subscribe(data => { products = data ; this.persist('products',JSON.stringify(products))}) ;

    this.persist('access','0');

  }

  persist(key:string,value:any)
  {
    localStorage.setItem(key,value);
  }
}