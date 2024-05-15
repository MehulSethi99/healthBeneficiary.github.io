import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HealthPackage } from '../model/health-package';
@Injectable({
  providedIn: 'root'
})
export class HealthPackageService {
  baseURL = 'http://localhost:5433/HealthPackages';
  constructor(private http: HttpClient) { }

  getHealthPackages():Observable<any>{
    return this.http.get(this.baseURL);
  }
  getHealthPackage(HealthPackageId:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${HealthPackageId}`);
  }
  updateHealthPackage(healthPackage: HealthPackage):Observable<any>{
    return this.http.put(this.baseURL, healthPackage);
  }
  deleteHealthPackage(HealthPackageId: number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${HealthPackageId}`);
  }
 
}
