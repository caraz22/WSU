import { Component, EventEmitter, Input, Output } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {AutoCompleteModule} from "primeng/autocomplete";
import {ButtonDirective} from "primeng/button";

@Component({
  selector: 'app-customer-filter',
  templateUrl: './customer-filter.component.html',
  styleUrls: ['./customer-filter.component.scss'],
  imports: [
    ReactiveFormsModule,
    AutoCompleteModule,
    ButtonDirective
  ],
  standalone: true
})
export class CustomerFilterComponent {
  @Input() customerNames: any[] = [];

  @Output() filterChanged = new EventEmitter<any>();
  @Output() clearFilters = new EventEmitter<void>();

  filterForm: FormGroup;
  filteredCustomerNames: any[] = [];

  constructor(private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      customerName: [''],
    });

    this.filterForm.valueChanges.subscribe(() => {
      this.filterChanged.emit(this.filterForm.value);
    });
  }

  filterCustomerNames(event: any) {
    const query = event.query.toLowerCase();
    this.filteredCustomerNames = this.customerNames.filter((customer) =>
      customer.fullName.toLowerCase().includes(query)
    );
  }

  onClearFilters() {
    this.filterForm.reset({
      customerName: null,
    });
    this.clearFilters.emit();
  }
}
