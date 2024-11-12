import { Injectable } from '@angular/core';
import { Customer } from '../models/customer.model';
import { map, Observable, of } from 'rxjs';
import { HttpWrapperService } from '../shared/http-wrapper.service';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private customers: Customer[] = [
    // Sample data
    {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      phone: '555-789-1234',
      email: 'john.doe@example.com',
      addressLine1: '789 East Ave',
      city: 'Somewhere',
      state: 'MT',
      zip: '12345',
    },
    {
      id: 2,
      firstName: 'Jen',
      lastName: 'Smith',
      phone: '555-123-4567',
      email: 'jen.smith@example.com',
      addressLine1: '123 Main St',
      city: 'Anytown',
      state: 'CA',
      zip: '12345',
    },
  ];

  private readonly baseUrl = 'http://localhost:8080/customer-service';

  constructor(private readonly http: HttpWrapperService) {}

  getCustomers(): Observable<Customer[]> {
    return of(this.customers);
  }

  getCustomerByEmail(email: string): Customer | undefined {
    return this.customers.find((customer) => customer.email === email);
  }

  addCustomer(customer: Customer): void {
    this.customers.push(customer);
  }

  updateCustomer(firstName: string, lastName: string, email: string, updatedCustomer: Customer): void {
    const index = this.customers.findIndex(
      (cust) => cust.firstName === firstName && cust.lastName === lastName && cust.email === email);
    if (index !== -1) {
      this.customers[index] = updatedCustomer;
    }
  }

  getCustomersViaHttp(): Observable<Customer[]> {
    return this.http.doGet(`${this.baseUrl}/customers`, {}).pipe(
      map((response) => response.data)
    );
  }

  getCustomerByIdViaHttp(customerId: number): Observable<Customer> {
    return this.http.doGet(`${this.baseUrl}/customers/${customerId}`, {}).pipe(
      map((response) => response.data)
    );
  }

  addCustomerViaHttp(customer: Customer): Observable<Customer> {
    return this.http.doPost(`${this.baseUrl}/customers`, customer).pipe(
      map((response) => response.data)
    );
  }

  updateCustomerViaHttp(customerId: number, updatedCustomer: Customer): Observable<Customer> {
    return this.http.doPut(`${this.baseUrl}/customers/${customerId}`, updatedCustomer).pipe(
      map((response) => response.data)
    );
  }

  deleteCustomerViaHttp(customerId: number): Observable<void> {
    return this.http.doDelete(`${this.baseUrl}/customers/${customerId}`);
  }
}
