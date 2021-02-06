import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { COMPLAINT_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private httpClient: HttpClient) { }

  getSubjects(email: string):any{
    return this.httpClient.get(COMPLAINT_PATH + '/' + email)
  }

  sendComplaint(complaint: any): any{
    return this.httpClient.post(COMPLAINT_PATH, complaint);
  }
}
