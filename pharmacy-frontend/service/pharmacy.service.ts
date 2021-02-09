import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PharmacyDto } from '../src/app/component/system-admin/add-pharmacy/model/pharmacy-model';
import { PHARMACY_PATH, PHARMACY_SUB_PATH, SUBSCRIBE_PATH, UNSUBSCRIBE_PATH } from '../src/app/util/paths';

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

  subscribe(email: string, phName: string): any{
    return this.httpClient.put(SUBSCRIBE_PATH + "/" + phName + "/" + email, null);
  }

  unsubscribe(email: string, phName: string): any{
    return this.httpClient.put(UNSUBSCRIBE_PATH + "/" + phName + "/" + email, null);
  }

  pharmacies_sub(email: string): any{
    return this.httpClient.get(PHARMACY_SUB_PATH + "/" + email);
  }
}
