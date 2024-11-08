import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./component/navbar/navbar.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wsu-test';
  imageUrl = "www.example.com";
  isVisible: boolean = true;
  items: string[] = ['Angular', 'React', 'Vue', 'Svelte'];
  backgroundColor: string = 'lightblue';
  fontSize: string = '16px';
  primaryColor: string = "blue";

  toggleStyle() {
    this.backgroundColor = this.backgroundColor === 'lightblue' ? 'lightcoral' : 'lighblue';
    this.fontSize = this.fontSize === '16px' ? '20px' : '16px';
  }

  toggleActive() {
    this.isVisible = !this.isVisible;
  }

  toggleColor() {
    this.primaryColor = this.primaryColor === 'blue' ? 'red' : 'blue';
  }
}
