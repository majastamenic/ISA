import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PHARMACIST_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class PharmacistService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(PHARMACIST_PATH);
  }
}
