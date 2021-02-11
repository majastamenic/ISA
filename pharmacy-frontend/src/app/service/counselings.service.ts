import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COUNSELING_ADD_PATH, COUNSELING_PATH, COUNSELING_START_PATH, COUNSELING_UPDATE_PATH, PATIENT_COUNSELINGS_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class CounselingsService {

  constructor(private httpClient: HttpClient) { }

  getCounseltings(email: string):any{
    return this.httpClient.get(COUNSELING_PATH + '/' + email)
  }

  startCounseling(id: any){
    return this.httpClient.get(COUNSELING_START_PATH + "/" + id);
  }

  getPatientCounselings(patientEmail: string){
    return this.httpClient.get(PATIENT_COUNSELINGS_PATH + "/" + patientEmail);
  }

  addCounseling(counseling: any){
    return this.httpClient.post(COUNSELING_ADD_PATH, counseling);
  }

  updateCounseling(updateCouns: any){
    return this.httpClient.post(COUNSELING_UPDATE_PATH, updateCouns);
  }
  
}
