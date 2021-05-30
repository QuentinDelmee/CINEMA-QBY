import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../class/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/REST/user';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.userUrl, user);
  }

  public login(user: User) {
    return this.http.post<User>((this.userUrl+"/login"), user);
  }

  public delete(id:number) {
    return this.http.delete<User>(this.userUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }
}
