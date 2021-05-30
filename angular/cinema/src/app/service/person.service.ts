import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from '../class/person';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private personUrl: string;

  constructor(private http: HttpClient) {
    this.personUrl = 'http://localhost:8080/REST/person';
  }

  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personUrl);
  }

  public save(person: Person) {
    return this.http.post<Person>(this.personUrl, person);
  }

  public delete(id:number) {
    return this.http.delete<Person>(this.personUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }
}
