import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Quizz } from '../class/quizz';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizzService {

  private quizzUrl: string;

  constructor(private http: HttpClient) {
    this.quizzUrl = 'http://localhost:8080/REST/quizz';
  }

  public findAll(): Observable<Quizz[]> {
    return this.http.get<Quizz[]>(this.quizzUrl);
  }

}
