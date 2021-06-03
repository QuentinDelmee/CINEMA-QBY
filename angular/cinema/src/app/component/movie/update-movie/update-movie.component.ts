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

  moviesString: any = localStorage.getItem('movies');
  movies: Movie[] = JSON.parse(this.moviesString);

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (confirm("Are you sure you want to update this Movie ?")) {
      this.movieService.save(this.selectedMovie).subscribe();
    }
    else {
      console.log("Update Movie ABORTED");
    }

    this.selectedMovie = new Movie({});
  }

  persist(key: string, value: any) {
    localStorage.setItem(key, value);
  }
}
