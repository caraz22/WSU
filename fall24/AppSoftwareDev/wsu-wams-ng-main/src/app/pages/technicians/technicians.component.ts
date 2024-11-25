import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Technician, WorkPermit} from '../../models/technician.model';
import {TechnicianService} from '../../services/technician.service';
import {DialogModule} from 'primeng/dialog';
import {TechnicianFilterComponent} from './technician-filter/technician-filter.component';
import {TechnicianFormComponent} from './technician-form/technician-form.component';
import {ButtonDirective} from 'primeng/button';
import {CustomTableComponent} from '../../shared/custom-table/custom-table.component';
import {CommonModule} from '@angular/common';
import {SortOrder} from "../../enums/woms-enums";

@Component({
  selector: 'app-technicians',
  templateUrl: './technicians.component.html',
  styleUrls: ['./technicians.component.scss'],
  imports: [
    CommonModule,
    DialogModule,
    TechnicianFilterComponent,
    TechnicianFormComponent,
    ButtonDirective,
    CustomTableComponent,
  ],
  standalone: true,
})
export class TechniciansComponent implements OnInit {
  // Component state variables
  showModal: boolean = false;
  technicians: Technician[] = [];
  filteredTechnicians: Technician[] = [];
  technicianColumns: any[] = [];
  sortField: string = '';
  sortDirection: SortOrder.Ascending | SortOrder.Descending = SortOrder.Ascending;

  // Data for filters
  technicianNames: any[] = [];
  permitTypeOptions: any[] = [];
  permitStateOptions: any[] = [];

  @ViewChild('technicianNameTemplate', { static: true })
  technicianNameTemplate!: TemplateRef<any>;

  @ViewChild('workPermitsTemplate', { static: true })
  workPermitsTemplate!: TemplateRef<any>;

  constructor(private readonly technicianService: TechnicianService) {}

  ngOnInit(): void {
    this.defineTableColumns();
    this.loadTechnicians();
  }

  // Define columns for the table
  private defineTableColumns() {
    this.technicianColumns = [
      {
        field: 'lastName', // Use 'lastName' as the field for sorting
        header: 'Technician',
        template: this.technicianNameTemplate,
        sortable: true,
      },
      { field: 'type', header: 'Permit Type', sortable: true },
      { field: 'workPermits', header: 'Permit State', template: this.workPermitsTemplate, sortable: false },
    ];
  }

  // Load technicians and initialize data
  private loadTechnicians() {
    this.technicianService.getTechnicians().subscribe((technicians) => {
      this.technicians = technicians;
      this.filteredTechnicians = [...this.technicians];
      this.prepareFilterOptions();
    });
  }

  // Prepare data for filters
  private prepareFilterOptions() {
    this.prepareTechnicianNames();
    this.preparePermitTypeOptions();
    this.preparePermitStateOptions();
  }

  private prepareTechnicianNames() {
    this.technicianNames = this.technicians.map((t) => ({
      fullName: `${t.firstName} ${t.lastName}`,
    }));
  }

  private preparePermitTypeOptions() {
    this.permitTypeOptions = Array.from(
      new Set(this.technicians.map((t) => t.type))
    )
      .sort((a, b) => a.localeCompare(b))
      .map((type) => ({ label: type, value: type }));
  }

  private preparePermitStateOptions() {
    const states = this.technicians.flatMap((t) => t.workPermits?.map((wp) => wp.code) || []);
    this.permitStateOptions = Array.from(new Set(states))
      .sort((a, b) => a.localeCompare(b))
      .map((state) => ({ label: state, value: state }));
  }

  formatWorkPermits(workPermits: WorkPermit[] | undefined): string {
    return workPermits ? workPermits.map(wp => wp.code).join(', ') : '';
  }

  // Handle form submission
  onSubmit(newTechnician: Technician) {
    this.technicianService.addTechnician(newTechnician);
    this.loadTechnicians();
    this.showModal = false; // Close the modal
  }

  // Handle filter changes
  onFilterChanged(filters: any) {
    this.applyFilters(filters);
  }

  // Apply filters to the technician list
  private applyFilters(filters: any) {
    const { technicianName, permitTypes, permitStates } = filters;

    this.filteredTechnicians = this.technicians.filter((technician) => {
      return (
        this.matchesName(technician, technicianName) &&
        this.matchesPermitType(technician, permitTypes) &&
        this.matchesPermitState(technician, permitStates)
      );
    });

    // Apply sorting after filtering
    if (this.sortField) {
      this.sortData(this.sortField);
    }
  }

  private matchesName(technician: Technician, technicianName: any): boolean {
    if (!technicianName || !technicianName.fullName) return true;
    const technicianFullName = `${technician.firstName} ${technician.lastName}`.toLowerCase();
    return technicianFullName.includes(technicianName.fullName.toLowerCase());
  }

  private matchesPermitType(technician: Technician, permitTypes: string[]): boolean {
    if (!permitTypes || permitTypes.length === 0) return true;
    return permitTypes.includes(technician.type);
  }

  private matchesPermitState(technician: Technician, permitStates: string[]): boolean {
    if (!permitStates || permitStates.length === 0) return true;
    const technicianStates = technician.workPermits?.map((wp) => wp.code) || [];
    return permitStates.some((state) => technicianStates.includes(state));
  }

  // Handle clearing of filters
  onClearFilters() {
    this.filteredTechnicians = [...this.technicians];
    this.sortField = '';
    this.sortDirection = SortOrder.Ascending;
  }

  // Handle sorting
  onSort(field: string) {
    this.toggleSortDirection(field);
    this.sortData(field);
  }

  private toggleSortDirection(field: string) {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === SortOrder.Ascending ? SortOrder.Descending : SortOrder.Ascending;
    } else {
      this.sortField = field;
      this.sortDirection = SortOrder.Ascending;
    }
  }

  // Sort the data based on field and direction
  private sortData(field: string) {
    this.filteredTechnicians.sort((a, b) => this.compare(a, b, field));
    if (this.sortDirection === SortOrder.Descending) {
      this.filteredTechnicians.reverse();
    }
  }

  // Comparison function for sorting
  private compare(a: Technician, b: Technician, field: string): number {
    let valueA: string;
    let valueB: string;

    if (field === 'lastName') {
      valueA = a.lastName.toLowerCase();
      valueB = b.lastName.toLowerCase();
    } else if (field === 'workPermits') {
      valueA = a.workPermits?.map((wp) => wp.code).join(', ').toLowerCase() || '';
      valueB = b.workPermits?.map((wp) => wp.code).join(', ').toLowerCase() || '';
    } else {
      valueA = a[field as keyof Technician]?.toString().toLowerCase() ?? '';
      valueB = b[field as keyof Technician]?.toString().toLowerCase() ?? '';
    }

    return valueA.localeCompare(valueB);
  }
}
