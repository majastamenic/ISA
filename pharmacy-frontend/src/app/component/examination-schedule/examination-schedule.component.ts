import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationService } from 'src/app/service/examination.service';


@Component({
  selector: 'app-examination-schedule',
  templateUrl: './examination-schedule.component.html',
  styleUrls: ['./examination-schedule.component.css']
})
export class ExaminationScheduleComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  examinations: any;
  pharmacy: any;

  constructor(private examinationService: ExaminationService, 
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService) { 
      if(!this.loggedUser){

      }
    }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacy = params.get('pharmacyName');
      this.examinationService.getFreeExaminationTermsByPharmacy(this.pharmacy).subscribe(freeExaminations =>{
        this.examinations = freeExaminations;
      }, error => {
        this.toastrService.error("Error while loading terms!");
      }); 
    }, error => {
      this.toastrService.error('No pharmacy has been specified!');
    });
  }

  scheduleExamination(id: number){
  
  }

}
