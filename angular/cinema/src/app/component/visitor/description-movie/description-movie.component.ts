import { Component, OnInit, ViewChild } from '@angular/core';
import { Movie } from '../../../class/movie';
import { MovieService } from '../../../service/movie.service'
import { ActivatedRoute, Router } from '@angular/router';
import { Commentary } from 'src/app/class/commentary';
import { Session } from 'src/app/class/session';
import { CommentaryService } from 'src/app/service/commentary.service';

@Component({
  selector: 'app-description-movie',
  templateUrl: './description-movie.component.html',
  styleUrls: ['./description-movie.component.scss']
})
export class DescriptionMovieComponent implements OnInit {

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  movie: Movie;
  comments:Commentary[] = [];
  sessions:Session[] = [] ;
  access:number = Number(sessionStorage.getItem('access'));
  commentary:any = { "idUser":{}, "idMovie": {} , "commentary":"" , "rating":5} ;

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  ngOnInit(): void {
    this.route.queryParams
      .subscribe(params => {
        this.movie.id = Number(params.idFilm);
      }
      );
    this.findMovie();
    this.findComment();
    this.findSession()    
  }

  findSession()
  {
    this.movieService.findAllSessions(this.movie.id).subscribe(data => {
      this.sessions = data ;
      console.log(this.sessions);
    })
  }

  findComment()
  {
    this.movieService.findAllCommentarys(this.movie.id).subscribe(data => {
      this.comments = data ;
      console.log(this.comments);
    })
  }

  findMovie() {
    this.movieService.findById(this.movie.id).subscribe(data => {
      this.movie = data;
      this.updateImage();
    });
  }

  updateImage() {
    if (!this.movie.imageUrl || this.movie.imageUrl === "" || this.movie.imageUrl === "N/A") {
      this.movieService.updateURL(this.movie);
    }
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

  onSubmit()
  {
    this.commentary.idMovie = this.movie ;

    let userString:any = sessionStorage.getItem('currentUser') ;
    this.commentary.idUser = JSON.parse(userString) ;

    if (confirm("Are you sure you want to create this Comment ?")) {
      let toPost: Commentary = this.commentary ;
      this.commentaryService.save(toPost).subscribe( () => { window.location.reload() ;});
      //this.movieService.updateURL(toPost);
      
    }
    else {
      console.log("New Comment ABORTED");
    }
  }


  displayedColumns: string[] = ['id', 'name', 'progress'];

  constructor(private commentaryService:CommentaryService,private movieService: MovieService,private router:Router, private route: ActivatedRoute) {
    this.movie = new Movie({});
  }
}

