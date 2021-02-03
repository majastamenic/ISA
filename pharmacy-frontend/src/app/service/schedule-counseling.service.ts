import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COUNSELING_ADD_PATH, PATIENT_PATH, PHARMACY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ScheduleCounselingService {

  constructor(private httpClient: HttpClient) { }

  getAllPatients() {
    return this.httpClient.get(PHARMACY_PATH);
  }

  createCounseling(counseling: any) {
    return this.httpClient.post(COUNSELING_ADD_PATH, counseling);
  }
}
