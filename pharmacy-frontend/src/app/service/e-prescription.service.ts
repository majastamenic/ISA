import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EPRESCRIPTION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class EPrescriptionService {

  constructor(private httpClient: HttpClient) { }

}
