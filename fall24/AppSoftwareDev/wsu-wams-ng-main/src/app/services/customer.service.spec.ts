import { TestBed } from '@angular/core/testing';
import { CustomerService } from './customer.service';
import { Customer } from '../models/customer.model';

describe('CustomerService', () => {
  let service: CustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all customers', () => {
    service.getCustomers().subscribe(customers => {
      expect(customers.length).toBe(2);
    });
  });

  it('should find a customer by email', () => {
    const email = 'john.doe@example.com';
    const customer = service.getCustomerByEmail(email);
    expect(customer).toBeTruthy();
    expect(customer?.email).toBe(email);
  });

  it('should add a new customer', (done) => {
    const newCustomer: Customer = {
      id: 3,
      firstName: 'Alice',
      lastName: 'Johnson',
      phone: '555-987-6543',
      email: 'alice.johnson@example.com',
      addressLine1: '456 Elm St',
      city: 'Othertown',
      state: 'TX',
      zip: '67890',
    };
    service.addCustomer(newCustomer);
    service.getCustomers().subscribe(customers => {
      expect(customers.length).toBe(3);
      expect(customers).toContain(jasmine.objectContaining(newCustomer));
      done();
    });
  });

  it('should update an existing customer', (done) => {
    const updatedCustomer: Customer = {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      phone: '555-789-1234',
      email: 'john.doe@example.com',
      addressLine1: '456 Elm St',
      city: 'Othertown',
      state: 'TX',
      zip: '67890',
    };
    service.updateCustomer('John', 'Doe', 'john.doe@example.com', updatedCustomer);
    service.getCustomers().subscribe(customers => {
      const customer = customers.find(c => c.email === 'john.doe@example.com');
      expect(customer).toBeTruthy();
      expect(customer?.addressLine1).toBe('456 Elm St');
      done();
    });
  });
});
