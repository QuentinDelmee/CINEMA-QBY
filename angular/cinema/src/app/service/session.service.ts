import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Session } from '../class/session';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private sessionUrl: string;

  constructor(private http: HttpClient) {
    this.sessionUrl = 'http://localhost:8080/REST/session';
  }

  public findAll(): Observable<Session[]> {
    return this.http.get<Session[]>(this.sessionUrl);
  }

  public save(session: Session) {
    return this.http.post<Session>(this.sessionUrl, session);
  }

  public delete(id:number) {
    return this.http.delete<Session>(this.sessionUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }
}
