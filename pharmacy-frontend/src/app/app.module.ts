import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { SystemAdminComponent } from './system-admin/system-admin.component';
import { AddMedicinesComponent } from './system-admin/add-medicines/add-medicines.component';
import { AddPharmacyComponent } from './system-admin/add-pharmacy/add-pharmacy.component';
import { RegDermatologistComponent } from './system-admin/reg-dermatologist/reg-dermatologist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import { PharmacyAdminComponent } from './component/pharmacy-admin/pharmacy-admin.component';
import { PharmacistInitComponent } from './component/pharmacy-admin/pharmacist-init/pharmacist-init.component';
import { PharmacistComponent } from './component/pharmacy-admin/pharmacist/pharmacist.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { AddPharmacyAdminComponent } from './system-admin/reg-pharmacy-admin/reg-pharmacy-admin.component';
import { RegSupplierComponent } from './system-admin/reg-supplier/reg-supplier.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    HospitalComponent,
    ActionsBenefitsComponent,
    MedicineComponent,
    UploadQRComponent,
    NavbarComponent,
    SystemAdminComponent,
    AddMedicinesComponent,
    AddPharmacyComponent,
    RegDermatologistComponent,
    AddPharmacyAdminComponent,
    PharmacyAdminComponent,
    PharmacistInitComponent,
    PharmacistComponent,
    RegSupplierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right'
    }),
    NgSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
