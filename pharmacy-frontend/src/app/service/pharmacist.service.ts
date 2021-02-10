import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PHARMACISTSBYPHARMACY_PATH, PHARMACIST_REGISTRATION_PATH, PHARMACY_PATH, FREE_PHARMACIST_PATH} from '../util/paths';
import { Observable } from 'rxjs';
import { DateTime } from 'src/app/model/examination';


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

  getPharmacistsByPharmacyId(id: any):any{
    return this.httpClient.get(PHARMACISTSBYPHARMACY_PATH + '/' + id)
  }

  getFreePharmacistOnDate(pharmacyName: string, date: DateTime) : any{
    return this.httpClient.put(FREE_PHARMACIST_PATH + '?pharmacy=' + pharmacyName, date);
  }
}
