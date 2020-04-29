import {Component, OnInit} from '@angular/core';
import {User} from '../../model/User';
import {MatDialog} from '@angular/material/dialog';
import {AddPostComponent} from '../add-post/add-post.component';

@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit {

  public user: User;

  constructor() {
  }

  ngOnInit(): void {
  }

  subscribe() {

  }

  unsubscribe() {

  }

}
