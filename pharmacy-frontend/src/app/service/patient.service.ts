import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PasswordChangeDto } from '../component/user/model/user-model';
import { PATIENT_PATH, USER_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  getPatientByEmail(email: string){
    return this.http.get(PATIENT_PATH + "/" + email);
  }

  updatePatient(patient: any){
    return this.http.put(PATIENT_PATH + "/update", patient);
  }

  updatePassword(userEmail: string, passwordDto: PasswordChangeDto){
    return this.http.put(USER_PATH + "/updatePassword", {
      email: userEmail,
      oldPass: passwordDto.oldPassword,
      newPass: passwordDto.newPassword,
      newPassRepeat: passwordDto.newPasswordRepeat
    });
  }
}
