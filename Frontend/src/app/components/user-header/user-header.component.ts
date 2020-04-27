import {Component, OnInit} from '@angular/core';
import {User} from '../../model/user';
import {MatDialog} from '@angular/material/dialog';
import {AddPostComponent} from '../add-post/add-post.component';

@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit {

  public user: User;

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  OpenEditPage() {

  }

  OpenAddPostWindow() {
    this.dialog.open(AddPostComponent, {autoFocus: false});
  }

}
