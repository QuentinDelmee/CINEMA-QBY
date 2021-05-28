import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from '../class/movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl: string;

  constructor(private http: HttpClient) {
    this.moviesUrl = 'http://localhost:8080/REST/movie';
  }

  public findAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl);
  }

  public save(movie: Movie) {
    return this.http.post<Movie>(this.moviesUrl, movie);
  }
}
