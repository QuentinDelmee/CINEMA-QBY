import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Commentary } from '../class/commentary';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentaryService {

  private commentaryURL: string;

  constructor(private http: HttpClient) {
    this.commentaryURL = 'http://localhost:8080/REST/commentary';
  }

  public findAll(): Observable<Commentary[]> {
    return this.http.get<Commentary[]>(this.commentaryURL);
  }

  public save(commentary: Commentary) {
    return this.http.post<Commentary>(this.commentaryURL, commentary);
  }

  public delete(id:number) {
    return this.http.delete<Commentary>(this.commentaryURL+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }

  public findUser(idUser:number)
  {
    return this.http.get<Commentary[]>(this.commentaryURL+"/user/"+idUser);
  }
}
