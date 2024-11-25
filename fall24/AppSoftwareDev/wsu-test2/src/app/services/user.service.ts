import { Injectable } from '@angular/core';
import { User } from '../../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private users: User[] = [
    {id: 1, name: 'John Doe', email:'johndoe@example.com'},
    {id: 2, name: 'Alice Doe', email:'alicedoe@example.com'},    
  ];

  constructor() { }

  getUsers(): User[] {
    return this.users;
  }

  getUserById(id: number): User | undefined {
    return this.users.find(user => user.id === id);
  }  

  addUser(user: User) {
    this.users.push(user);
  }

  updateUser(user: User) {
    const index = this.users.findIndex(u => u.id === user.id);
    this.users[index] = user;
  }

  deleteUser(id: number) {
    this.users = this.users.filter(user => user.id !== id);
  }
}
