import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COUNSELING_LOYALTY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class CounselingService {

  constructor(private httpClient: HttpClient) { }

  getLoyaltyPoints(): any{
    return this.httpClient.get(COUNSELING_LOYALTY_PATH);
  }

  setLoyaltyPoints(loyaltyPoints: number): any{
    return this.httpClient.put(COUNSELING_LOYALTY_PATH, loyaltyPoints);
  }
}
