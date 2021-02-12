import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExaminationService } from 'src/app/service/examination.service';

@Component({
  selector: 'app-all-examinations',
  templateUrl: './all-examinations.component.html',
  styleUrls: ['./all-examinations.component.css']
})
export class AllExaminationsComponent implements OnInit {

  email: string;
  examinations: any[] = [];
  hideStart: boolean = false;
  name:any;
  surname:any;

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  constructor(private examinationService: ExaminationService) { 
    this.email = '';
  }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    
    if(loggedUser){
      this.examinationService.getExaminations(loggedUser).subscribe((data: any[]) => {
        this.examinations = data;
        console.log(this.examinations);
      });
    }
  }

  findByPatient(){
    this.examinationService.getExaminationByPatient(this.loggedUser, this.name, this.surname).subscribe((response: any) => {
      this.examinations = response;
      console.log(this.examinations)
    });
  }

}
