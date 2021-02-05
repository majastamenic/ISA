import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EXAMINATION_LOYALTY_PATH, FREE_EXAM_TERMS_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private httpClient: HttpClient) {
   }

  getLoyaltyPoints(): any{
    return this.httpClient.get(EXAMINATION_LOYALTY_PATH);
  }

  setLoyaltyPoints(loyaltyPoints: number): any{
    return this.httpClient.put(EXAMINATION_LOYALTY_PATH, loyaltyPoints);
  }

  getFreeExaminationTerms(){
    return this.httpClient.get(FREE_EXAM_TERMS_PATH);
  }

  getFreeExaminationTermsByPharmacy(pharmacyName: string){
    return this.httpClient.get(FREE_EXAM_TERMS_PATH + "/" + pharmacyName);
  }
}
