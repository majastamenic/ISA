import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { DERMATOLOGIST_VACATION_CHECK_PATH, VACATIONS_CONFIRMATION_DERMATOLOGISTS_PATH, VACATIONS_CONFIRMATION_PHARMACISTS_PATH, VACATIONS_DERMATOLOGISTS_PATH, VACATIONS_DERMATOLOGIST_PATH, VACATIONS_PHARMACISTS_PATH, VACATION_PHARMACIST_PATH } from '../util/paths';

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
  getVacationsRequestsPharmacists(email: any):any{
    return this.httpClient.get(VACATIONS_PHARMACISTS_PATH + '/' + email);
  }

  getVacationsRequestsDermatologists():any{
    return this.httpClient.get(VACATIONS_DERMATOLOGISTS_PATH);
  }

  confirmationVacationTermPharmacist(vacationDto:any){
    return this.httpClient.post(VACATIONS_CONFIRMATION_PHARMACISTS_PATH, vacationDto);
  }

  confirmationVacationTermDermatologist(vacationDto:any){
    return this.httpClient.post(VACATIONS_CONFIRMATION_DERMATOLOGISTS_PATH, vacationDto);
  }
}
