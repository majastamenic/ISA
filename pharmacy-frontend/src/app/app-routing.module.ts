import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { AllCounselingsComponent } from './component/all-counselings/all-counselings.component';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { EPrescriptionComponent } from './component/prescription/e-prescription/e-prescription.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';
import { ScheduleCounselingComponent } from './component/schedule-counseling/schedule-counseling.component';
import { LoginComponent } from './component/user/login/login.component';
import { AddMedicinesComponent } from './component/user/profile/system_admin/add-medicines/add-medicines.component';
import { RegistrationComponent } from './component/user/registration/registration.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: RegistrationComponent},
  {path: 'hospital', component: HospitalComponent},
  {path: 'actions', component: ActionsBenefitsComponent},
  {path: 'medicine', component: MedicineComponent},
  {path: 'uploadQR', component: UploadQRComponent},
  { path: 'ePrescription', component: EPrescriptionComponent },
  { path: 'addMedicines', component: AddMedicinesComponent},
  { path: 'counseling', component: ScheduleCounselingComponent},
  { path: 'allcounselings', component: AllCounselingsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
