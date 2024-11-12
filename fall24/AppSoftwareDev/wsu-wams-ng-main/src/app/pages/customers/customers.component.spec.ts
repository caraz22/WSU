import {ComponentFixture, TestBed} from '@angular/core/testing';
import {CustomersComponent} from './customers.component';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../models/customer.model';
import {DialogModule} from 'primeng/dialog';
import {CustomerFilterComponent} from './customer-filter/customer-filter.component';
import {CustomerFormComponent} from './customer-form/customer-form.component';
import {CustomTableComponent} from '../../shared/custom-table/custom-table.component';
import {ButtonDirective} from 'primeng/button';
import {SortOrder} from "../../enums/woms-enums";
import { of } from 'rxjs';

class MockCustomerService {
  private customers: Customer[] = [
    {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      phone: '5551234567',
      email: 'john.doe@example.com',
      addressLine1: '123 Main St',
      city: 'Anytown',
      state: 'CA',
      zip: '12345',
    },
    {
      id: 2,
      firstName: 'Jane',
      lastName: 'Smith',
      phone: '5559876543',
      email: 'jane.smith@example.com',
      addressLine1: '456 Elm St',
      city: 'Othertown',
      state: 'NY',
      zip: '67890',
    },
  ];

  getCustomers() {
    return of([...this.customers]);
  }

  addCustomer(customer: Customer): void {
    this.customers.push(customer);
  }
}

describe('CustomersComponent', () => {
  let component: CustomersComponent;
  let fixture: ComponentFixture<CustomersComponent>;
  let customerService: CustomerService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        CustomersComponent,
        CustomerFilterComponent,
        DialogModule,
        CustomerFormComponent,
        CustomTableComponent,
        ButtonDirective,
      ],
      providers: [
        { provide: CustomerService, useClass: MockCustomerService },
      ],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomersComponent);
    component = fixture.componentInstance;
    customerService = TestBed.inject(CustomerService);
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize customers and filteredCustomers on ngOnInit', () => {
    expect(component.customers.length).toBe(2);
    expect(component.filteredCustomers.length).toBe(2);
  });

  it('should define table columns', () => {
    expect(component.customerColumns.length).toBe(3);
    expect(component.customerColumns[0].field).toBe('lastName');
    expect(component.customerColumns[1].field).toBe('email');
    expect(component.customerColumns[2].field).toBe('address');
  });

  it('should load customers from the service', () => {
    spyOn(customerService, 'getCustomers').and.callThrough();

    component['loadCustomers']();

    expect(customerService.getCustomers).toHaveBeenCalled();
    expect(component.customers.length).toBe(2);
    expect(component.filteredCustomers.length).toBe(2);
  });

  it('should prepare filter options', () => {
    component['prepareFilterOptions']();

    expect(component.customerNames.length).toBe(2);

    const expectedNames = [
      { fullName: 'John Doe' },
      { fullName: 'Jane Smith' },
    ];
    expect(component.customerNames).toEqual(expectedNames);
  });

  it('should add a new customer on submit', () => {
    const newCustomer: Customer = {
      id: 3,
      firstName: 'Alice',
      lastName: 'Wonderland',
      phone: '5550001111',
      email: 'alice@example.com',
      addressLine1: '789 Maple St',
      city: 'Fictional',
      state: 'WA',
      zip: '54321',
    };

    spyOn(customerService, 'addCustomer').and.callThrough();

    component.onSubmit(newCustomer);

    expect(customerService.addCustomer).toHaveBeenCalledWith(newCustomer);
    expect(component.customers.length).toBe(3);
    expect(component.filteredCustomers.length).toBe(3);
    expect(component.showModal).toBeFalse();
  });

  it('should filter customers by name', () => {
    const filters = {
      customerName: { fullName: 'John Doe' },
    };

    component.onFilterChanged(filters);

    expect(component.filteredCustomers.length).toBe(1);
    expect(component.filteredCustomers[0].firstName).toBe('John');
  });

  it('should match customer by name', () => {
    const customer: Customer = {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      phone: '5551234567',
      email: 'john.doe@example.com',
      addressLine1: '123 Main St',
      city: 'Anytown',
      state: 'CA',
      zip: '12345',
    };

    const customerName = { fullName: 'John Doe' };

    const result = (component as any).matchesCustomerName(customer, customerName);
    expect(result).toBeTrue();
  });

  it('should not match customer if name does not match', () => {
    const customer: Customer = {
      id: 2,
      firstName: 'Jane',
      lastName: 'Smith',
      phone: '5559876543',
      email: 'jane.smith@example.com',
      addressLine1: '456 Elm St',
      city: 'Othertown',
      state: 'NY',
      zip: '67890',
    };

    const customerName = { fullName: 'John Doe' };

    const result = (component as any).matchesCustomerName(customer, customerName);
    expect(result).toBeFalse();
  });

  it('should clear filters and reset filteredCustomers', () => {
    component.filteredCustomers = [];

    component.onClearFilters();

    expect(component.filteredCustomers.length).toBe(2);
    expect(component.sortField).toBe('');
    expect(component.sortDirection).toBe('asc');
  });

  it('should toggle sort direction', () => {
    component.sortField = 'email';
    component.sortDirection = SortOrder.Ascending;

    component['toggleSortDirection']('email');

    expect(component.sortDirection).toBe('desc');

    component['toggleSortDirection']('email');

    expect(component.sortDirection).toBe('asc');

    component['toggleSortDirection']('firstName');

    expect(component.sortField).toBe('firstName');
    expect(component.sortDirection).toBe('asc');
  });

  it('should sort data by lastName in ascending order', () => {
    component.sortField = 'lastName';
    component.sortDirection = SortOrder.Ascending;

    component['sortData']('lastName');

    expect(component.filteredCustomers[0].lastName).toBe('Doe');
    expect(component.filteredCustomers[1].lastName).toBe('Smith');
  });

  it('should sort data by lastName in descending order', () => {
    component.sortField = 'lastName';
    component.sortDirection = SortOrder.Descending;

    component['sortData']('lastName');

    expect(component.filteredCustomers[0].lastName).toBe('Smith');
    expect(component.filteredCustomers[1].lastName).toBe('Doe');
  });

  it('should compare customers by lastName', () => {
    const customerA = component.customers[0];
    const customerB = component.customers[1];

    const result = component['compare'](customerA, customerB, 'lastName');

    expect(result).toBeLessThan(0);
  });

  it('should compare customers by address', () => {
    const customerA = component.customers[0];
    const customerB = component.customers[1];

    const result = component['compare'](customerA, customerB, 'address');

    expect(result).toBe(0);
  });

  it('should compare customers by email', () => {
    const customerA = component.customers[0];
    const customerB = component.customers[1];

    const result = component['compare'](customerA, customerB, 'email');

    expect(result).toBeGreaterThan(0);
  });
});
