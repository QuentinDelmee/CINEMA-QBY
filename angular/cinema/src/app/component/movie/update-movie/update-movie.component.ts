import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/class/movie';
import { MovieService } from 'src/app/service/movie.service';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.scss']
})
export class UpdateMovieComponent implements OnInit {

  constructor(private movieService: MovieService) { }

  selectedMovie: Movie = new Movie({});

  movies: Movie[] = [];

  ngOnInit(): void {
    this.movieService.findAll().subscribe(data => { this.movies = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to update this Movie ?")) {
      this.movieService.save(this.selectedMovie).subscribe();
    }
    else {
      console.log("Update Movie ABORTED");
    }
  }

}
