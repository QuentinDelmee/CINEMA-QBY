import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reservation } from '../class/reservation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private reservationUrl: string;

  constructor(private http: HttpClient) {
    this.reservationUrl = 'http://localhost:8080/REST/reservation';
  }

  public findAll(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.reservationUrl);
  }

  public save(reservation: Reservation) {
    return this.http.post<Reservation>(this.reservationUrl, reservation);
  }

  public delete(id:number) {
    return this.http.delete<Reservation>(this.reservationUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }

  public findUser(idUser:number)
  {
    return this.http.get<Reservation[]>(this.reservationUrl+"/user/"+idUser);
  }
}