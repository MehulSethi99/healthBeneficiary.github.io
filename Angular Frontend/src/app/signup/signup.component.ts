import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  message: string = null;
  validationMessages:string[]=null
  constructor(private service: UserService, private router:Router) { }

  ngOnInit() {
  }
  msgClass:string;
  
  createNew(data: User) {
    this.service.saveUser(data).subscribe(
     (resp)=>{
      this.message = resp.message
      this.msgClass = 'alert alert-success'
      this.validationMessages=null;
     },
     (fail)=>{
      this.message = fail.error.errorMessage;
      this.validationMessages=fail.error.errors;
      this.msgClass = 'alert alert-danger'

     }

   )
}
login() {
  this.router.navigate(["/login"])
  }
}
