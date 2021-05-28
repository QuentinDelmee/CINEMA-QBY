import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Commentary } from '../class/commentary';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentaryService {

  private commentary: string;

  constructor(private http: HttpClient) {
    this.commentary = 'http://localhost:8080/REST/commentary';
  }

  public findAll(): Observable<Commentary[]> {
    return this.http.get<Commentary[]>(this.commentary);
  }

  public save(commentary: Commentary) {
    return this.http.post<Commentary>(this.commentary, commentary);
  }
}
