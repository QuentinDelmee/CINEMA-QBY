import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/class/movie';
import { MovieService } from 'src/app/service/movie.service';


@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.scss']
})
export class CreateMovieComponent implements OnInit {

  //movieJSON: any = { "id": 0, "title": "", "originalTitle": "", "pegi": 0, "releaseDate": 0, "movieDuration": "", "movieGenre": "", "averageRating": 0, "movieDescription": "", "lstCommentarys": [], "lstSessions": [] } ;
  movieJSON: any = {};

  moviesString: any = localStorage.getItem('movies');
  movies: Movie[] = JSON.parse(this.moviesString);

  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
    
  }

  onSubmit(): void {
    if (confirm("Are you sure you want to create this Movie ?")) {
      let toPost: Movie = new Movie(this.movieJSON);
      this.movieService.updateURL(toPost) ;
      this.movieService.save(toPost).subscribe();
      this.movies.push(toPost) ;
      this.persist('movies',JSON.stringify(this.movies));
    }
    else {
      console.log("New Movie ABORTED");
    }

    this.movieJSON = {} ;
  }

  persist(key:string,value:any)
  {
    localStorage.setItem(key,value) ;
  }

}
