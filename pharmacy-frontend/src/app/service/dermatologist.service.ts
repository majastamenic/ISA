import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ADD_DERMATOLOGIST_AND_WORKSCHEDULE, DELETE_DERMATOLOGIST_PATH, DERMATOLOGISTS_BY_ADMIN, DERMATOLOGISTS_DEFINE_EXAM, DERMATOLOGIST_BY_PHARMACY, DERMATOLOGIST_PATH } from '../util/paths';

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

  findByNameAndSurname(name: string, surname:string, pharmacyName:string):any{
    return this.httpClient.get(DERMATOLOGIST_BY_PHARMACY + '/' + name + '/' + surname + '/' + pharmacyName)
  }

  getDermatologistsByAdmin(name: string):any{
    return this.httpClient.get(DERMATOLOGISTS_BY_ADMIN + '/' + name)
  }
  addExamination(counseling: any){
    return this.httpClient.post(DERMATOLOGISTS_DEFINE_EXAM, counseling);
  }

  getAll():any{
    return this.httpClient.get(DERMATOLOGIST_PATH);
  }

  addDermatologistAndWorkschedule(counseling: any){
    return this.httpClient.post(ADD_DERMATOLOGIST_AND_WORKSCHEDULE, counseling);
  }
}
