import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COUNSELING_PATH, COUNSELING_START_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class AllCounselingsService {

  constructor(private httpClient: HttpClient) { }

  getCounseltings(email: string):any{
    return this.httpClient.get(COUNSELING_PATH + '/' + email)
  }

  startCounseling(id: any){
    return this.httpClient.get(COUNSELING_START_PATH + "/" + id);
  }
}
