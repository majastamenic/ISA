import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationService } from 'src/app/service/examination.service';

@Component({
  selector: 'app-patient-examinations',
  templateUrl: './patient-examinations.component.html',
  styleUrls: ['./patient-examinations.component.css']
})
export class PatientExaminationsComponent implements OnInit {

  examinations: any = [];
  loggedUser: any = sessionStorage.getItem('user');

  constructor(private examinationService: ExaminationService, 
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser){
      this.examinationService.getPatientExaminations(this.loggedUser).subscribe(data => {
        this.examinations = data;
      }, error => {
        this.toastrService.error("Server error: can't load examinations!");
      });
    } else {
      this.router.navigate(['login']);
      this.toastrService.info('Please login first!');
    }
  }

  cancelExamination(examinationId: number, i:number){
    this.examinationService.cancelExamination(examinationId).subscribe(data => {
      this.toastrService.success('Examination canceled!');
      this.examinations.splice(i, 1);
    }, error => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't cancel examination!");
    })
  }
}
