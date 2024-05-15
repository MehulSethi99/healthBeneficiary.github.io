import { Component, OnInit } from '@angular/core';
import { Beneficiary } from '../model/beneficiary';
import { BeneficiaryService } from '../service/beneficiary.service';

@Component({
  selector: 'beneficiaryList',
  templateUrl: './beneficiary-list.component.html',
  styleUrls: ['./beneficiary-list.component.css']
})
export class BeneficiaryListComponent implements OnInit {

  constructor(private service:BeneficiaryService) { }

  ngOnInit():void {
    this.loadData();
  }
header:string="List of Beneficiaries";
beneficiaries:Beneficiary[];
message:String=null;
failMessage:string=null;

delete(beneficiaryId: number):void{
  this.service.deleteBeneficiary(beneficiaryId).subscribe(
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
loadData():void{
  this.service.getBeneficiaries().subscribe(
    (data)=>{
      this.beneficiaries=data;
      console.log(data);
    },
    (errorResponse)=>{
      this.failMessage=errorResponse.error.errorMessage
    }
  )
}


}
