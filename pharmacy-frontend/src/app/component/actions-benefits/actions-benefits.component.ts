import { Component, OnInit } from '@angular/core';
import { ActionsBenefitsService } from 'src/app/service/actions-benefits.service';
import { HospitalService } from 'src/app/service/hospital.service.service';
import { ActionsBenefits, ActionsBenefitsDto } from './model/actions-benefits-model';

@Component({
  selector: 'app-actions-benefits',
  templateUrl: './actions-benefits.component.html',
  styleUrls: ['./actions-benefits.component.css']
})
export class ActionsBenefitsComponent implements OnInit {

  actionBenefit!: ActionsBenefitsDto;
  constructor(private actionsBenefitsService: ActionsBenefitsService) { }

  ngOnInit(): void {
  }

  send(): void{
    this.actionsBenefitsService.send(this.actionBenefit).subscribe((returnedAction: ActionsBenefits) => {
      alert('Action or benefit send.');
    },
      (err: any) => {
        alert('Error while sending action or benefit ' + err.error.message);
      });
  }

}
