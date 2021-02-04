import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { PharmacistInitComponent } from './component/pharmacy-admin/pharmacist-init/pharmacist-init.component';
import { PharmacistComponent } from './component/pharmacy-admin/pharmacist/pharmacist.component';
import { EPrescriptionComponent } from './component/prescription/e-prescription/e-prescription.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';
import { ScheduleCounselingComponent } from './component/schedule-counseling/schedule-counseling.component';
import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';
import { AddMedicinesComponent } from './system-admin/add-medicines/add-medicines.component';
import { AddPharmacyAdminComponent } from './system-admin/reg-pharmacy-admin/reg-pharmacy-admin.component';
import { AddPharmacyComponent } from './system-admin/add-pharmacy/add-pharmacy.component';
import { RegDermatologistComponent } from './system-admin/reg-dermatologist/reg-dermatologist.component';
import { SystemAdminComponent } from './system-admin/system-admin.component';
import { RegSupplierComponent } from './system-admin/reg-supplier/reg-supplier.component';
import { PriceInitComponent } from './component/pharmacy-admin/price-init/price-init.component';
import { OrderInitComponent } from './component/pharmacy-admin/order-init/order-init.component';

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
  {path: 'system-admin', component: SystemAdminComponent,
    children : [
      { path: 'addMedicines', component: AddMedicinesComponent},
      { path: 'addPharmacy', component: AddPharmacyComponent},
      { path: 'addPharmacyAdmin', component: AddPharmacyAdminComponent},
      { path: 'regDermatologist', component: RegDermatologistComponent},
      { path: 'regSupplier', component: RegSupplierComponent},
    ]
  },
  { path: 'pharmacist', component: PharmacistComponent},
  { path: 'pharmacist/init', component: PharmacistInitComponent},
  { path: 'price/init', component: PriceInitComponent},
  { path: 'counseling', component: ScheduleCounselingComponent},
  { path: 'order/init', component: OrderInitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
