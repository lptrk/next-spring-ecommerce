import { Component } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { LoginService } from 'src/app/core/auth/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  email = new FormControl();
  password = new FormControl();

  constructor(private login: LoginService) {}

  onSubmit(form: NgForm) {
    this.login.loginUser.email = this.email.value;
    this.login.loginUser.password = this.password.value;
    this.login.Login();
  }
}
