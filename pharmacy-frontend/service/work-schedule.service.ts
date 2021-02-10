import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SCHEDULE_PATH } from '../src/app/util/paths';

@Injectable({
  providedIn: 'root'
})
export class WorkScheduleService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(SCHEDULE_PATH);
  }
}
