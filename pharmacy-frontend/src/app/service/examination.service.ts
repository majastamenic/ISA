import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CANCEL_EXAMINATION, EXAMINATION_PATH, EXAMINATION_START_PATH, EXAMINATION_UPDATE_PATH,
  PATIENT_EXAMINATIONS, FREE_EXAM_TERMS_PATH, SCHEDULE_EXAM_PATH, FREE_EXAM_TERMS_WORKER_PATH, CREATE_EXAMINATION_DERMATOLOGIST_PATH, FREE_PREDEFINED_TERMS, EXAMINATION_FIND_PATIENT_PATH, EXAMINATION_NUMBER_PATH } from '../util/paths';


@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private httpClient: HttpClient) {
   }

  getFreeExaminationTerms(){
    return this.httpClient.get(FREE_EXAM_TERMS_PATH);
  }

  getFreeExaminationTermsByPharmacy(pharmacyName: string): any{
    return this.httpClient.get(FREE_EXAM_TERMS_PATH + "/" + pharmacyName);
  }

  scheduleExamination(patientEmail: string, examId: number){
    return this.httpClient.put(SCHEDULE_EXAM_PATH + '/' + patientEmail + '/' + examId, null);
  }

  cancelExamination(examinationId: number){
    return this.httpClient.put(CANCEL_EXAMINATION + "/" + examinationId, null);
  }

  getExaminations(email: string):any{
    return this.httpClient.get(EXAMINATION_PATH + '/' + email)
  }
  getNumber(email: string):any{
    return this.httpClient.get(EXAMINATION_NUMBER_PATH + '/' + email)
  }

  startExamination(id: any){
    return this.httpClient.get(EXAMINATION_START_PATH + "/" + id);
  }

  updateExamination(updateExam: any){
    return this.httpClient.post(EXAMINATION_UPDATE_PATH, updateExam);
  }

  getPatientExaminations(patientEmail: string){
    return this.httpClient.get(PATIENT_EXAMINATIONS + "/" + patientEmail);
  }

  getFreeExaminationTermsByDermatlogist(email: any):any{
    return this.httpClient.get(FREE_EXAM_TERMS_WORKER_PATH + "/" + email);
  }

  createExaminationByDermatologist(examination: any){
    return this.httpClient.post(CREATE_EXAMINATION_DERMATOLOGIST_PATH, examination);
  }

  getFreeTerms(id: number) :any{
    return this.httpClient.get(FREE_PREDEFINED_TERMS + '/' + id);
  }

  getExaminationByPatient(email: string, name: string, surname: string):any{
    return this.httpClient.get(EXAMINATION_FIND_PATIENT_PATH + '/'+ email + '/' + name + '/' + surname);
  }

}
