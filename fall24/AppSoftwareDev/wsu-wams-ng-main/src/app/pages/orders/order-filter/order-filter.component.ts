import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {AutoCompleteModule} from "primeng/autocomplete";
import {CalendarModule} from "primeng/calendar";
import {DropdownModule} from "primeng/dropdown";

@Component({
  selector: 'app-order-filter',
  standalone: true,
  templateUrl: './order-filter.component.html',
  imports: [
    ReactiveFormsModule,
    AutoCompleteModule,
    CalendarModule,
    DropdownModule
  ],
  styleUrls: ['./order-filter.component.scss']
})
export class OrderFilterComponent implements OnInit {
  @Input() customerNames: any[] = [];
  @Input() technicianNames: any[] = [];
  @Input() workOrderNumbers: any[] = [];
  @Input() workOrderStatuses: any[] = [];

  @Output() filterChanged = new EventEmitter<any>();
  @Output() clearFilters = new EventEmitter<void>();

  filterForm: FormGroup;
  filteredCustomerNames: any[] = [];
  filteredTechnicianNames: any[] = [];
  filteredWorkOrderNumbers: any[] = [];
  filteredWorkOrderStatuses: any[] = [];

  constructor(private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      customerName: [''],
      workOrderNumber: [''],
      technicianName: [''],
      dateScheduled: [''],
      dateLastUpdated: [''],
      workOrderStatus: ['']
    });

    this.filterForm.valueChanges.subscribe(() => {
      this.filterChanged.emit(this.filterForm.value);
    });
  }

  ngOnInit(): void {
    this.filterForm.valueChanges.subscribe(() => {
      this.filterChanged.emit(this.filterForm.value);
    });
  }

  filterCustomerNames(event: any): void {
    const query = event.query.toLowerCase();
    this.filteredCustomerNames = this.customerNames.filter((customer) =>
      customer.fullName.toLowerCase().includes(query)
    );
  }

  filterTechnicianNames(event: any): void {
    const query = event.query.toLowerCase();
    this.filteredTechnicianNames = this.technicianNames.filter((technician) =>
      technician.fullName.toLowerCase().includes(query)
    );
  }

  filterWorkOrderNumbers(event: any): void {
    const query = event.query.toLowerCase();
    this.filteredWorkOrderNumbers = this.workOrderNumbers.filter((number) =>
      number.toString().includes(query)
    );
  }

  filterWorkOrderStatuses(event: any): void {
    const query = event.query.toLowerCase();
    this.filteredWorkOrderStatuses = this.workOrderStatuses.filter((status) =>
      status.toLowerCase().includes(query)
    );
  }

  onClearFilters() {
    this.filterForm.reset();
    this.clearFilters.emit();
  }
}
