import { Component, Input, Output } from '@angular/core';
import { EventEmitter } from 'stream';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  @Input() message: string = '';
  // @Output() messageEvent = new EventEmitter<string>;

  // sendMessage() {
  //   this.messageEvent.emit('Hello from test component');
  // }
}
