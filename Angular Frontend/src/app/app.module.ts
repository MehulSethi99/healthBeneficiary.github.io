import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BeneficiaryListComponent } from './beneficiary-list/beneficiary-list.component';
import { HealthPackageListComponent } from './health-package-list/health-package-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CreateBeneficiaryComponent } from './create-beneficiary/create-beneficiary.component';


import { UpdateHealthPackageComponent } from './update-health-package/update-health-package.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { JwtInterceptorService } from './service/jwt-interceptor.service';
import { SignupComponent } from './signup/signup.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AboutComponent } from './about/about.component';


@NgModule({
  declarations: [
    AppComponent,
    BeneficiaryListComponent,
    HealthPackageListComponent,
    CreateBeneficiaryComponent,
  
    UpdateHealthPackageComponent,
    LoginComponent,
    LogoutComponent,
    SignupComponent,
    HomeComponent,
    FooterComponent,
    AdminComponent,
    AdminLoginComponent,
    AboutComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService,multi:true }
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
