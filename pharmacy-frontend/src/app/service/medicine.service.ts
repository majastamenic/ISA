import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineDto } from '../component/medicine/model/medicine-model';
import { MEDICINEALL_PATH, MEDICINE_PATH } from '../util/paths';

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

  create(medicineDto: MedicineDto): any{
    return this.httpClient.post(MEDICINE_PATH, medicineDto);
  }
}
