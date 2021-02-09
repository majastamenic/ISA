import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UPLOADQR_PATH } from '../src/app/util/paths';

@Injectable({
  providedIn: 'root'
})
export class UploadQrSevice {

  constructor(private http: HttpClient) { }

  uploadFiled(file: File) : any {
    const formData: FormData = new FormData();

    formData.append('file', file);
    return this.http.post(UPLOADQR_PATH, formData);
  }


}
