import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Seat } from '../class/seat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  private seatUrl: string;

  constructor(private http: HttpClient) {
    this.seatUrl = 'http://localhost:8080/REST/seat';
  }

  public findAll(): Observable<Seat[]> {
    return this.http.get<Seat[]>(this.seatUrl);
  }

  public save(seat: Seat) {
    return this.http.post<Seat>(this.seatUrl, seat);
  }
}
