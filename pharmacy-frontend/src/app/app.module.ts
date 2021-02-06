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
import { ToastrModule } from 'ngx-toastr';
import { PharmacyAdminComponent } from './component/pharmacy-admin/pharmacy-admin.component';
import { PharmacistInitComponent } from './component/pharmacy-admin/pharmacist-init/pharmacist-init.component';
import { PharmacistComponent } from './component/pharmacy-admin/pharmacist/pharmacist.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { OrderInitComponent } from './component/pharmacy-admin/order-init/order-init.component';
import { AddPharmacyAdminComponent } from './system-admin/reg-pharmacy-admin/reg-pharmacy-admin.component';
import { RegSupplierComponent } from './system-admin/reg-supplier/reg-supplier.component';
import { ScheduleCounselingComponent } from './component/schedule-counseling/schedule-counseling.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DpDatePickerModule } from 'ng2-date-picker';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PriceInitComponent } from './component/pharmacy-admin/price-init/price-init.component';
import { AllCounselingsComponent } from './component/all-counselings/all-counselings.component';
import { RegSystemAdminComponent } from './system-admin/reg-system-admin/reg-system-admin.component';
import { ExaminationScheduleComponent } from './component/examination-schedule/examination-schedule.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { PublishingReservedMedicineComponent } from './component/publishing-reserved-medicine/publishing-reserved-medicine.component';
import { ScheduleVacationComponent } from './component/schedule-vacation/schedule-vacation.component';
import { StartCounselingComponent } from './component/start-counseling/start-counseling.component';
import { AllExaminationsComponent } from './component/all-examinations/all-examinations.component';
import { ScheduleExaminationDermatologistComponent } from './component/schedule-examination-dermatologist/schedule-examination-dermatologist.component';
import { DiagnosisComponent } from './component/diagnosis/diagnosis.component';
import { StartExaminationComponent } from './component/start-examination/start-examination.component';


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
    ScheduleCounselingComponent,
    AllCounselingsComponent,
    AddPharmacyComponent,
    RegDermatologistComponent,
    AddPharmacyAdminComponent,
    PharmacyAdminComponent,
    PharmacistInitComponent,
    PharmacistComponent,
    OrderInitComponent,
    RegSupplierComponent,
    ScheduleCounselingComponent,
    RegSystemAdminComponent,
    ExaminationScheduleComponent,
    UserProfileComponent,
    PriceInitComponent,
    PublishingReservedMedicineComponent,
    ScheduleVacationComponent,
    StartCounselingComponent,
    AllExaminationsComponent,
    ScheduleExaminationDermatologistComponent,
    DiagnosisComponent,
    StartExaminationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgSelectModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right'
    }),
    NgSelectModule,
    DpDatePickerModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
