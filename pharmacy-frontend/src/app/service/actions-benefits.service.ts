import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActionsBenefitsDto } from '../component/actions-benefits/model/actions-benefits-model';
import { ACTION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ActionsBenefitsService {

  constructor(private httpClient: HttpClient) { }

  send(actionBenefit: ActionsBenefitsDto): any {
    return this.httpClient.post(ACTION_PATH, actionBenefit, {responseType: 'text'});
  }
}
