import { Component, OnInit } from '@angular/core';
import { ActionsBenefitsService } from 'src/app/service/actions-benefits.service';
import { HospitalService } from 'src/app/service/hospital.service';
import { ActionsBenefits, ActionsBenefitsDto } from './model/actions-benefits-model';

@Component({
  selector: 'app-actions-benefits',
  templateUrl: './actions-benefits.component.html',
  styleUrls: ['./actions-benefits.component.css']
})
export class ActionsBenefitsComponent implements OnInit {

  actionBenefit: ActionsBenefitsDto = {message: '', startDate: new Date(), endDate: new Date()};
  hospitals: any;
  constructor(private actionsBenefitsService: ActionsBenefitsService, private hospitalService: HospitalService) { }

  ngOnInit(): void {
    this.hospitalService.getAll().subscribe(listHospital => {
      this.hospitals = listHospital;
    });
  }

  send(): void{
    this.actionsBenefitsService.send(this.actionBenefit).subscribe((returnedAction: string) => {
      alert('Action or benefit send.');
    },
      (err: any) => {
        alert('Error while sending action or benefit ' + err.error.message);
      });
  }

}
