import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AllCounselingsComponent } from './component/pharmacist/all-counselings/all-counselings.component';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { PharmacistInitComponent } from './component/pharmacy-admin/pharmacist-init/pharmacist-init.component';
import { PharmacistComponent } from './component/pharmacy-admin/pharmacist/pharmacist.component';
import { ScheduleCounselingComponent } from './component/pharmacist/schedule-counseling/schedule-counseling.component';
import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';
import { PriceInitComponent } from './component/pharmacy-admin/price-init/price-init.component';
import { OrderInitComponent } from './component/pharmacy-admin/order-init/order-init.component';
import { PublishingReservedMedicineComponent } from './component/pharmacist/publishing-reserved-medicine/publishing-reserved-medicine.component';
import { PharmacyProfileComponent } from './component/pharmacy-admin/pharmacy-profile/pharmacy-profile.component';
import { AllPharmacistsComponent } from './component/pharmacy-admin/all-pharmacists/all-pharmacists.component';
import { AllDermatologistsComponent } from './component/pharmacy-admin/all-dermatologists/all-dermatologists.component';
import { AllMedicationsComponent } from './component/pharmacy-admin/all-medications/all-medications.component';
import { ScheduleVacationComponent } from './component/schedule-vacation/schedule-vacation.component';
import { StartCounselingComponent } from './component/pharmacist/start-counseling/start-counseling.component';
import { AllExaminationsComponent } from './component/dermatologist/all-examinations/all-examinations.component';
import { ScheduleExaminationDermatologistComponent } from './component/dermatologist/schedule-examination-dermatologist/schedule-examination-dermatologist.component';
import { DiagnosisComponent } from './component/dermatologist/diagnosis/diagnosis.component';
import { StartExaminationComponent } from './component/dermatologist/start-examination/start-examination.component';
import { SystemAdminComponent } from './component/system-admin/system-admin.component';
import { AddMedicinesComponent } from './component/system-admin/add-medicines/add-medicines.component';
import { ComplaintsComponent } from './component/system-admin/complaints/complaints.component';
import { LoyalityComponent } from './component/system-admin/loyalty/loyalty.component';
import { RegSupplierComponent } from './component/system-admin/reg-supplier/reg-supplier.component';
import { RegSystemAdminComponent } from './component/system-admin/reg-system-admin/reg-system-admin.component';
import { RegDermatologistComponent } from './component/system-admin/reg-dermatologist/reg-dermatologist.component';
import { AddPharmacyAdminComponent } from './component/system-admin/reg-pharmacy-admin/reg-pharmacy-admin.component';
import { AddPharmacyComponent } from './component/system-admin/add-pharmacy/add-pharmacy.component';
import { WorkScheduleComponent } from './component/work-schedule/work-schedule.component';
import { CounselingsComponent } from './component/patient/counselings/counselings.component';
import { CommonModule } from '@angular/common';
import { AddOrderComponent } from './component/add-order/add-order.component';
import { ViewOrdersComponent } from './component/supplier/view-orders/view-orders.component';
import { UserProfileComponent } from './component/user/profile/user-profile.component';
import { UploadQRComponent } from './component/patient/upload-qr/upload-qr.component';
import { EPrescriptionsComponent } from './component/patient/e-prescriptions/e-prescriptions.component';
import { SubscribeListComponent } from './component/patient/subscribe-list/subscribe-list.component';
import { ComplaintMessageComponent } from './component/patient/complaint-message/complaint-message.component';
import { PatientExaminationsComponent } from './component/patient/patient-examinations/patient-examinations.component';
import { ExaminationScheduleComponent } from './component/patient/examination-schedule/examination-schedule.component';
import { CounselingSearchComponent } from './component/patient/counseling-search/counseling-search.component';
import { CounselingScheduleComponent } from './component/patient/counseling-schedule/counseling-schedule.component';
import { ActionsBenefitsComponent } from './component/pharmacy-admin/actions-benefits/actions-benefits.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'user', component: RegistrationComponent },
  { path: 'hospital', component: HospitalComponent },
  { path: 'medicines', component: MedicineComponent },
  //Patient
  { path: 'actions', component: ActionsBenefitsComponent },
  { path: 'uploadQR', component: UploadQRComponent },
  { path: 'eprescriptions', component: EPrescriptionsComponent },
  { path: 'subscribe-list', component: SubscribeListComponent},
  { path: 'add-complaint', component: ComplaintMessageComponent},

  { path: 'patient/examinations', component: PatientExaminationsComponent},
  { path: 'patient/examinationSchedule/:pharmacyName', component: ExaminationScheduleComponent},
  { path: 'patient/counselings', component: CounselingsComponent},
  { path: 'patient/counselingSearch', component: CounselingSearchComponent},
  { path: 'patient/counselingSchedule/:pharmacyName', component: CounselingScheduleComponent},
  
  //System admin
  {
    path: 'system-admin', component: SystemAdminComponent,
    children: [
      { path: 'addPharmacyAdmin', component: AddPharmacyAdminComponent },
      { path: 'regDermatologist', component: RegDermatologistComponent },
      { path: 'regSysAdmin', component: RegSystemAdminComponent },
      { path: 'regSupplier', component: RegSupplierComponent },
    ]
  },
  { path: 'add-medicines', component: AddMedicinesComponent },
  { path: 'add-pharmacy', component: AddPharmacyComponent },
  { path: 'loyalty', component: LoyalityComponent },
  { path: 'complaints', component: ComplaintsComponent},

  //Pharmacist
  { path: 'counseling', component: ScheduleCounselingComponent },
  { path: 'allcounselings', component: AllCounselingsComponent },
  { path: 'allcounselings/:id', component: StartCounselingComponent},
  { path: 'counseling/:pathParam', component: ScheduleCounselingComponent},
  //Dermatologist
  { path: 'examinationSchedule/:pharmacyName', component: ExaminationScheduleComponent},
  { path: 'scheduledExaminations', component: PatientExaminationsComponent},
  { path: 'diagnosis', component: DiagnosisComponent},
  { path: 'allexaminations', component: AllExaminationsComponent},
  { path: 'allexaminations/:id', component: StartExaminationComponent},
  { path: 'examination/:pathParam', component: ScheduleExaminationDermatologistComponent},
  // Dermatologist & Pharmacist
  { path: 'work/schedule', component: WorkScheduleComponent},
  { path: 'diagnosis', component: DiagnosisComponent},
  { path: 'schedule/vacation', component: ScheduleVacationComponent},

  //Pharmacy admin

  { path: 'pharmacist', component: PharmacistComponent},
  { path: 'pharmacist/init', component: PharmacistInitComponent},
  { path: 'price/init', component: PriceInitComponent},
  
  { path: 'order/init', component: OrderInitComponent},
  { path: 'medicine/reserved', component: PublishingReservedMedicineComponent},
  { path: 'pharmacy/:pharmacyName', component: PharmacyProfileComponent},
  { path: 'pharmacists/:id', component: AllPharmacistsComponent},
  { path: 'dermatologists', component: AllDermatologistsComponent},
  { path: 'medications/:id', component: AllMedicationsComponent},
  
  
  //Supplier
  { path: 'add-complaint', component: ComplaintMessageComponent},
  { path: 'order', component: AddOrderComponent},
  { path: 'view-orders', component: ViewOrdersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule],
})
export class AppRoutingModule { }
