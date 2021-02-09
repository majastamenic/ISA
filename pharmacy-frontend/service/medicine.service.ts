import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, Sanitizer } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineDto } from '../src/app/component/medicine/model/medicine-model';
import { MEDICINEALL_PATH, MEDICINE_LOYALTY_PATH, MEDICINES_CHECK_PATH,MEDICINE_PATH, MEDICINE_SEARCH_PATH } from '../src/app/util/paths';


@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient: HttpClient ) { }

  getAll(): Observable<any>{
    return this.httpClient.get(MEDICINE_PATH);
  }

  getAllMedicinesDto(pageNum: number, pageSize: number): Observable<any>{
    return this.httpClient.get(MEDICINEALL_PATH + "?pageNumber=" + pageNum + "&pageSize=" + pageSize);
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

  searchFilter(pageSize: any, pageNumber: any, name: string, startPrice: any,
    endPrice: any, pharmacies: any, typeOfMedicine: any, manufactured: any,
    composition: any, formOfMedicine: any, publishingType: any): any {
    let params = new HttpParams();
    params = params.append('pageSize', pageSize);
    params = params.append('pageNumber', pageNumber);
    params = params.append('name', name);
    if (startPrice) {
      params = params.append('startPrice', startPrice);
    }
    if (endPrice) {
      params = params.append('endPrice', endPrice);
    }
    if (pharmacies) {
      pharmacies.forEach((pharmacy: any) => params = params.append('pharmacies', pharmacy));
    }
    if (typeOfMedicine) {
      params = params.append('typeOfMedicine', typeOfMedicine);
    }
    if (manufactured) {
      params = params.append('manufactured', manufactured);
    }
    if (composition) {
      params = params.append('composition', composition);
    }
    if (formOfMedicine) {
      params = params.append('formOfMedicine', formOfMedicine);
    }
    if (publishingType) {
      params = params.append('publishingType', publishingType);
    }
    return this.httpClient.get(MEDICINE_SEARCH_PATH, {params: params})
  }
  checkAvailabilityMeds(pharmacyName: any, meds: any[]): Observable<any>{
    return this.httpClient.post(MEDICINES_CHECK_PATH + '/'+ pharmacyName, meds);
  }
}
