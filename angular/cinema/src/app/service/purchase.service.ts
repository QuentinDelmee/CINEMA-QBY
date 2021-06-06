import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Purchase } from '../class/purchase';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  private purchaseUrl: string;

  constructor(private http: HttpClient) {
    this.purchaseUrl = 'http://localhost:8080/REST/purchase';
  }

  public findAll(): Observable<Purchase[]> {
    return this.http.get<Purchase[]>(this.purchaseUrl);
  }

  public save(purchase: Purchase) {
    return this.http.post<Purchase>(this.purchaseUrl, purchase);
  }

  public delete(id:number) {
    return this.http.delete<Purchase>(this.purchaseUrl+ "/"+ id);
    //this.http.request('delete', this.moviesUrl+ "/"+ movie.id) ;
  }

  public findUser(idUser:number)
  {
    return this.http.get<Purchase[]>(this.purchaseUrl+"/user/"+idUser);
  }
}
