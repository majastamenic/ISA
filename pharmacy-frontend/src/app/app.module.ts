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
import { AddPharmacyAdminComponent } from './system-admin/add-pharmacy-admin/add-pharmacy-admin.component';

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
    AddPharmacyAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
