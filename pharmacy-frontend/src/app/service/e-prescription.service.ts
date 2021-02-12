import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EPRESCRIPTION_PATIENT_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class EPrescriptionService {

  constructor(private httpClient: HttpClient) { }

  getPatientsEprescriptions(patientEmail: string){
    return this.httpClient.get(EPRESCRIPTION_PATIENT_PATH + '/' + patientEmail);
  }
}
