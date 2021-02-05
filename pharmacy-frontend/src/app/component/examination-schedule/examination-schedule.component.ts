import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExaminationService } from 'src/app/service/examination.service';


@Component({
  selector: 'app-examination-schedule',
  templateUrl: './examination-schedule.component.html',
  styleUrls: ['./examination-schedule.component.css']
})
export class ExaminationScheduleComponent implements OnInit {

  examinations: any;
  pharmacy: any;

  constructor(private examinationService: ExaminationService, 
    private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacy = params.get('pharmacyName');
      this.examinationService.getFreeExaminationTermsByPharmacy(this.pharmacy).subscribe(freeExaminations =>{
        this.examinations = freeExaminations;
      }); 
  });
    
  }

}
