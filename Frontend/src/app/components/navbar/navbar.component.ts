import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../services/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  value: string;


  constructor(private authService: AuthenticationService,
              private router: Router
  ) {
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
