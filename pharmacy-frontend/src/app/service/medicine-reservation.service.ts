import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RESERVATION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicineReservationService {

  constructor(private httpClient: HttpClient) { }

  createReservation(reservation:any){
    return this.httpClient.post(RESERVATION_PATH, reservation);
  }
}
