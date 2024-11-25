import { Component, EventEmitter, Input, OnInit, Output, ViewEncapsulation } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {AutoCompleteModule} from "primeng/autocomplete";
import {MultiSelectModule} from "primeng/multiselect";
import {ButtonDirective} from "primeng/button";

@Component({
  selector: 'app-technician-filter',
  templateUrl: './technician-filter.component.html',
  styleUrls: ['./technician-filter.component.scss'],
  imports: [
    AutoCompleteModule,
    ReactiveFormsModule,
    MultiSelectModule,
    ButtonDirective
  ],
  standalone: true,
  encapsulation: ViewEncapsulation.None
})
export class TechnicianFilterComponent implements OnInit {
  @Input() technicianNames: any[] = [];
  @Input() permitTypeOptions: any[] = [];
  @Input() permitStateOptions: any[] = [];

  @Output() filterChanged = new EventEmitter<any>();
  @Output() clearFilters = new EventEmitter<void>();

  filterForm: FormGroup;
  filteredTechnicianNames: any[] = [];

  constructor(private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      technicianName: [''],
      permitTypes: [[]],
      permitStates: [[]],
    });
  }

  ngOnInit(): void {
    this.filterForm.valueChanges.subscribe(() => {
      this.filterChanged.emit(this.filterForm.value);
    });
  }

  filterTechnicianNames(event: any) {
    const query = event.query.toLowerCase();
    this.filteredTechnicianNames = this.technicianNames.filter((technician) =>
      technician.fullName.toLowerCase().includes(query)
    );
  }

  onClearFilters() {
    this.filterForm.reset({
      technicianName: null,
      permitTypes: [],
      permitStates: [],
    });
    this.clearFilters.emit();
  }
}
