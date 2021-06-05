import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../../../class/movie';
import { MovieService } from '../../../service/movie.service'

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent implements OnInit {

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

  movies: Movie[] = [] ;
  savedTab: number = Number(sessionStorage.getItem('movieTab'));

  /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */
  nbColumn: number = 12;
  nbColSpan: number = 3;
  nbGutterSize: number = 24;
  innerWidth: number = 1440;

  constructor(private movieService: MovieService,private router:Router) { }

  ngOnInit(): void {
    this.onResize();
    this.findAllMovie();
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

  updateTab(index: number): void {
    sessionStorage.setItem("movieTab", index.toString());
    console.log(sessionStorage.getItem("movieTab"));
  }

  image(movie: Movie): string {
    if (movie.imageUrl === "N/A" || !movie.imageUrl || movie.imageUrl === "") {
      return '../../../assets/img/image-not-found.png';
    }
    else { return movie.imageUrl; }
  }

  redirect(movie:Movie)
  {

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
