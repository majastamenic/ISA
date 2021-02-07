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

  constructor(private examinationService: ExaminationService, private _ActivatedRoute: ActivatedRoute) { 
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

}
