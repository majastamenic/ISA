import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Diagnosis } from 'src/app/model/diagnosis';
import { DiagnosisService } from 'service/diagnosis.service';
import { sortAndDeduplicateDiagnostics } from 'typescript';

@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {

newDiagnosis: any;
allDiagnosis: any[]=[];

diagnosis: Diagnosis={name:''};

  constructor(private diagnosisService: DiagnosisService, private router: Router) { }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");

    if(loggedUser){
      this.diagnosisService.getDiagnosis().subscribe((data: any[]) => {
        this.allDiagnosis = data;
        console.log(this.diagnosis);
      });
    }
  }

  addDiagnosis(){
    console.log(this.newDiagnosis);

    const diagnosis = {
      name: this.newDiagnosis
    }

    this.diagnosisService.addDiagnosis(diagnosis).subscribe(diag => {
      window.location.reload();
    })
  }

}


