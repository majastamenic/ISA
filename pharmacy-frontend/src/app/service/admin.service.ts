import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ADMIN_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

  hospitalRequest( ): any {
    return this.httpClient.get(ADMIN_PATH);
  }

}
