import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  message:string;
  constructor(authService:AuthenticationService) {
    if(authService.isLoggedIn()){
    authService.logout();
    this.message="Thank you for visiting, you have been successfully logged out!";
    }
    else{
      this.message="You have not loogged in";
    }
   }
  ngOnInit() {
    
  }

}
