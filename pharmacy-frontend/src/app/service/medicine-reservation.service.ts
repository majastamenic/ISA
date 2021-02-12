import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RESERVATION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class MedicineReservationService {

  constructor(private httpClient: HttpClient) { }

  getAllReservationsByPatient(email: string){
    return this.httpClient.get(RESERVATION_PATH + '/' + email);
  }

  createReservation(reservation:any){
    return this.httpClient.post(RESERVATION_PATH, reservation);
  }
}
