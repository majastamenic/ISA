import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PHARMACIST_REGISTRATION_PATH, PHARMACY_PATH} from '../util/paths';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PharmacistService {

  constructor(private httpClient: HttpClient) { }

  public createPharmacist(pharmacist:any): Observable<any>{
    return this.httpClient.post(PHARMACIST_REGISTRATION_PATH, pharmacist);
  }
  getAll(): Observable<any>{
    return this.httpClient.get(PHARMACY_PATH);
  }
}
