import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { VACATIONS_DERMATOLOGIST_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class VacationScheduleService {

  constructor(private httpClient: HttpClient) { }

  getDermatologistVacations(email: any):any{
    return this.httpClient.get(VACATIONS_DERMATOLOGIST_PATH + '/' + email);
  }
}
