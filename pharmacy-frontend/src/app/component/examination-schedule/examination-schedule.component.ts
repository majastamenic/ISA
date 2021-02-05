import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationService } from 'src/app/service/examination.service';


@Component({
  selector: 'app-examination-schedule',
  templateUrl: './examination-schedule.component.html',
  styleUrls: ['./examination-schedule.component.css']
})
export class ExaminationScheduleComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  examinations: any = [];
  pharmacy: any;

  constructor(private examinationService: ExaminationService, 
              private _ActivatedRoute: ActivatedRoute,
              private toastrService: ToastrService,
              private router: Router) {
      if(!this.loggedUser){
        this.router.navigate(['login']);
        toastrService.info('Please login first!');
      }
    }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacy = params.get('pharmacyName');
      this.examinationService.getFreeExaminationTermsByPharmacy(this.pharmacy).subscribe(freeExaminations =>{
        this.examinations = freeExaminations;
      }, error => {
        console.error(error);
        this.toastrService.error("Error while loading terms!");
      }); 
    }, error => {
      console.error(error);
      this.toastrService.error('No pharmacy has been specified!');
    });
  }

  scheduleExamination(id: number){
    this.examinationService.scheduleExamination(this.loggedUser, id).subscribe(noVal =>{
      // Obrisati iz liste examinations onaj sto je upravo zakazan
      this.toastrService.success('Examination successfuly scheduled!');
    }, error =>{
      this.toastrService.error(error.toString());
    });
  }

}
