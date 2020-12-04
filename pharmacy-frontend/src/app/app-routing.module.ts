import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: RegistrationComponent},
  {path: 'hospital', component: HospitalComponent},
  {path: 'actions', component: ActionsBenefitsComponent},
  {path: 'medicine', component: MedicineComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
