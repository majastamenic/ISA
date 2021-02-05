import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COUNSELING_LOYALTY_PATH, COUNSELING_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class AllCounselingsService {

  constructor(private httpClient: HttpClient) { }

  getCounseltings(email: string):any{
    return this.httpClient.get(COUNSELING_PATH + '/' + email)
  }

  getLoyaltyPoints(): any{
    return this.httpClient.get(COUNSELING_LOYALTY_PATH);
  }

  setLoyaltyPoints(loyaltyPoints: number): any{
    return this.httpClient.put(COUNSELING_LOYALTY_PATH, loyaltyPoints);
  }
}
