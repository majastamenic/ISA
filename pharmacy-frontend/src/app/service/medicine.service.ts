import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MEDICINE_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient: HttpClient ) { }

  getAll(): Observable<any>{
    return this.httpClient.get(MEDICINE_PATH);
  }
}
