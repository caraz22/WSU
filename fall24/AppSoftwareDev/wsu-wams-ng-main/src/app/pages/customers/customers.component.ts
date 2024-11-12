import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { Customer } from '../../models/customer.model';
import { CustomerService } from '../../services/customer.service';
import {CustomerFilterComponent} from "./customer-filter/customer-filter.component";
import {DialogModule} from "primeng/dialog";
import {CustomerFormComponent} from "./customer-form/customer-form.component";
import {CustomTableComponent} from "../../shared/custom-table/custom-table.component";
import {ButtonDirective} from "primeng/button";
import {SortOrder} from "../../enums/woms-enums";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss'],
  imports: [
    CustomerFilterComponent,
    DialogModule,
    CustomerFormComponent,
    CustomTableComponent,
    ButtonDirective
  ],
  standalone: true
})
export class CustomersComponent implements OnInit {
  showModal: boolean = false;
  customers: Customer[] = [];
  filteredCustomers: Customer[] = [];
  customerColumns: any[] = [];
  sortField: string = '';
  sortDirection: SortOrder.Ascending | SortOrder.Descending = SortOrder.Ascending;

  customerNames: any[] = [];
  cityOptions: any[] = [];
  stateOptions: any[] = [];

  @ViewChild('customerNameTemplate', { static: true })
  customerNameTemplate!: TemplateRef<any>;

  @ViewChild('customerAddressTemplate', { static: true })
  customerAddressTemplate!: TemplateRef<any>;

  constructor(private readonly customerService: CustomerService) {}

  ngOnInit(): void {
    this.defineTableColumns();
    this.loadCustomers();
  }

  private defineTableColumns() {
    this.customerColumns = [
      {
        field: 'lastName',
        header: 'Customer',
        template: this.customerNameTemplate,
        sortable: true,
      },
      { field: 'email', header: 'Email', sortable: true },
      {
        field: 'address',
        header: 'Address',
        template: this.customerAddressTemplate,
        sortable: true,
      },
    ];
  }

  private loadCustomers() {
    this.customerService.getCustomers().subscribe((customers) => {
      this.customers = customers;
      this.filteredCustomers = [...this.customers];
      this.prepareFilterOptions();
    });
  }

  private prepareFilterOptions() {
    this.prepareCustomerNames();
  }

  private prepareCustomerNames() {
    this.customerNames = this.customers.map((c) => ({
      fullName: `${c.firstName} ${c.lastName}`,
    }));
  }

  onSubmit(newCustomer: Customer) {
    this.customerService.addCustomer(newCustomer);
    this.loadCustomers();
    this.showModal = false;
  }

  onFilterChanged(filters: any) {
    this.applyFilters(filters);
  }

  private applyFilters(filters: any) {
    const { customerName } = filters;
    this.filteredCustomers = this.customers.filter((customer) => {
      return (this.matchesCustomerName(customer, customerName));
    });

    if (this.sortField) {
      this.sortData(this.sortField);
    }
  }

  private matchesCustomerName(customer: Customer, customerName: any): boolean {
    if (!customerName || !customerName.fullName) return true;
    const customerFullName = `${customer.firstName} ${customer.lastName}`.toLowerCase();
    return customerFullName.includes(customerName.fullName.toLowerCase());
  }

  onClearFilters() {
    this.filteredCustomers = [...this.customers];
    this.sortField = '';
    this.sortDirection = SortOrder.Ascending;
  }

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

  private sortData(field: string) {
    this.filteredCustomers.sort((a, b) => this.compare(a, b, field));
    if (this.sortDirection === SortOrder.Descending) {
      this.filteredCustomers.reverse();
    }
  }

  private compare(a: Customer, b: Customer, field: string): number {
    let valueA: string;
    let valueB: string;

    if (field === 'lastName') {
      valueA = a.lastName.toLowerCase();
      valueB = b.lastName.toLowerCase();
    } else {
      valueA = a[field as keyof Customer]?.toString().toLowerCase() ?? '';
      valueB = b[field as keyof Customer]?.toString().toLowerCase() ?? '';
    }

    return valueA.localeCompare(valueB);
  }
}
