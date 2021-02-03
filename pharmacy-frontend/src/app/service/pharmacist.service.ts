import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PHARMACIST_REGISTRATION_PATH } from '../util/paths';
import { Observable } from 'rxjs';
import { PHARMACY_PATH } from '../util/paths';


@Injectable({
  providedIn: 'root'
})
export class PharmacistService {

  constructor(private httpClient: HttpClient) { }

  public createPharmacist(pharmacist:any): Observable<any>{
    return this.httpClient.post(PHARMACIST_REGISTRATION_PATH, pharmacist);

}
}
