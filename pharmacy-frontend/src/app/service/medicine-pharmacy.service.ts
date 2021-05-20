import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GET_MEDICINEPHARMACYBYADMIN_PATH, GET_MEDICINEPHARMACY_PATH, MEDICINEPH_BY_MEDICINE_PATH, MEDICINES_PHARMACIST_PATH, MEDICINES_PHARMACY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicinePharmacyService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(GET_MEDICINEPHARMACY_PATH);
  }

  getByPharmacy(name:string):any{
    return this.httpClient.get(GET_MEDICINEPHARMACY_PATH + '/' + name);
  }

  getByPharmacyAdmin(email:string):any{
    return this.httpClient.get(GET_MEDICINEPHARMACYBYADMIN_PATH + '/' + email);
  }

  getMedicinesByPharmacy(pharmacyName: any, email:any):any{
    return this.httpClient.get(MEDICINES_PHARMACY_PATH + '/' + pharmacyName + '/' + email);
  }

  getMedicinesByPharmacist(pharmacistEmail: any, patientEmail:any):any{
    return this.httpClient.get(MEDICINES_PHARMACIST_PATH + '/' + pharmacistEmail + '/' + patientEmail);
  }

  getByMedicine(medicineName: string){
    return this.httpClient.get(MEDICINEPH_BY_MEDICINE_PATH + '/' + medicineName);
  }
}