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

  sessionJSON: any = { "idCinema":{}, "idMovie":{} };

  allRoom: CinemaRoom[] = [];
  allMovie: Movie[] = [] ;

  constructor(private sessionService: SessionService, private movieService: MovieService, private crService: CinemaRoomService) { }

  ngOnInit(): void {
    this.movieService.findAll().subscribe(data => { this.allMovie = data; });
    this.crService.findAll().subscribe(data => { this.allRoom = data; });
  }

  onSubmit(): void {

    if (confirm("Are you sure you want to create this Session ?")) {
      let toPost: Session = new Session(this.sessionJSON);
      this.sessionService.save(toPost).subscribe();
    }
    else {
      console.log("New Session ABORTED");
    }
  }
}
