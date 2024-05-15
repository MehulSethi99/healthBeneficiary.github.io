import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Beneficiary } from "../model/beneficiary";
import { HealthPackage } from "../model/health-package";
import { BeneficiaryService } from "../service/beneficiary.service";
import { HealthPackageService } from "../service/health-package.service";

@Component({
  selector: 'create-beneficiary',
  templateUrl: './create-beneficiary.component.html',
  styleUrls: ['./create-beneficiary.component.css']
})
export class CreateBeneficiaryComponent implements OnInit {

 
healthPackage:HealthPackage[];

  message:string=null;
  validationMessages:string[]=null;
 constructor(private service:BeneficiaryService,private router:Router,
  private hservice:HealthPackageService
  ) { }

 ngOnInit() {
   this.hservice.getHealthPackages().subscribe(
     (data)=>this.healthPackage=data
   )

 }
 msgClass:string;
 createNew(data) {
  let healthPackage:HealthPackage={packageId:data.healthPackages,packageName:null,packageAmount:null};
   let beneficiary:Beneficiary={beneficiaryId:data.beneficiary,beneficiaryFirstName:data.beneficiaryFirstName,beneficiaryLastName:data.beneficiaryLastName,beneficiaryAge:data.beneficiaryAge,beneficiaryEmailId:data.beneficiaryEmailId,beneficiaryAddress:data.beneficiaryAddress,beneficiaryMobileNumber:data.beneficiaryMobileNumber,healthPackage:healthPackage,preference:data.preference,choice:data.choice};
   
  this.service.saveBeneficiary(beneficiary).subscribe(
    (resp)=>{
      this.message=resp.message
      console.log(beneficiary)
      this.msgClass='alert alert-success'
      this.validationMessages= null;
     },
     (fail)=>{
       this.message=fail.error.errorMessage;
       this.validationMessages=fail.error.errors;
       this.msgClass='alert alert-danger'
     }
  )
}

home() {
 this.router.navigate(["home"])
}
}
