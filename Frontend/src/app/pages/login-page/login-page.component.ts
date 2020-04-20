import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LocalStorageService} from '../../services/local-storage.service';
import {AuthenticationService} from '../../services/authentication.service';
import {FormBuilder} from '@angular/forms';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {


  constructor(private router: Router,
              private lss: LocalStorageService,
              private authService: AuthenticationService,
              private formBuilder: FormBuilder) {
  }

  _onLogin(event) {
    console.log(event);
    this.lss.setItem('credentials', JSON.stringify(event));

    this.router.navigateByUrl('/home');
  }


}
