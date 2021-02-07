import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExaminationService } from 'src/app/service/examination.service';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import {Observable} from 'rxjs';
import {debounceTime, distinctUntilChanged, map} from 'rxjs/operators';


@Component({
  selector: 'app-start-examination',
  templateUrl: './start-examination.component.html',
  styleUrls: ['./start-examination.component.css'],
  styles: [`.form-control { width: 300px; }`]
})
export class StartExaminationComponent implements OnInit {

  id: any;
  examination: any;
  medicines: any[]=[];
  names: any[]=[];

  constructor(private examinationService: ExaminationService,private  medicinePharmacyService: MedicinePharmacyService,  private _ActivatedRoute: ActivatedRoute) { }

  public model: any;

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
      this.examinationService.startExamination(this.id).subscribe(startExam =>{
        this.examination = startExam;
        console.log(this.examination);
        this.medicinePharmacyService.getMedicinesByPharmacy(this.examination.pharmacyName, this.examination.patientDto.user.email).subscribe((data: any[]) => {
          this.medicines = data;
          for(let i of this.medicines){
            let med = i.medicine.name;
            this.names.push(med);
          }
        });
      })
    })
  }

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 2 ? []
        : this.names.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

}
