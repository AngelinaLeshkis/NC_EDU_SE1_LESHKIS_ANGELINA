import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {PostComponent} from '../post/post.component';

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  constructor(public postWindow: MatDialog) {
  }

  ngOnInit(): void {
  }

  OpenPost() {
    this.postWindow.open(PostComponent, {autoFocus: false, maxHeight: '100hv'});
  }
}
