import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GET_MEDICINEPHARMACY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicinePharmacyService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(GET_MEDICINEPHARMACY_PATH);
  }

  getByPharmacy(id: number):any{
    return this.httpClient.get(GET_MEDICINEPHARMACY_PATH + '/' + id);
  }
}
