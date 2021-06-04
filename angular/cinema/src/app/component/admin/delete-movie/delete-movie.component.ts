import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/class/movie';
import { MovieService } from 'src/app/service/movie.service';

@Component({
  selector: 'app-delete-movie',
  templateUrl: './delete-movie.component.html',
  styleUrls: ['./delete-movie.component.scss']
})
export class DeleteMovieComponent implements OnInit {

  constructor(private movieService: MovieService) { }

  selectedMovie: any = { "movie":{} , "index":-1 } ;
  movies: Movie[] = [];

  ngOnInit(): void {
    this.findAllMovie() ;
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Movie ?")) {
      console.log(this.selectedMovie) ;
      this.movieService.delete(this.selectedMovie.movie.id).subscribe() ;
      this.movies.splice(this.selectedMovie.index,1);
    }
    else {
      console.log("Delete Movie ABORTED");
    }
    this.selectedMovie = { "movie":{} , "index":-1};
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

  trackMovie(index:number,movie:Movie)
  {
    return movie.id ;
  }

}
