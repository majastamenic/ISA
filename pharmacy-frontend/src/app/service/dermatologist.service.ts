import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DELETE_DERMATOLOGIST_PATH, DERMATOLOGIST_BY_PHARMACY } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class DermatologistService {

  constructor(private httpClient: HttpClient) { }

  getDermatologistsByPharmacyName(name: string):any{
    return this.httpClient.get(DERMATOLOGIST_BY_PHARMACY + '/' + name)
  }

  deleteDermatologist(email: string, adminEmail: string):any{
    return this.httpClient.put(DELETE_DERMATOLOGIST_PATH + '/' + email + '/'+ adminEmail, null);
  }
}
