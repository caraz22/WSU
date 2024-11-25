import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {WorkOrderDetailService} from '../../services/work-order-detail.service';
import {WorkOrderDetail} from '../../models/work-order-detail.model';
import {CurrencyPipe, NgForOf, NgIf} from '@angular/common';
import {CustomTableComponent} from '../../shared/custom-table/custom-table.component';
import {SortOrder} from "../../enums/woms-enums";
import {WorkOrderSummary} from 'src/app/models/work-order-summary.model';
import {OrderFilterComponent} from "./order-filter/order-filter.component";
import { DialogModule } from 'primeng/dialog';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    CustomTableComponent,
    OrderFilterComponent,
    DialogModule,
    CurrencyPipe
  ],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.scss'
})
export class OrdersComponent implements OnInit {

  customerNames: any[] = [];
  filteredOrderSummaries: WorkOrderSummary[] = [];
  orderDetails: WorkOrderDetail[] = []; // array to hold work order details
  orderSummaries: WorkOrderSummary[] = []; // array to hhold work order summaries
  orderColumns: any[] = []; // columns to format shared custom table
  sortDirection: SortOrder.Ascending | SortOrder.Descending = SortOrder.Ascending;
  sortField: string = '';
  technicianNames: any[] = [];
  workOrderNumbers: any[] = [];
  workOrderStatuses: any[] = [];

  @ViewChild('customerNameTemplate', { static: true })
  customerNameTemplate!: TemplateRef<any>;
  @ViewChild('technicianNameTemplate', { static: true })
  technicianNameTemplate!: TemplateRef<any>;
  @ViewChild('dateScheduledTemplate', { static: true })
  dateScheduledTemplate!: TemplateRef<any>;
  @ViewChild('dateLastUpdatedTemplate', { static: true })
  dateLastUpdatedTemplate!: TemplateRef<any>;
  @ViewChild('workOrderNumberTemplate', { static: true })
  workOrderNumberTemplate!: TemplateRef<any>;

  selectedWorkOrder: WorkOrderDetail[] | null = null;
  showWorkOrderModal: boolean = false;
  workOrderDetailColumns: any[] = [];

  constructor(private _workOrderService: WorkOrderDetailService) {
  }

  ngOnInit() {
    this.defineTableColumns();
    this.defineWorkOrderDetailColumns();
    this.loadOrderSummaries();
    this.loadOrderDetails();
  }

  // Define columns for the table
  private defineTableColumns() {
    this.orderColumns = [
      {
        field: 'customerLastName',
        header: 'Customer',
        template: this.customerNameTemplate,
        sortable: true,
      },
      { field: 'workOrderNumber',
        header: 'Work Order Number',
        template: this.workOrderNumberTemplate,
        sortable: true },
      {
        field: 'technicianLastName',
        header: 'Technician',
        template: this.technicianNameTemplate,
        sortable: true
      },
      { field: 'dateScheduled',
        header: 'Date Scheduled',
        template: this.dateScheduledTemplate,
        sortable: true },
      { field: 'dateLastUpdated',
        header: 'Date Last Updated',
        template: this.dateLastUpdatedTemplate,
        sortable: true
      },
      { field: 'workOrderStatus', header: 'Status', sortable: true }
    ];
  }

  private loadOrderSummaries(): void {
    // TODO: change between getWorkOrderSummariesViaHttp and getWorkOrderSummaries for backend and hardcoded values
    this._workOrderService.getWorkOrderSummariesViaHttp().subscribe((summaries: WorkOrderSummary[]) => {
      this.orderSummaries = summaries;
      this.filteredOrderSummaries = [...this.orderSummaries];
      this.prepareFilterOptions();
    })
  }

  private loadOrderDetails(): void {
    this._workOrderService.getWorkOrderDetails().subscribe((details: WorkOrderDetail[]) => {
      this.orderDetails = details;
    })
  }

  formatDate(date: string | Date): string {
    const d = new Date(date);
    const month = String(d.getMonth() + 1).padStart(2, '0'); // Months are zero-based
    const day = String(d.getDate()).padStart(2, '0');
    const year = d.getFullYear();
    return `${month}/${day}/${year}`;
  }

  private prepareFilterOptions() {
    this.prepareTechnicianNames();
    this.prepareCustomerNames();
    this.prepareWorkOrderNumbers();
    this.prepareWorkOrderStatuses();
  }

  private prepareTechnicianNames() {
    this.technicianNames = this.orderSummaries.map((summary) => ({
      fullName: `${summary.technicianFirstName} ${summary.technicianLastName}`,
    }));
  }

  private prepareCustomerNames() {
    this.customerNames = this.orderSummaries.map((summary) => ({
      fullName: `${summary.customerFirstName} ${summary.customerLastName}`,
    }));
  }

  private prepareWorkOrderNumbers() {
    this.workOrderNumbers = [...new Set(this.orderSummaries.map(summary => summary.workOrderNumber))];
  }

  private prepareWorkOrderStatuses() {
    this.workOrderStatuses = [...new Set(this.orderSummaries.map(summary => summary.workOrderStatus))];
  }

  // Handle filter changes
  onFilterChanged(filters: any) {
    this.applyFilters(filters);
  }

  // Apply filters to the order summaries
  private applyFilters(filters: any) {
    const { customerName, workOrderNumber, technicianName, dateScheduled, dateLastUpdated, workOrderStatus } = filters;

    this.filteredOrderSummaries = this.orderSummaries.filter((summary) => {
      return (
        this.matchesCustomerName(summary, customerName) &&
        this.matchesWorkOrderNumber(summary, workOrderNumber) &&
        this.matchesTechnicianName(summary, technicianName) &&
        this.matchesDateScheduled(summary, dateScheduled) &&
        this.matchesDateLastUpdated(summary, dateLastUpdated) &&
        this.matchesWorkOrderStatus(summary, workOrderStatus)
      );
    });

    // Apply sorting after filtering
    if (this.sortField) {
      this.sortData(this.sortField);
    }
  }

  private matchesCustomerName(summary: WorkOrderSummary, customerName: any): boolean {
    if (!customerName || !customerName.fullName) return true;
    const customerFullName = `${summary.customerFirstName} ${summary.customerLastName}`.toLowerCase();
    return customerFullName.includes(customerName.fullName.toLowerCase());
  }

  private matchesWorkOrderNumber(summary: WorkOrderSummary, workOrderNumber: string): boolean {
    if (!workOrderNumber) return true;
    return summary.workOrderNumber.toString().includes(workOrderNumber);
  }

  private matchesTechnicianName(summary: WorkOrderSummary, technicianName: any): boolean {
    if (!technicianName || !technicianName.fullName) return true;
    const fullName = `${summary.technicianFirstName} ${summary.technicianLastName}`.toLowerCase();
    return fullName.includes(technicianName.fullName.toLowerCase());
  }

  private matchesDateScheduled(summary: WorkOrderSummary, dateScheduled: string): boolean {
    if (!dateScheduled) return true;
    return this.formatDate(summary.dateScheduled) === this.formatDate(dateScheduled);
  }

  private matchesDateLastUpdated(summary: WorkOrderSummary, dateLastUpdated: string): boolean {
    if (!dateLastUpdated) return true;
    return this.formatDate(summary.dateLastUpdated) === this.formatDate(dateLastUpdated);
  }

  private matchesWorkOrderStatus(summary: WorkOrderSummary, workOrderStatus: string): boolean {
    if (!workOrderStatus) return true;
    return summary.workOrderStatus.toLowerCase() === workOrderStatus.toLowerCase();
  }

  // Handle clearing of filters
  onClearFilters() {
    this.filteredOrderSummaries = [...this.orderSummaries];
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
    this.filteredOrderSummaries.sort((a, b) => this.compare(a, b, field));
    if (this.sortDirection === SortOrder.Descending) {
      this.filteredOrderSummaries.reverse();
    }
  }

  // Comparison function for sorting
  private compare(a: WorkOrderSummary, b: WorkOrderSummary, field: string): number {
    let valueA: string;
    let valueB: string;

    if (field === 'customerLastName') {
      valueA = a.customerLastName.toLowerCase();
      valueB = b.customerLastName.toLowerCase();
    } else if (field === 'workOrderNumber') {
      valueA = a.workOrderNumber.toString();
      valueB = b.workOrderNumber.toString();
    } else if (field === 'dateScheduled') {
      valueA = this.formatDate(a.dateScheduled);
      valueB = this.formatDate(b.dateScheduled);
    } else if (field === 'dateLastUpdated') {
      valueA = this.formatDate(a.dateLastUpdated);
      valueB = this.formatDate(b.dateLastUpdated);
    } else {
      valueA = a[field as keyof WorkOrderSummary]?.toString().toLowerCase() ?? '';
      valueB = b[field as keyof WorkOrderSummary]?.toString().toLowerCase() ?? '';
    }

    return valueA.localeCompare(valueB);
  }

  closeWorkOrderModal() {
    this.showWorkOrderModal = false;
    this.selectedWorkOrder = null;
  }

  onWorkOrderNumberClick(workOrderNumber: number) {
    this._workOrderService.getWorkOrderDetailsByNumber(workOrderNumber).subscribe({
      next: (details: WorkOrderDetail[]) => {
        this.selectedWorkOrder = details;
        this.showWorkOrderModal = true;
      },
      error: (error) => {
        console.error('Error fetching work order details:', error);
        // Handle error (e.g., show an error message to the user)
      }
    });
  }

  private defineWorkOrderDetailColumns() {
    this.workOrderDetailColumns = [
      { field: 'WorkOrderNumber', header: 'Work Order Number', sortable: true },
      { field: 'SKUCode', header: 'SKU Code', sortable: true },
      { field: 'Quantity', header: 'Quantity', sortable: true },
      { field: 'UnitCost', header: 'Unit Cost', sortable: true },
      { field: 'Taxable', header: 'Taxable', sortable: true },
      { field: 'Tax', header: 'Tax', sortable: true },
    ];
  }
}
