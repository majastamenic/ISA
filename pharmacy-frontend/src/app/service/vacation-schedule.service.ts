import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { DERMATOLOGIST_VACATION_CHECK_PATH, VACATIONS_DERMATOLOGIST_PATH, VACATION_PHARMACIST_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class VacationScheduleService {

  constructor(private httpClient: HttpClient) { }

  getDermatologistVacations(email: any):any{
    return this.httpClient.get(VACATIONS_DERMATOLOGIST_PATH + '/' + email);
  }

  getPharmacistVacations(email: any):any{
    return this.httpClient.get(VACATION_PHARMACIST_PATH + '/' + email);
  }

  scheduleVacationTermDermatologist(vacation: any, email: any){
    return this.httpClient.post(DERMATOLOGIST_VACATION_CHECK_PATH + '/' + email, vacation);
  }
  
}
