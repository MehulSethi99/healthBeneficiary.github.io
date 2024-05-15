import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HealthPackage } from '../model/health-package';
import { HealthPackageService } from '../service/health-package.service';

@Component({
  selector: 'updatehealthpackage',
  templateUrl: './update-health-package.component.html',
  styleUrls: ['./update-health-package.component.css']
})
export class UpdateHealthPackageComponent implements OnInit {

  constructor(private service: HealthPackageService,
    private route: ActivatedRoute, 
    private router: Router) { }
    
    healthPackage: HealthPackage={packageId:null,packageName:"",packageAmount:null}
    msgClass: string;
    message: string = null;
    failMessage: string = null;
    validationMessages:string[]=null;
    header: String = "Update HealthPackage";
  ngOnInit() {
    this.route.paramMap.subscribe(
      (params)=>{
        let packageId:number=parseInt(params.get('packageId'))
        this.service.getHealthPackage(packageId).subscribe(
          (data)=>this.healthPackage=data,
          (fail)=>this.failMessage=fail.error.errorMessage
        )
      }
    )
  }
  updateHealth(){
    this.service.updateHealthPackage(this.healthPackage).subscribe(
      (resp)=>{
        this.message=resp.message
        this.msgClass='alert alert-success'
        this.validationMessages=null;

      },
      (fail)=>{
        this.message=fail.error.errorMessage;
        this.validationMessages=fail.error.errors;
        this.msgClass = 'alert alert-danger'
      }
    )
  }
  gotoList(){
    this.router.navigate(["healthpackagelist"])
  }
}
