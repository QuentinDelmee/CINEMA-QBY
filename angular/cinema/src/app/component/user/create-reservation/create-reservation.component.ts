import { Component, OnInit  } from '@angular/core';
import { Session } from 'src/app/class/session';
import { Movie } from 'src/app/class/movie';
import { Reservation } from 'src/app/class/reservation';
import { Seat } from 'src/app/class/seat';
import { User } from 'src/app/class/user';
import { CinemaRoom } from 'src/app/class/cinema-room' ;
import { MovieService } from 'src/app/service/movie.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';
import { CinemaRoomService } from 'src/app/service/cinema-room.service';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.scss']
})
export class CreateReservationComponent implements OnInit {

  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;

  reservationJSON: any = { "idUser":{}, "idSeat":{ "idCinemaRoom":{} }, "idMovie":{}};

  allUser: User[] = [] ;
  allMovie: Movie[] = [] ;
  allSeat: Seat[] = [] ;
  allSession: Session[] = [] ;

  constructor(private reservationService: ReservationService,private userService:UserService, private movieService:MovieService, private crService:CinemaRoomService) { }

  ngOnInit(): void {
    //this.userService.findAll().subscribe( data => { this.allUser = data ;}) ;
    this.movieService.findAll().subscribe( data => { this.allMovie = data;}) ;
  }

  onSubmit(): void {

    if (confirm("Are you sure you want to create this Reservation ?")) {
      let toPost: Reservation = new Reservation(this.reservationJSON);
      this.reservationService.save(toPost).subscribe();
    }
    else {
      console.log("New Reservation ABORTED");
    }
  }

  updateMovie(movie:Movie): void{
    this.movieService.findAllSessions(movie.id).subscribe( data => { this.allSession = data ;} ) ;

  }
  updateSession(session:Session): void{
    
    this.crService.getAllSeats(session.idCinemaRoom.id).subscribe(  data => { this.allSeat = data ; }) ;
  }

}
