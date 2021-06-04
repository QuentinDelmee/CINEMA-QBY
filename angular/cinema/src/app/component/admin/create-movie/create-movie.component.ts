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
  movies: Movie[] = []

  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
    this.findAllMovie() ;
  }

  findAllMovie() {
    this.movieService.findAll().subscribe(data => {
      this.movies = data;
      this.updateImage();
    });
  }

  updateImage() {
    this.movies.forEach(element => {
      if (!element.imageUrl || element.imageUrl === "" || element.imageUrl === "N/A") {
        this.movieService.updateURL(element);
      }
    });
  }

  onSubmit(): void {
    if (confirm("Are you sure you want to create this Movie ?")) {
      let toPost: Movie = new Movie(this.movieJSON);
      
      this.movieService.save(toPost).subscribe();
      this.movieService.updateURL(toPost);
      this.movies.push(toPost) ;
      
    }
    else {
      console.log("New Movie ABORTED");
    }

    this.movieJSON = {} ;
  }
}
