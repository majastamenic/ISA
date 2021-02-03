import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PharmacyDto } from '../system-admin/add-pharmacy/model/pharmacy-model';
import { PHARMACY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class PharmacyService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(PHARMACY_PATH);
  }

  addPharmacy(pharmacy: PharmacyDto): any{
    return this.httpClient.post(PHARMACY_PATH, pharmacy);
  }
}
