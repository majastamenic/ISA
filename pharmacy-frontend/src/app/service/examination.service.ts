import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EXAMINATION_PATH, FREE_EXAM_TERMS_PATH, SCHEDULE_EXAM_PATH } from '../util/paths';

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

  scheduleExamination(patientEmail: string, examId: number){
    return this.httpClient.put(SCHEDULE_EXAM_PATH + '/' + patientEmail + '/' + examId, null);
  }

  getExaminations(email: string):any{
    return this.httpClient.get(EXAMINATION_PATH + '/' + email)
  }
  
}
