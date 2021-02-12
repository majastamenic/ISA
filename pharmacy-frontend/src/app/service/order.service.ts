import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OFFER_PATH, ORDER_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(ORDER_PATH);
  }

  create(newOrder: any): any{
    return this.httpClient.post(ORDER_PATH, newOrder);
  }

  delete(id: number): any{
    return this.httpClient.delete(ORDER_PATH + "/" + id);
  }

  createOffer(newOffer: any): any{
    return this.httpClient.post(OFFER_PATH, newOffer);
  }

  getSupplierOffers(email: string): any{
    return this.httpClient.get(OFFER_PATH + "/" + email);
  }

  filter(email: string, type: any): any{
    let params = new HttpParams();
    params = params.append('email', email);
    if(type){params = params.append('type', type);}
    return this.httpClient.get(OFFER_PATH, {params: params});
  }
}
