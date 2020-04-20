import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LocalStorageService} from '../../services/local-storage.service';
import {AuthenticationService} from '../../services/authentication.service';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(private router: Router,
              private lss: LocalStorageService,
              private authService: AuthenticationService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  _onRegister(event) {
    console.log(event);
    this.lss.setItem('credentials', JSON.stringify(event));

    this.router.navigateByUrl('/home');
  }
}
