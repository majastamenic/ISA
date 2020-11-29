import { Injectable } from '@angular/core';
import { HOSPITAL_PATH, REG_PATH} from '../util/paths';
import { HttpClient } from '@angular/common/http';
import { HospitalRegistrationDto } from '../component/hospital/model/hospital-model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HospitalService{

  constructor(private httpClient: HttpClient){ }

  registration(hospital: HospitalRegistrationDto): any {
    return this.httpClient.post(HOSPITAL_PATH, hospital);
  }

  send(hospital: HospitalRegistrationDto): any{
    return this.httpClient.post(REG_PATH, hospital);
  }

  getAll(): Observable<any>{
    return this.httpClient.get(HOSPITAL_PATH);
  }
}
