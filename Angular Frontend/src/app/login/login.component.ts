import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message: string=null;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    ) { }
  ngOnInit(): void {
   
  }
    login(credentials) {
      this.authenticationService.login(credentials)
        .subscribe(result => {
          this.router.navigate(['/create']);
          this.message=null;
        },
           fail => {
            this.message = fail.error.errorMessage;
          }
        );
        }
    
 

}
