import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineDto } from '../component/medicine/model/medicine-model';
import { MEDICINEALL_PATH, MEDICINES_CHECK_PATH, MEDICINE_PATH, MEDICINE_LOYALTY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient: HttpClient ) { }

  getAll(): Observable<any>{
    return this.httpClient.get(MEDICINE_PATH);
  }

  getAllMedicinesDto(): Observable<any>{
    return this.httpClient.get(MEDICINEALL_PATH);
  }

  getAllMedLoyality(): Observable<any>{
    return this.httpClient.get(MEDICINE_LOYALTY_PATH);
  }

  changeMedLoyality(medicine: any):any{
    return this.httpClient.put(MEDICINE_LOYALTY_PATH, medicine);
  } 

  create(medicineDto: MedicineDto): any{
    return this.httpClient.post(MEDICINE_PATH, medicineDto);
  }

  checkAvailabilityMeds(pharmacyName: any, meds: any[]): Observable<any>{
    return this.httpClient.post(MEDICINES_CHECK_PATH + '/'+ pharmacyName, meds);
  }
}
