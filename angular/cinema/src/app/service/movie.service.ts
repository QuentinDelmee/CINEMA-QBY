import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from '../class/movie';
import { Observable } from 'rxjs';
import { Session } from '../class/session';
import { Commentary } from '../class/commentary';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl: string;
  private imdbUrl: string;

  constructor(private http: HttpClient) {
    this.moviesUrl = 'http://localhost:8080/REST/movie';
    this.imdbUrl = 'http://www.omdbapi.com/?apikey=f77e23d9&t='
  }

  public findAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl);
  }

  public save(movie: Movie) {
    return this.http.post<Movie>(this.moviesUrl, movie);
  }

  public delete(id:number) {
    return this.http.delete<Movie>(this.moviesUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }

  public updateURL(movie: Movie)
  {
    let completeURL = this.imdbUrl + movie.originalTitle ;
    return this.http.get<any>(completeURL).subscribe( (response) => {
      movie.imageUrl = response.Poster ;
      this.save(movie).subscribe() ;
    })
  }

  public findAllSessions(id:number)
  {
    return this.http.get<Session[]>(this.moviesUrl+"/"+id+"/sessions");
  }

  public findAllCommentarys(id:number)
  {
    return this.http.get<Commentary[]>(this.moviesUrl+"/"+id+"/commentarys");
  }
}
