import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Opinion } from '../class/opinion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OpinionService {

  private opinionUrl: string;

  constructor(private http: HttpClient) {
    this.opinionUrl = 'http://localhost:8080/REST/opinion';
  }

  public findAll(): Observable<Opinion[]> {
    return this.http.get<Opinion[]>(this.opinionUrl);
  }

  public save(opinion: Opinion) {
    return this.http.post<Opinion>(this.opinionUrl, opinion);
  }

}
