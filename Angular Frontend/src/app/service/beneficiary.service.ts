import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beneficiary } from '../model/beneficiary';

@Injectable({
  providedIn: 'root'
})
export class BeneficiaryService {
  baseURL = 'http://localhost:5433/Beneficiaries';

  constructor(private http: HttpClient) { }

  getBeneficiaries():Observable<any>{
    return this.http.get(this.baseURL);
  }
  getBeneficiary(beneficiaryId:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${beneficiaryId}`)
  }
  updateBeneficiary(beneficiary: Beneficiary):Observable<any>{
    return this.http.put(this.baseURL, beneficiary);
  }
  deleteBeneficiary(BeneficiaryId: number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${BeneficiaryId}`);
  }
  saveBeneficiary(beneficiary:Beneficiary):Observable<any>{
    return this.http.post(this.baseURL, beneficiary);
  }
}
