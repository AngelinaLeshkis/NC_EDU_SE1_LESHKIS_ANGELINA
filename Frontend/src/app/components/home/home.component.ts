import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


import {AuthenticationService} from '../../services/authentication.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  value: string;

  constructor(private authService: AuthenticationService, private router: Router) {
  }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }

  onPClick() {
    this.router.navigateByUrl('/user-page');
  }

  onHClick() {
    this.router.navigateByUrl('/home');
  }
}
