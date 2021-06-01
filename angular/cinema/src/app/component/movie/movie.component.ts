import { Component, OnInit } from '@angular/core';
import { Movie } from '../../class/movie';
import { MovieService } from '../../service/movie.service'

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent implements OnInit {

  movies: Movie[] = [];

  nbColumn: number = 12 ;
  nbColSpan: number = 3 ;
  nbGutterSize: number = 12 ;

  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
    this.movieService.findAll().subscribe(data => { this.movies = data; 
      this.movies.forEach(element => { console.log(element.imageUrl) ;
        if( element.imageUrl === null || element.imageUrl === "" )
        {
          this.movieService.updateURL(element) ;
        }
      });});
    
  }

  post(): void {
    let myJson : any = { "id": 0, "title": "Nadia, butterfly", "originalTitle": "Nadia, butterfly", "pegi": 0, "releaseDate": 2021, "movieDuration": "01:46:00", "movieGenre": "Drame", "averageRating": 5, "movieDescription": "Le film fait partie de la Sélection Officielle de Cannes 2020. Nadia, 23 ans, nage pour le Canada aux Jeux olympiques. Cette compétition prestigieuse représente l'aboutissement de sa vie de sacrifices. Pourtant, par peur de rester piégée dans le monde hermétique et éphémère du sport de haut niveau, Nadia a pris la décision...", "lstCommentarys": [], "lstSessions": [] } ;
    let toPost:Movie = new Movie( myJson ) ;
    this.movieService.save(toPost);
  }

}
