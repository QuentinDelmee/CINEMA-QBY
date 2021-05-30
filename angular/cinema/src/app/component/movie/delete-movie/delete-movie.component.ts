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

  selectedMovie: Movie = new Movie({});

  movies: Movie[] = [];

  ngOnInit(): void {
    this.movieService.findAll().subscribe(data => { this.movies = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Movie ?")) {
      console.log(this.selectedMovie) ;
      this.movieService.delete(this.selectedMovie.id).subscribe() ;
    }
    else {
      console.log("Delete Movie ABORTED");
    }
  }

}
