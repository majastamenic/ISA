import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoyaltyGroup } from '../model/loyaltyGroup';
import { LOYALTY_GROUP_PATH, CATEGORY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class LoyaltyGroupService {

  constructor(private httpClient: HttpClient) { }

  getLoyaltyPoints(type: any): any{
    return this.httpClient.get(LOYALTY_GROUP_PATH +"/"+ type);
  }

  setLoyaltyPoints(loyaltyGroup: LoyaltyGroup): any{
    return this.httpClient.put(LOYALTY_GROUP_PATH, loyaltyGroup);
  }

  getCategoryByPoints(points: number): any{
    return this.httpClient.get(CATEGORY_PATH + '?points=' + points);
  }
}
