import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUserDto, UserRegistrationDto } from '../component/user/model/user-model';
import { PharmacyAdminDto } from '../system-admin/add-pharmacy-admin/add-pharmacy-admin.component';
import { LOGIN_PATH, PATIENT_PATH,  PATIENT_VALID_PATH, DERMATOLOGIST_PATH, PHARMACY_ADMIN_PATH} from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  login(user: LoginUserDto): any {
    return this.httpClient.post(LOGIN_PATH, user);
  }

  registration(user: UserRegistrationDto): any {
    return this.httpClient.post(PATIENT_PATH, user);
  }

  registrationDermatologist(user: UserRegistrationDto): any {
    return this.httpClient.post(DERMATOLOGIST_PATH, user);
  }

  registrationpharmacyAdmin(admin: PharmacyAdminDto): any{
    return this.httpClient.post(PHARMACY_ADMIN_PATH, admin);
  }

  verification(user: UserRegistrationDto, verificationCode: string): any {
    let params = new HttpParams().set('email', user.email).set('code', verificationCode)
    return this.httpClient.get(PATIENT_VALID_PATH, {params});
  }

  isUserLogin(){
    let user = sessionStorage.getItem('user');
    console.log(!(user == null))
    return !(user == null)
  }

  logOut(){
    sessionStorage.removeItem('user');
  }
}
