import {Component, OnInit} from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public user: User;

  constructor() {
  }

  ngOnInit(): void {
  }

}
