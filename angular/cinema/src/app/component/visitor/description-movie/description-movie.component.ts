import { Component, OnInit, ViewChild } from '@angular/core';
import { Movie } from '../../../class/movie';
import { MovieService } from '../../../service/movie.service'
import { ActivatedRoute } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Commentary } from 'src/app/class/commentary';
import { Session } from 'src/app/class/session';

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


  displayedColumns: string[] = ['id', 'name', 'progress'];

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
    this.movie = new Movie({});
  }
}

