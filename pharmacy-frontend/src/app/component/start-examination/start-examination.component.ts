import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExaminationService } from 'src/app/service/examination.service';

@Component({
  selector: 'app-start-examination',
  templateUrl: './start-examination.component.html',
  styleUrls: ['./start-examination.component.css'],
  styles: ['.card { overflow:hidden }']
})
export class StartExaminationComponent implements OnInit {

  id: any;
  examination: any;

  constructor(private examinationService: ExaminationService, private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
      this.examinationService.startExamination(this.id).subscribe(startExam =>{
        this.examination = startExam;
        console.log(startExam);
      })
    })
  }

}
