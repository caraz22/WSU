import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { NgForOf } from '@angular/common';
import { UserService } from '../services/user.service';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [NgForOf, FormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {
  users: User[] = [];
  selectedUser: User | null = null;
  newUser: User = {id: 0, name: '', email: ''};

  constructor(private readonly userService: UserService, private readonly route: ActivatedRoute, private readonly router: Router) { }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.users = this.userService.getUsers();
  }

  goToUserDetail(user: User) {
    this.router.navigate(['/user', user.id]);
  }

  selectUser(user: User) {
    this.selectedUser = user;
  }

  addUser(user: User) {
    const newId = user.id;
    const newName = user.name;
    const newEmail = user.email;
    this.newUser = {id: newId, name: newName, email: newEmail};
    this.userService.addUser(this.newUser);
    this.loadUsers();
  }
}
