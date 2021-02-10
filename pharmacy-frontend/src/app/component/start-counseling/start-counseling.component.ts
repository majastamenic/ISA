import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
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

  constructor(private allCounseling: CounselingsService, private diagnosisService: DiagnosisService, 
    private  medicinePharmacyService: MedicinePharmacyService, private medicineService: MedicineService,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
      this.allCounseling.startCounseling(this.id).subscribe(startCoun =>{
        this.counseling = startCoun;
        console.log(startCoun);
        /*this.medicinePharmacyService.getMedicinesByPharmacy(this.counseling.pharmacyName, this.counseling.patientDto.user.email).subscribe((data: any[]) => {
          this.medicines = data;
          for(let i of this.medicines){
            let med = i.medicine.name;
            i.label = med;
            this.names.push(med);
          }
        });*/
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

  checkAvailabilityCancel(){
    this.isChecked = false;
    this.toastrService.info('Check has been canceled.');
  }

}
