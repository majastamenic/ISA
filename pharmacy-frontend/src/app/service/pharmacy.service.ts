import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PharmacyDto } from '../component/system-admin/add-pharmacy/model/pharmacy-model';
import { PHARMACY_PATH, AVAILABLE_PHARMACIES } from '../util/paths';

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

  getPharmaciesWithAvailablePharmacists(eagerDate: any): any{
    return this.httpClient.put(AVAILABLE_PHARMACIES, eagerDate);
  }
}
