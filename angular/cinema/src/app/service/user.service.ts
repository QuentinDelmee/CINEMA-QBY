import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../class/user';
import { Observable } from 'rxjs';
import { Commentary } from '../class/commentary';
import { Opinion } from '../class/opinion';
import { Purchase } from '../class/purchase';
import { Reservation } from '../class/reservation';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/REST/user';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl) ;
  }

  public save(user: User) {
    return this.http.post<User>(this.userUrl, user);
  }

  public login(user: User) {
    return this.http.post<User>((this.userUrl+"/login"), user);
  }

  //Voir Quentin pour vérifier utilité de faire la condition dans le service à place Ts
  public deleteById(id:number) {
      return this.http.delete<User>(this.userUrl+ "/"+ id).subscribe();
  }

  public findComments(id:number)
  {
    return this.http.get<Commentary[]>(this.userUrl+"/"+id+"/commentarys") ;
  }

  public findOpinions(id:number)
  {
    return this.http.get<Opinion[]>(this.userUrl+"/"+id+"/opinions") ;
  }

  public findPurchases(id:number)
  {
    return this.http.get<Purchase[]>(this.userUrl+"/"+id+"/purchases") ;
  }

  public findReservations(id:number)
  {
    return this.http.get<Reservation[]>(this.userUrl+"/"+id+"/reservations") ;
  }
}
