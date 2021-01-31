import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HospitalRegistrationDto } from '../component/hospital/model/hospital-model';
import { LoginUserDto, UserRegistrationDto } from '../component/user/model/user-model';
import { LOGIN_PATH, USER_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  login(user: LoginUserDto): any {
    return this.httpClient.post(LOGIN_PATH, user);
  }

  registration(user: UserRegistrationDto): any {
    return this.httpClient.post(USER_PATH, user);
  }

  verification(code: string): any {
    return this.httpClient.get(USER_PATH);
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
