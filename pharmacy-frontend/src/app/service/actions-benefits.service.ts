import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActionsBenefitsDto } from '../model/actions-benefits-model';
import { ACTION_PATH } from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class ActionsBenefitsService {

  constructor(private httpClient: HttpClient) { }

  send(actionBenefit: ActionsBenefitsDto, email: string): any {
    return this.httpClient.post(ACTION_PATH + "/" + email, actionBenefit);
  }
}
