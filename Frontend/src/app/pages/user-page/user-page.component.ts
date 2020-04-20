import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../../services/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  value: string;
  visibleImages: any [] = [];


  constructor(private authService: AuthenticationService,
              private router: Router,
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
