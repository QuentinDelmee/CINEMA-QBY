import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/class/movie';
import { Session } from 'src/app/class/session';
import { MovieService } from 'src/app/service/movie.service';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-time-table',
  templateUrl: './time-table.component.html',
  styleUrls: ['./time-table.component.scss']
})
export class TimeTableComponent implements OnInit {

  

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  movies: Movie[] = [] ;
  sessions : Session[][] = [] ;

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */
  nbColumn: number = 12;
  nbColSpan: number = 3;
  nbGutterSize: number = 24;
  innerWidth: number = 1440;

  constructor(private movieService: MovieService,private router:Router) { }

  ngOnInit(): void {
    this.onResize();
    this.findAllMovie();
    this.findAllSessions();
    
    
  }

  findAllMovie() {
    this.movieService.findAll().subscribe(data => {
      this.movies = data;
      console.log(this.movies);
      this.findAllSessions() ;
    });
  }

  findAllSessions() {
    this.movies.forEach( elem => {
      this.movieService.findAllSessions(elem.id).subscribe( data => { this.sessions.push(data) ; console.log(this.sessions) ; })
    }) ;
  }

  image(movie: Movie): string {
    if (movie.imageUrl === "N/A" || !movie.imageUrl || movie.imageUrl === "") {
      return '../../../assets/img/image-not-found.png';
    }
    else { return movie.imageUrl; }
  }

  redirection()
  {
    const access:number = Number(sessionStorage.getItem('access')) ;
    if( access == 0 )
    {
      this.router.navigate(['/signin']);
    }
    else if( access == 1 )
    {
      this.router.navigate(['/user/reservation/create']) ;
    }
    else
    {
      this.router.navigate([''])
    }
  }

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  @HostListener('window:resize', ['$event'])
  onResize() {
    this.innerWidth = window.innerWidth;
    this.updateColumn();
  }

  updateColumn(): void {
    if (this.innerWidth > 1240) {
      this.nbColumn = 12;
      this.nbColSpan = 3;
      this.nbGutterSize = 24;
    }
    else if (this.innerWidth > 904) {
      this.nbColumn = 12;
      this.nbColSpan = 4;
      this.nbGutterSize = 24;
    }
    else if (this.innerWidth > 599) {
      this.nbColumn = 8;
      this.nbColSpan = 4;
      this.nbGutterSize = 24;
    }
    else {
      this.nbColumn = 4;
      this.nbColSpan = 2;
      this.nbGutterSize = 16;
    }
  }

}
