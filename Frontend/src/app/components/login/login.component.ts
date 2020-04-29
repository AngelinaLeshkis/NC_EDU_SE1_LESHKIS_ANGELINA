import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {User} from '../../model/User';
import {AuthenticationService} from '../../services/authentication.service';
import {FormControl, FormGroupDirective, NgForm} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {Login} from '../../model/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input()
  email: string;
  password: string;

  @Output()
  login: EventEmitter<{ email: string, password: string }> = new EventEmitter();

  private loginModel: Login [];


  matcher = new MyErrorStateMatcher();
  hide = true;

  loginForm: FormGroup;
  isSubmitted = false;
  loading = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      emailFormControl: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    });
  }


  _login() {
    this.login.next(this.loginForm.value);
    this.isSubmitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.authService.login(this.loginForm.value);
  }

}

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

