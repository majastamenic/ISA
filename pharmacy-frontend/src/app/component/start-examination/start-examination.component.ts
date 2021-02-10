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
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-start-examination',
  templateUrl: './start-examination.component.html',
  styleUrls: ['./start-examination.component.css'],
  styles: [`.form-control { width: 300px; }`]
})
export class StartExaminationComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  id: any;
  examination: any;
  medicines: any[]=[];
  names: any[]=[];
  selectedMeds: any[]=[];
  isChecked: boolean = false;
  selectedDiag: any[]=[];
  availableMeds: any[]=[];
  meds: any[]=[];
  allDiagnosis: any[]=[];
  diagnosis: Diagnosis={name:''};
  patientCame: boolean = false;
  days: any;
  hideStart: boolean = false;
  diags:any[]=[];
  toSchedule: boolean = false;
  cannotSave: boolean = false;
  updateExam: ExaminationDto = { id:0, email:'', patientDto:{}, patientEmail: '', schedule: {id:''}, prescription: {days:'', diagnosis:[], medicines:[]}, pharmacyName:'', price:0,  patientCame: false };
  
  constructor(private examinationService: ExaminationService,private  medicinePharmacyService: MedicinePharmacyService, 
    private medicineService: MedicineService, private diagnosisService: DiagnosisService, 
    private _ActivatedRoute: ActivatedRoute, private router: Router,
    private toastrService: ToastrService) {
      if(!this.loggedUser){
        this.router.navigate(['login']);
        toastrService.info('Please login first!');
      }
  }

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
        this.availableMeds = data;
        console.log(data);
        this.isChecked = true;
        this.toastrService.info('Medicines are checked.');
      })
    }

    cancelExamination(){
      this.router.navigate(['/allexaminations']);
      this.toastrService.success('Examination has been canceled.');
    }

    patientIsHere(){
      this.patientCame = true;
      this.toastrService.info("Patient is here! Fill in report of examination.");
    }

    saveExamination(came: boolean){
      this.cannotSave = false;
      this.updateExam.id = this.examination.id;
      this.updateExam.email = this.examination.email;
      this.updateExam.patientDto = this.examination.patientDto;
      this.updateExam.schedule = this.examination.schedule;
      this.updateExam.pharmacyName = this.examination.pharmacyName;
      this.updateExam.price = this.examination.price;
      this.updateExam.patientCame = came;
      this.updateExam.prescription.diagnosis = [];
      this.updateExam.prescription.medicines = [];
      if(came == true){
        for(let d of this.selectedDiag){
          for(let dia of this.allDiagnosis){
            if(d.name == dia.name){
              this.updateExam.prescription.diagnosis.push(dia.id);
            }
          }
        }
        for(let m of this.selectedMeds){
          for(let a of this.availableMeds){
            if(a.name == m.medicine.name){
              if(a.available){
                for(let mia of this.medicines){
                  if(m.medicine.name == mia.medicine.name){
                    this.updateExam.prescription.medicines.push(mia.medicine.code);
                  }
                }
              }else{
                this.cannotSave = true;
                this.toastrService.error("Examination cannot be saved, because some medicines are not available.");
              }
            }
          }
        }    
      }

      if(!this.cannotSave){
        this.examinationService.updateExamination(this.updateExam).subscribe(exam => {
          console.log(exam);
          if(came == true){
            this.toSchedule = true;
            this.toastrService.success("Examination is saved.");
          }else{
            this.router.navigate(['/home']);
            this.toastrService.success("Examination is finished. Patient didn't come.");
          }
        })
      }
    }

    checkAvailabilityCancel(){
      this.isChecked = false;
      this.toastrService.info('Check has been canceled.');
    }

    scheduleExamination(){
      this.router.navigate(['/examination']);
      // proslediti pacijenta u urlu
    }

}
