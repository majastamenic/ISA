import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ShowComplaintDto } from '../model/complaint';
import { COMPLAINT_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private httpClient: HttpClient) { }

  getAll():any{
    return this.httpClient.get(COMPLAINT_PATH);
  }

  getSubjects(email: string):any{
    return this.httpClient.get(COMPLAINT_PATH + '/' + email)
  }

  sendComplaint(complaint: any): any{
    return this.httpClient.post(COMPLAINT_PATH, complaint);
  }

  addResponse(response: ShowComplaintDto): any{
    return this.httpClient.put(COMPLAINT_PATH, response);
  }

  delete(id: number): any{
    return this.httpClient.delete(COMPLAINT_PATH + "/" + id);
  }
}
