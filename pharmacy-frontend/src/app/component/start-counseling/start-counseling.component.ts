import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { logging } from 'protractor';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { CounselingDto } from 'src/app/model/counseling';
import { Diagnosis } from 'src/app/model/diagnosis';
import { CounselingsService } from 'src/app/service/counselings.service';
import { DiagnosisService } from 'src/app/service/diagnosis.service';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-start-counseling',
  templateUrl: './start-counseling.component.html',
  styleUrls: ['./start-counseling.component.css']
})
export class StartCounselingComponent implements OnInit {

  id: any;
  counseling: any;
  allDiagnosis: any[]=[];
  diagnosis: Diagnosis={name:''};
  names: any[]=[];
  selectedDiag: any[]=[];
  selectedMeds: any[]=[];
  examination: any;
  medicines: any[]=[];
  meds: any[]=[];
  availableMeds: any[]=[];
  isChecked: boolean = false;
  specification: any;
  isSpec: boolean = false;
  public model: any;
  updateCounseling: CounselingDto = { id:0, email:'', patientDto:{}, schedule: {id:''}, report: {days:'', medicines:[]}, patientCame: false , loyaltyGroup: ''};

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  constructor(private allCounseling: CounselingsService, private diagnosisService: DiagnosisService, 
    private  medicinePharmacyService: MedicinePharmacyService, private medicineService: MedicineService,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService,
    private router: Router,) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
      this.allCounseling.startCounseling(this.id).subscribe(startCoun =>{
        this.counseling = startCoun;
        console.log(startCoun);
        this.medicinePharmacyService.getMedicinesByPharmacist(this.loggedUser, this.counseling.patientDto.user.email).subscribe((data: any[]) => {
          this.medicines = data;
          console.log(this.medicines);
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
    this.medicineService.checkAvailabilityMedsByPharmacist(this.loggedUser, this.meds).subscribe((data:any[]) => {
      this.availableMeds = data;
      console.log(data);
      this.isChecked = true;
      this.toastrService.info('Medicines are checked.');
    })
  }

  checkAvailabilityCancel(){
    this.isChecked = false;
    this.toastrService.info('Check has been canceled.');
  }

  cancelCounseling(){
    this.router.navigate(['/allcounselings']);
    this.toastrService.success('Counseling has been canceled.');
  }

  saveCounseling(came: boolean){
    /*this.cannotSave = false;
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
    }*/

    /*if(!this.cannotSave){
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
    }*/
  }

  findSpecification(){
    this.isSpec = false;
    if(this.model != ''){
      this.medicineService.findMedicineSpecification(this.model).subscribe(data => {
        this.specification = data;
        console.log(data);
        this.isSpec = true;
        this.toastrService.success("Slide down to see specification of requered medicine.");
      }, error => {
        this.toastrService.info('Pharmacy do not have that medicine.');
      });
    }else{
      this.toastrService.info('Please input medicine name.');
    }
    
  }

}
