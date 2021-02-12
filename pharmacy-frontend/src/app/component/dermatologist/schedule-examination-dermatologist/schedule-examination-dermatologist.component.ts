import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationService } from 'src/app/service/examination.service';
import { PatientService } from 'src/app/service/patient.service';

@Component({
  selector: 'app-schedule-examination-dermatologist',
  templateUrl: './schedule-examination-dermatologist.component.html',
  styleUrls: ['./schedule-examination-dermatologist.component.css']
})
export class ScheduleExaminationDermatologistComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  pathParam: any;
  model: any;
  startTime = { hour: 13, minute: 30 };
  endTime = { hour: this.startTime.hour, minute: this.startTime.minute};
  minuteStep = 30;
  predefinedTerms: any[]=[];
  id: any;
  selectedTerm: any;
  isPredefined: boolean = false;
  patientEmail: any;

  examination: any = { oldExaminationId: {id:''}, schedule: {startDate:'', endDate:'', startTime:'', endTime:''}};

  constructor( private router: Router, private examinationService: ExaminationService,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService,
    private patientService: PatientService) { 
    if(!this.loggedUser){
      this.router.navigate(['login']);
      toastrService.info('Please login first!');
    }
  }

  ngOnInit(): void {
    if(this.loggedUserRole == 'DERMATOLOGIST'){
      this.examination.user = this.loggedUser;

      this._ActivatedRoute.paramMap.subscribe(params =>{
        this.pathParam = params.get('pathParam');
      })

      this.id = this.pathParam;
    this.examinationService.getFreeTerms(this.id).subscribe((data: any[]) => {
      this.predefinedTerms = data;
      console.log(data);
      for(let i of this.predefinedTerms){
        let term = i.schedule.startDate + ', from: ' + i.schedule.startTime + '  to: ' + i.schedule.endTime;
        i.label = term;
      }
    });

    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have rights to access this page!');
    }
  }


  schedule() {
    const examination = {
      schedule: {
        startDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        endDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        startTime: `${this.startTime.hour}:${this.startTime.minute}:00`,
        endTime: `${this.endTime.hour}:${this.endTime.minute}:00`
      }, 
      oldExaminationId: this.pathParam
    }

    this.examinationService.createExaminationByDermatologist(examination).subscribe(data => {
      console.log(data);
      if(data == true){
        this.toastrService.success('Examination is scheduled.');
        this.router.navigate(['home'])
      }else{
        this.toastrService.error('Required term is occupied.');
      }
    }, error => {
      this.toastrService.error('Error. Try again.');
    });
    
  }

  schedulePredefined(){
    this.id = this.pathParam;
    this.patientService.getPatientEmailByExamination(this.id).subscribe(data => {
      console.log(data);
    }, error => {
      if(error.status == 200){
        this.patientEmail = error.error.text;
        console.log(this.patientEmail);
        this.examinationService.scheduleExamination(this.patientEmail, this.selectedTerm.id).subscribe(noVal =>{
          this.toastrService.success('Examination successfuly scheduled!');
          this.router.navigate(['home']);
        }, error => {
          this.toastrService.error(error.toString());
        });
      }
    });
    
  }


  onPredefined(){
    this.isPredefined = true;
  }

  cancelPredefined(){
    this.isPredefined = false;
    this.selectedTerm = [];
  }

}
