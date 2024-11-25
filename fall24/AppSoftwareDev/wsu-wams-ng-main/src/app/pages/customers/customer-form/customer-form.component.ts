import { Component, EventEmitter, Output } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { Customer } from '../../../models/customer.model';
import {NgIf} from "@angular/common";
import { STATES } from '../../../models/states.model';
import {DropdownModule} from "primeng/dropdown";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgIf,
    DropdownModule
  ],
  standalone: true
})
export class CustomerFormComponent {
  @Output() formSubmitted = new EventEmitter<Customer>();
  customerForm: FormGroup;
  stateOptions = STATES.map(state => ({ label: state.name, value: state.code }));

  constructor(private fb: FormBuilder) {
    this.customerForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      lastName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      email: ['', [Validators.required, Validators.email]],
      addressLine1: ['', Validators.required],
      city: ['', Validators.required],
      state: [
        '',
        [Validators.required, Validators.pattern(/^[A-Z]{2}$/)],
      ],
      zip: [
        '',
        [Validators.required, Validators.pattern(/^\d{5}(-\d{4})?$/)],
      ],
    });
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.customerForm.get(controlName);
    return control ? control.invalid && control.touched : false;
  }

  onSubmit(): void {
    if (this.customerForm.valid) {
      const newCustomer: Customer = this.customerForm.value;
      this.formSubmitted.emit(newCustomer);
      this.customerForm.reset({
        firstName: '',
        lastName: '',
        phoneNumber: '',
        email: '',
        addressLine1: '',
        city: '',
        state: '',
        zip: '',
      });
    } else {
      this.customerForm.markAllAsTouched();
    }
  }
}
