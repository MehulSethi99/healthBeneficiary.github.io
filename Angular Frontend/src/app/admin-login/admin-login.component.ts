import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  message: string=null;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    ) { }
  ngOnInit() {
  }
  login(credentials) {
    this.authenticationService.login(credentials)
      .subscribe(result => {
        this.router.navigate(['/admin']);
        this.message=null;
      },
         fail => {
          this.message = fail.error.errorMessage;
        }
      );
      }
}
