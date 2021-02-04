import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FREE_EXAM_TERMS_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  getFreeExaminationTerms(){
    return this.http.get(FREE_EXAM_TERMS_PATH);
  }
}
