import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// calendar
import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid'; 
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DpDatePickerModule } from 'ng2-date-picker';
import { NgSelectModule } from '@ng-select/ng-select';

import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ToastrModule } from 'ngx-toastr';
import { PharmacyAdminComponent } from './component/pharmacy-admin/pharmacy-admin.component';
import { PharmacistInitComponent } from './component/pharmacy-admin/pharmacist-init/pharmacist-init.component';
import { PharmacistComponent } from './component/pharmacy-admin/pharmacist/pharmacist.component';
import { OrderInitComponent } from './component/pharmacy-admin/order-init/order-init.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PriceInitComponent } from './component/pharmacy-admin/price-init/price-init.component';
import { ExaminationScheduleComponent } from './component/examination-schedule/examination-schedule.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { PublishingReservedMedicineComponent } from './component/publishing-reserved-medicine/publishing-reserved-medicine.component';
import { PharmacyProfileComponent } from './component/pharmacy-admin/pharmacy-profile/pharmacy-profile.component';
import { AllPharmacistsComponent } from './component/pharmacy-admin/all-pharmacists/all-pharmacists.component';
import { AllDermatologistsComponent } from './component/pharmacy-admin/all-dermatologists/all-dermatologists.component';
import { AllMedicationsComponent } from './component/pharmacy-admin/all-medications/all-medications.component';
import { ComplaintMessageComponent } from './component/complaint-message/complaint-message.component';
import { SystemAdminComponent } from './component/system-admin/system-admin.component';
import { AddMedicinesComponent } from './component/system-admin/add-medicines/add-medicines.component';
import { AddPharmacyComponent } from './component/system-admin/add-pharmacy/add-pharmacy.component';
import { RegDermatologistComponent } from './component/system-admin/reg-dermatologist/reg-dermatologist.component';
import { AddPharmacyAdminComponent } from './component/system-admin/reg-pharmacy-admin/reg-pharmacy-admin.component';
import { RegSupplierComponent } from './component/system-admin/reg-supplier/reg-supplier.component';
import { RegSystemAdminComponent } from './component/system-admin/reg-system-admin/reg-system-admin.component';
import { LoyalityComponent } from './component/system-admin/loyalty/loyalty.component';
import { ComplaintsComponent } from './component/system-admin/complaints/complaints.component';
import { PatientExaminationsComponent } from './component/patient-examinations/patient-examinations.component';

// dermatologist & pharmacist component
import { ScheduleCounselingComponent } from './component/schedule-counseling/schedule-counseling.component';
import { AllCounselingsComponent } from './component/all-counselings/all-counselings.component';
import { ScheduleVacationComponent } from './component/schedule-vacation/schedule-vacation.component';
import { StartCounselingComponent } from './component/start-counseling/start-counseling.component';
import { AllExaminationsComponent } from './component/all-examinations/all-examinations.component';
import { ScheduleExaminationDermatologistComponent } from './component/schedule-examination-dermatologist/schedule-examination-dermatologist.component';
import { DiagnosisComponent } from './component/diagnosis/diagnosis.component';
import { StartExaminationComponent } from './component/start-examination/start-examination.component';
import { WorkScheduleComponent } from './component/work-schedule/work-schedule.component';


FullCalendarModule.registerPlugins([
  dayGridPlugin,
  timeGridPlugin,
  interactionPlugin
])

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
    PharmacyProfileComponent,
    AllPharmacistsComponent,
    AllDermatologistsComponent,
    AllMedicationsComponent,
    ScheduleVacationComponent,
    StartCounselingComponent,
    AllExaminationsComponent,
    ScheduleExaminationDermatologistComponent,
    DiagnosisComponent,
    StartExaminationComponent,
    LoyalityComponent,
    ComplaintMessageComponent,
    ComplaintsComponent,
    PatientExaminationsComponent,
    WorkScheduleComponent
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
    FullCalendarModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
