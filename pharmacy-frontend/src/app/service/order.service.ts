import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ORDER_PATH } from '../util/paths';

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
    return this.httpClient.delete(ORDER_PATH+"/"+id);
  }
}
