import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
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
  constructor(private actionsBenefitsService: ActionsBenefitsService, private hospitalService: HospitalService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.hospitalService.getAll().subscribe(listHospital => {
      this.hospitals = listHospital;
    });
  }

  send(): void{
    this.actionsBenefitsService.send(this.actionBenefit).subscribe((returnedAction: string) => {
      this.toastrService.success('Action or benefit send.');
    },
      (err: any) => {
        this.toastrService.error('Error while sending action or benefit ' + err.error.message);
      });
  }

}
