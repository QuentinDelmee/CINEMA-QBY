import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CinemaRoom } from '../class/cinema-room';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CinemaRoomService {

  private cinemaRoomUrl: string;

  constructor(private http: HttpClient) {
    this.cinemaRoomUrl = 'http://localhost:8080/REST/cinemaroom';
  }

  public findAll(): Observable<CinemaRoom[]> {
    return this.http.get<CinemaRoom[]>(this.cinemaRoomUrl);
  }

  public save(cinema: CinemaRoom) {
    return this.http.post<CinemaRoom>(this.cinemaRoomUrl, cinema);
  }

  public delete(id:number) {
    return this.http.delete<CinemaRoom>(this.cinemaRoomUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }
}
