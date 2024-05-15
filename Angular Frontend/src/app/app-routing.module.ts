import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminComponent } from './admin/admin.component';
import { BeneficiaryListComponent } from './beneficiary-list/beneficiary-list.component';
import { CreateBeneficiaryComponent } from './create-beneficiary/create-beneficiary.component';
import { HealthPackageListComponent } from './health-package-list/health-package-list.component';


import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuardService } from './service/auth-guard.service';
import { SignupComponent } from './signup/signup.component';

import { UpdateHealthPackageComponent } from './update-health-package/update-health-package.component';


const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:'beneficiaryList',component:BeneficiaryListComponent,canActivate:[AuthGuardService]},
  {path:'healthpackagelist',component:HealthPackageListComponent,canActivate:[AuthGuardService]},
  {path:'create',component:CreateBeneficiaryComponent,canActivate:[AuthGuardService]},
  {path:'updated/:packageId',component:UpdateHealthPackageComponent,canActivate:[AuthGuardService]},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'home/login',component:LoginComponent},
  {path:'logout',component:LogoutComponent},
  {path:'signup',component:SignupComponent},
  {path:'home/signup',component:SignupComponent},
  {path:'adminlogin',component:AdminLoginComponent},
  {path:'home/adminlogin',component:AdminLoginComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGuardService]},
  {path:'admin/beneficiaryList',component:BeneficiaryListComponent,canActivate:[AuthGuardService]},
  {path:'admin/healthpackagelist',component:HealthPackageListComponent,canActivate:[AuthGuardService]},
  {path:'about',component:AboutComponent},
  {path:'home/about',component:AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
