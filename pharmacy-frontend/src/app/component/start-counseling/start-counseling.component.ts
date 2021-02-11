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
  names: any[]=[];
  selectedMeds: any[]=[];
  examination: any;
  medicines: any[]=[];
  meds: any[]=[];
  availableMeds: any[]=[];
  isChecked: boolean = false;
  specification: any;
  isSpec: boolean = false;
  public model: any;
  toSchedule: boolean = false;
  cannotSave: boolean = false;
  patientCame: boolean = false;
  days: any;
  updateCouns: CounselingDto = { id:0, email:'', patientDto:{}, schedule: {id:''}, report: {days:'', medicines:[]}, patientCame: false , loyaltyGroup: ''};

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  constructor(private allCounseling: CounselingsService, private  medicinePharmacyService: MedicinePharmacyService, private medicineService: MedicineService,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService,
    private router: Router,) { 
      if(!this.loggedUser){
        this.router.navigate(['login']);
        toastrService.info('Please login first!');
      }
  }

  ngOnInit(): void {
    if(this.loggedUserRole == 'PHARMACIST'){
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
    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have access rights for this page!');
    }
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



  // do ovde je okej
  saveCounseling(came: boolean){
    this.cannotSave = false;
    this.updateCouns.id = this.counseling.id;
    this.updateCouns.email = this.counseling.email;
    this.updateCouns.patientDto = this.counseling.patientDto;
    this.updateCouns.schedule = this.counseling.schedule;
    this.updateCouns.patientCame = came;
    this.updateCouns.report.medicines = [];
    if(came == true){
      for(let m of this.selectedMeds){
        for(let a of this.availableMeds){
          if(a.name == m.medicine.name){
            if(a.available){
              for(let mia of this.medicines){
                if(m.medicine.name == mia.medicine.name){
                  this.updateCouns.report.medicines.push(mia.medicine.code);
                }
              }
            }else{
              this.cannotSave = true;
              this.toastrService.error("Counseling cannot be saved, because some medicines are not available.");
            }
          }
        }
      }    
    }

    if(!this.cannotSave){
      this.allCounseling.updateCounseling(this.updateCouns).subscribe(couns => {
        console.log(couns);
        if(came == true){
          this.toSchedule = true;
          this.toastrService.success("Counseling is saved.");
        }else{
          this.router.navigate(['/home']);
          this.toastrService.success("Counseling is finished. Patient didn't come.");
        }
      })
    }
  }

  
  patientIsHere(){
    this.patientCame = true;
    this.toastrService.info("Patient is here! Fill in report of counseling.");
  }

  scheduleCounseling(){
    //this.router.navigate(['/examination']);
    // proslediti i pacijenta u urlu
  }


}
