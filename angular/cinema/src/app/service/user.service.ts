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

  public findAll(): Observable<UserService[]> {
    return this.http.get<UserService[]>(this.userUrl);
  }

  public save(user: UserService) {
    return this.http.post<UserService>(this.userUrl, user);
  }
}
