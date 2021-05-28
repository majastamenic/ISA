import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FINISHED_ORDERS_PATH, OFFERS_PATH, OFFER_PATH, ORDERS_PATH, ORDER_PATH, UPDATE_WINNER_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(ORDER_PATH);
  }

  getOrders(email: string): any{
    return this.httpClient.get(ORDERS_PATH + "/" + email);
  }
  getFinishedOrders(email: string): any{
    return this.httpClient.get(FINISHED_ORDERS_PATH + "/" + email);
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

  getOrderOffers(id:any): any{
    return this.httpClient.get(OFFERS_PATH + "/" + id);
  }

  updateWinner(newOffer: any,email: string ): any{
    return this.httpClient.post(UPDATE_WINNER_PATH + "/" + newOffer + "/" + email, null);
  }


  filter(email: string, type: any): any{
    let params = new HttpParams();
    params = params.append('email', email);
    if(type){params = params.append('type', type);}
    return this.httpClient.get(OFFER_PATH, {params: params});
  }
}
