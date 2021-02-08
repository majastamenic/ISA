import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExaminationService } from 'src/app/service/examination.service';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import {Observable} from 'rxjs';
import {debounceTime, distinctUntilChanged, map} from 'rxjs/operators';
import { MedicineService } from 'src/app/service/medicine.service';
import { Diagnosis } from 'src/app/model/diagnosis';
import { DiagnosisService } from 'src/app/service/diagnosis.service';
import { ExaminationDto } from 'src/app/model/examination';


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
  selectedMeds: any[]=[];
  selectedDiag: any[]=[];
  available: any[]=[];
  meds: any[]=[];
  allDiagnosis: any[]=[];
  diagnosis: Diagnosis={name:''};
  patientCame: boolean = false;
  days: any;
  hideStart: boolean = false;
  diags:any[]=[];
  updateExam: ExaminationDto = { id:0, email:'', patientDto:{}, patientEmail: '', schedule: {id:''}, prescription: {days:'', diagnosis:[], medicines:[]}, pharmacyName:'', price:0,  patientCame: false };

  constructor(private examinationService: ExaminationService,private  medicinePharmacyService: MedicinePharmacyService, 
    private medicineService: MedicineService, private diagnosisService: DiagnosisService, 
    private _ActivatedRoute: ActivatedRoute, private router: Router) { }

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
            i.label = med;
            this.names.push(med);
          }
        });
      })
    })
    this.diagnosisService.getDiagnosis().subscribe((data: any[]) => {
      this.allDiagnosis = data;
      console.log(this.allDiagnosis);
      for(let i of this.allDiagnosis){
        let diag = i.name;
        i.labelDiag = diag;
        this.names.push(diag);
      }
    });
  }

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 2 ? []
        : this.names.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

    checkAvailability(){
      this.meds = [];
      for(let med of this.selectedMeds){
        this.meds.push(med.medicine.name);
      }
      this.medicineService.checkAvailabilityMeds(this.examination.pharmacyName, this.meds).subscribe((data:any[]) => {
        this.available = data;
        console.log(data);
      })
    }

    cancelExamination(){
      this.router.navigate(['allexaminations']);
    }

    patientIsHere(){
      this.patientCame = true;
    }

    patientIsntHere(){
      const updateExam = {
        id: this.examination.id,
        email: this.examination.email,
        patientDto:{},
        patientEmail: this.examination.patientDto.user.email,
        schedule: {
          id: this.examination.schedule.id
        },
        prescription: {
          diagnosis:[],
          medicines:[]
        },
        pharmacyName: this.examination.pharmacyName,
        price: this.examination.price,
        patientCame: false
      }
      this.examinationService.updateExamination(updateExam).subscribe(exam => {
        console.log(exam);
        this.router.navigate(['allexaminations']);
      })
    }

    saveExamination(){
      this.updateExam.id = this.examination.id;
      this.updateExam.email = this.examination.email;
      this.updateExam.patientDto = this.examination.patientDto;
      this.updateExam.schedule = this.examination.schedule;
      this.updateExam.pharmacyName = this.examination.pharmacyName;
      this.updateExam.price = this.examination.price;
      this.updateExam.patientCame = true;
      this.updateExam.prescription.diagnosis = [];
      for(let d of this.selectedDiag){
        for(let dia of this.allDiagnosis){
          if(d.name == dia.name){
            this.updateExam.prescription.diagnosis.push(dia.id);
          }
        }
      }
      this.examinationService.updateExamination(this.updateExam).subscribe(exam => {
        console.log(exam);
        this.router.navigate(['allexaminations']);
      })
    }

}
