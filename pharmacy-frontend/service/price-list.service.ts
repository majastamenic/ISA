import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PHARMACY_ADMIN_PATH, PRICELISTDEFINE_PATH } from '../src/app/util/paths';

@Injectable({
  providedIn: 'root'
})
export class PriceListService {

  constructor(private httpClient: HttpClient) {}

  public createPriceList(priceList:any): Observable<any>{
    return this.httpClient.post(PRICELISTDEFINE_PATH, priceList);
  }

  public getPharmacyAdmin(email:string){
    return this.httpClient.get(PHARMACY_ADMIN_PATH + "/" + email);
  }
}
