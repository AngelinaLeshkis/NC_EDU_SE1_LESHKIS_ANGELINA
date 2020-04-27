import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../../services/authentication.service';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {PostComponent} from '../../components/post/post.component';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {


  constructor() {
  }

  ngOnInit(): void {
  }


}
