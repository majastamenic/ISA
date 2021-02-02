import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PATIENT_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  getPatientByEmail(email: string){
    return this.http.get(PATIENT_PATH + "/" + email);
  }

  updatePatient(patient: any){
    return this.http.put(PATIENT_PATH + "/update", patient);
  }
}
