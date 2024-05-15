import { Component, OnInit } from '@angular/core';
import { HealthPackage } from '../model/health-package';
import { HealthPackageService } from '../service/health-package.service';

@Component({
  selector: 'healthpackagelist',
  templateUrl: './health-package-list.component.html',
  styleUrls: ['./health-package-list.component.css']
})
export class HealthPackageListComponent implements OnInit {

  constructor(private service: HealthPackageService) { }

  ngOnInit(): void  {
    this.loadData();
  }
  header: String = "List of Health Package";
  healthPackages: HealthPackage[];

    message: String=null;
    failMessage: String=null;
  
    loadData():void{
      this.service.getHealthPackages().subscribe(
        (data)=>{
          this.healthPackages=data;
        },
        (errorResponse)=>{
          this.failMessage=errorResponse.error.errorMessage
        }
      )
    }
    delete(packageId:number):void{
      this.service.deleteHealthPackage(packageId).subscribe(
        (response)=>{
          this.message=response.message;
          this.loadData();
        },
        (errorResponse)=>{
          this.message=errorResponse.error.errorMessage
          this.loadData();
        }
      )
    }
    updateComplete(message:String){
      this.message=message;
    }
    
}
