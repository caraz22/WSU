import { Component, computed, Signal } from '@angular/core';

import { HttpWrapperService } from '../http-wrapper.service';

@Component({
  selector: 'app-toast-message',
  standalone: true,
  imports: [],
  templateUrl: './toast-message.component.html',
  styleUrl: './toast-message.component.scss'
})
export class ToastMessageComponent {

  constructor(private _httpService: HttpWrapperService) {
  }

  httpStatus: Signal<string> = computed(() => this._httpService.status() + this._httpService.message()); // reformat this eventually, but you get the idea
}
