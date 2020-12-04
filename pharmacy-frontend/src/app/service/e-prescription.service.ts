import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ePrescriptionClass } from '../component/e-prescription/e-prescription.component';
import { EPRESCRIPTION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class EPrescriptionService {

  constructor(private httpClient: HttpClient) { }

}
