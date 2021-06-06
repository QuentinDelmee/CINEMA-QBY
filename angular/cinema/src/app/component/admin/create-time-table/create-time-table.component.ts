import { Component, OnInit } from '@angular/core';
import { CinemaRoom } from 'src/app/class/cinema-room';
import { Movie } from 'src/app/class/movie';
import { Session } from 'src/app/class/session';
import { CinemaRoomService } from 'src/app/service/cinema-room.service';
import { MovieService } from 'src/app/service/movie.service';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-create-time-table',
  templateUrl: './create-time-table.component.html',
  styleUrls: ['./create-time-table.component.scss']
})
export class CreateTimeTableComponent implements OnInit {

  sessionJSON: any = { "idCinemaRoom":{}, "idMovie":{} };

  allRoom: CinemaRoom[] = [];
  allMovie: Movie[] = [] ;
  allTime: string[] = ["08:00:00","11:00:00","14:00:00","17:00:00","20:00:00"]

  sessionTime:string = "" ;

  constructor(private sessionService: SessionService, private movieService: MovieService, private crService: CinemaRoomService) { }

  ngOnInit(): void {
    this.movieService.findAll().subscribe(data => { this.allMovie = data; });
    this.crService.findAll().subscribe(data => { this.allRoom = data; });
  }

  onSubmit(): void {
    console.log(this.sessionTime);

    if (confirm("Are you sure you want to create this Session ?")) {

        this.allTime.forEach( elem => { 
          console.log(elem) ;
          this.sessionJSON.time = elem ;
          this.sessionJSON.idDate = this.sessionJSON.date +"T"+this.sessionJSON.time ;
          this.sessionJSON.seatsLeft = this.sessionJSON.idCinemaRoom.nbSeats ;
          let toPost: Session = this.sessionJSON;
        this.sessionService.save(toPost).subscribe();
        });
        
    }
    else {
      console.log("New Session ABORTED");
    }
  }
}
