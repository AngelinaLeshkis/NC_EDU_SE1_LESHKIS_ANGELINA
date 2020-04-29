import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {PostComponent} from '../post/post.component';
import {PostViewComponent} from '../post-view/post-view.component';

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  showModal: boolean;
  content: string;
  title: string;

  constructor(public router: Router) {
  }

  ngOnInit(): void {
  }

  OpenPost() {
    this.router.navigateByUrl('/post-view');
  }

}
