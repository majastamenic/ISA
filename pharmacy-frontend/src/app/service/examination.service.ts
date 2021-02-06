import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FREE_EXAM_TERMS_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private httpClient: HttpClient) {
   }

  getFreeExaminationTerms(){
    return this.httpClient.get(FREE_EXAM_TERMS_PATH);
  }

  getFreeExaminationTermsByPharmacy(pharmacyName: string){
    return this.httpClient.get(FREE_EXAM_TERMS_PATH + "/" + pharmacyName);
  }
}
