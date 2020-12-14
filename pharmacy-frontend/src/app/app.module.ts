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
import { QRCodeModule } from 'angularx-qrcode';
import { EPrescriptionComponent } from './component/e-prescription/e-prescription.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';

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
    EPrescriptionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    QRCodeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
