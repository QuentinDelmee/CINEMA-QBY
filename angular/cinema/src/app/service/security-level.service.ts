import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SecurityLevel } from '../class/security-level';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecurityLevelService {

  private securityLevelUrl: string;

  constructor(private http: HttpClient) {
    this.securityLevelUrl = 'http://localhost:8080/REST/securitylevel';
  }

  public findAll(): Observable<SecurityLevel[]> {
    return this.http.get<SecurityLevel[]>(this.securityLevelUrl);
  }

  public save(securityLevel: SecurityLevel) {
    return this.http.post<SecurityLevel>(this.securityLevelUrl, securityLevel);
  }

  public delete(id:number) {
    return this.http.delete<SecurityLevel>(this.securityLevelUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }
}
