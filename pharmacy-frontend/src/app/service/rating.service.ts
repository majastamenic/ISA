import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RATING_DERMATOLOGIST_PATH, RATING_MEDICINE_PATH, RATING_PHARMACIST_PATH, RATING_PHARMACY_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private httpClient: HttpClient) { }

  getAverageRatePharmacist(email: string){
    return this.httpClient.get(RATING_PHARMACIST_PATH + "/" + email);
  }

  ratePharmacist(rating:any ){
    return this.httpClient.post(RATING_PHARMACIST_PATH, rating);
  }

  updateRatePharmacist(rating: any){
    return this.httpClient.put(RATING_PHARMACIST_PATH, rating);
  }

  getAverageRateDermatologist(email: string){
    return this.httpClient.get(RATING_DERMATOLOGIST_PATH + "/" + email);
  }

  rateDermatologist(rating:any ){
    return this.httpClient.post(RATING_DERMATOLOGIST_PATH, rating);
  }

  updateRateDermatologist(rating: any){
    return this.httpClient.put(RATING_DERMATOLOGIST_PATH, rating);
  }

  getAverageRateMedicine(email: string){
    return this.httpClient.get(RATING_MEDICINE_PATH + "/" + email);
  }

  rateMedicine(rating:any ){
    return this.httpClient.post(RATING_MEDICINE_PATH, rating);
  }

  updateRateMedicine(rating: any){
    return this.httpClient.put(RATING_MEDICINE_PATH, rating);
  }


  getAverageRatePharmacy(email: string){
    return this.httpClient.get(RATING_PHARMACY_PATH + "/" + email);
  }

  ratePharmacy(rating:any ){
    return this.httpClient.post(RATING_PHARMACY_PATH, rating);
  }

  updateRatePharmacy(rating: any){
    return this.httpClient.put(RATING_PHARMACY_PATH, rating);
  }
}
