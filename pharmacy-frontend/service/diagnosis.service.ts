import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Diagnosis } from '../src/app/model/diagnosis';
import { DIAGNOSIS_ADD_PATH, DIAGNOSIS_PATH } from '../src/app/util/paths';

@Injectable({
  providedIn: 'root'
})
export class DiagnosisService {

  constructor(private httpClient: HttpClient) { }


  getDiagnosis():any{
    return this.httpClient.get(DIAGNOSIS_PATH)
  }

  addDiagnosis(newDiagnosis: Diagnosis) {
    return this.httpClient.post(DIAGNOSIS_ADD_PATH, newDiagnosis);
  }
}
