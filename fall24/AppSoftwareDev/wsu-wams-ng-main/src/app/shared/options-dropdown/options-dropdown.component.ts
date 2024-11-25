import { Component, EventEmitter, Input, Output } from '@angular/core';
import { SharedModule } from '../shared.module';
import { OptionPair } from '../shared.model';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-options-dropdown',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './options-dropdown.component.html',
  styleUrl: './options-dropdown.component.scss',
  animations: [
    trigger(
      'expandContract',
      [
        transition(
          ':enter',
          [
            style({height: 0, opacity: 0}),
            animate('.5s ease-out'),
            style({height: 'auto', opacity:1})
          ]
        )
      ]
    )
  ]
})

export class OptionsDropdownComponent {

  @Input() options: OptionPair[] = []; // options to be displayed
  @Output() optionSelected: EventEmitter<OptionPair> = new EventEmitter<OptionPair>;
  displayOptions: boolean = false; // simple boolean for whether or not we want to display options
  currentOption: string = ''; // track currently selected option

  constructor() {
  }

  setOption(option: OptionPair) { // select an option
    this.currentOption = option.displayLabel;
    this.displayOptions = false;
    this.optionSelected.emit(option)
  }

}
