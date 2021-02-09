import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoyaltyGroup } from '../src/app/component/system-admin/model/loyaltyGroup';
import { LOYALTY_GROUP_PATH } from '../src/app/util/paths';

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
}
