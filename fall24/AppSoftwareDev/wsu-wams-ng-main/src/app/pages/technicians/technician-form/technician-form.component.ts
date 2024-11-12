import { Component, EventEmitter, Output } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Technician} from "../../../models/technician.model";
import {NgForOf, NgIf} from "@angular/common";
import {STATES} from "../../../models/states.model";
import {MultiSelectModule} from "primeng/multiselect";

@Component({
  selector: 'app-technician-form',
  templateUrl: './technician-form.component.html',
  styleUrls: ['./technician-form.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgIf,
    NgForOf,
    MultiSelectModule
  ],
  standalone: true
})
export class TechnicianFormComponent {

  @Output() formSubmitted = new EventEmitter<Technician>();
  technicianForm: FormGroup;
  stateOptions = STATES.map(state => ({ label: state.name, value: state.code }));

  constructor(private fb: FormBuilder) {
    this.technicianForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      lastName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      type: ['', Validators.required],
      workPermits: this.fb.array([]),
    });
  }

  get workPermits(): FormArray {
    return this.technicianForm.get('workPermits') as FormArray;
  }

  onStateChange(selectedStates: string[]): void {
    this.workPermits.clear();
    selectedStates.forEach(code => this.addWorkPermit(code));
  }

  addWorkPermit(code: string): void {
    this.workPermits.push(this.fb.group({ code }));
  }

  removeWorkPermit(index: number): void {
    this.workPermits.removeAt(index);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.technicianForm.get(controlName);
    return control ? control.invalid && control.touched : false;
  }

  onSubmit(): void {
    if (this.technicianForm.valid) {
      const newTechnician: Technician = this.technicianForm.value;
      this.formSubmitted.emit(newTechnician);
      this.technicianForm.reset({
        firstName: '',
        lastName: '',
        type: '',
        workPermits: this.fb.array([])
      });
    } else {
      this.technicianForm.markAllAsTouched();
    }
  }
}
