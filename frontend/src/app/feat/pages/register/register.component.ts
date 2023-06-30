import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/core/auth/register/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  firstname = new FormControl();
  lastname = new FormControl();
  username = new FormControl();
  email = new FormControl();
  password = new FormControl();

  constructor(
    private register: RegisterService,
    private http: HttpClient,
    private router: Router
  ) {}

  onSubmit(form: NgForm) {
    this.register.registerUser.firstName = this.firstname.value;
    this.register.registerUser.lastName = this.lastname.value;
    this.register.registerUser.userName = this.username.value;
    this.register.registerUser.email = this.email.value;
    this.register.registerUser.password = this.password.value;
    this.register.registerUser.updatedAt = new Date();
    this.register.registerUser.updatedAt = new Date();
    this.register.Register();

    this.router.navigate(['/login']);
  }
}
