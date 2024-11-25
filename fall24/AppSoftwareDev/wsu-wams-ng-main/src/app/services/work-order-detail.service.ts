import { Injectable } from '@angular/core';
import { WorkOrderDetail } from '../models/work-order-detail.model';
import {map, Observable, of} from "rxjs";
import {WorkOrderSummary} from "../models/work-order-summary.model";
import { HttpWrapperService } from '../shared/http-wrapper.service';

@Injectable({
  providedIn: 'root',
})
export class WorkOrderDetailService {
  private workOrderDetails: WorkOrderDetail[] = [
    // Sample data
    {
      WorkOrderNumber: 147875,
      SKUCode: '123456789012',
      Quantity: 5,
      UnitCost: 10.00,
      Taxable: true,
      Tax: 5.00,
    },
    {
      WorkOrderNumber: 147875,
      SKUCode: '123456789013',
      Quantity: 1,
      UnitCost: 100.00,
      Taxable: true,
      Tax: 10.00,
    },
    {
      WorkOrderNumber: 147875,
      SKUCode: '123456789014',
      Quantity: 10,
      UnitCost: 20.00,
      Taxable: true,
      Tax: 20.00,
    },
    {
      WorkOrderNumber: 147874,
      SKUCode: '123456789012',
      Quantity: 5,
      UnitCost: 10.00,
      Taxable: true,
      Tax: 5.00,
    },

  ];

  private workOrderSummary: WorkOrderSummary[] = [
    // Sample data
    {
      workOrderNumber: 147875,
      customerLastName: "Madarang",
      customerFirstName: "Kimbery",
      technicianLastName: "Delasancha",
      technicianFirstName: "Mona",
      technicianCode: "T10482",
      dateScheduled: "2024-09-03T04:00:00.000+00:00",
      dateLastUpdated: "2024-09-03T16:00:00.000+00:00",
      workOrderStatus: "Scheduled"
    },
    {
      workOrderNumber: 147874,
      customerLastName: "Wenner",
      customerFirstName: "Tonette",
      technicianLastName: "Skywalker",
      technicianFirstName: "Luke",
      technicianCode: "T10482",
      dateScheduled: "2024-09-06T04:00:00.000+00:00",
      dateLastUpdated: "2024-09-05T16:00:00.000+00:00",
      workOrderStatus: "Unscheduled"
    },
  ]

  private readonly baseUrl = 'http://localhost:8080/work-order-pro-service';

  constructor(private readonly http: HttpWrapperService) {}

  getWorkOrderSummariesViaHttp(): Observable<WorkOrderSummary[]> {
    return this.http.doGet(`${this.baseUrl}/workOrderSummaries`, {}).pipe(
     map((response) => {
       return response.data;
     })
    );
  }

  getWorkOrderSummaries(): Observable<WorkOrderSummary[]> {
    return of(this.workOrderSummary);
  }

  getWorkOrderDetailsViaHttp(): Observable<WorkOrderDetail[]> {
    return this.http.doGet(`${this.baseUrl}/workOrderDetails`, {}).pipe(
      map((response) => response.data)
    );
  }

  getWorkOrderDetails(): Observable<WorkOrderDetail[]> {
    return of(this.workOrderDetails);
  }

  getWorkOrderDetailsByNumberViaHttp(workOrderNumber: number): Observable<WorkOrderDetail[]> {
    return this.http.doGet(`${this.baseUrl}/workOrderDetails/${workOrderNumber}`, {}).pipe(
      map((response) => response.data)
    );
  }

  getWorkOrderDetailsByNumber(workOrderNumber: number): Observable<WorkOrderDetail[]> {
    return of(this.workOrderDetails.filter((wo) => wo.WorkOrderNumber === workOrderNumber));
  }

  addWorkOrderDetail(workOrderDetail: WorkOrderDetail): void {
    this.workOrderDetails.push(workOrderDetail);
  }

  updateWorkOrderDetailViaHttp(workOrderNumber: number, updatedDetail: WorkOrderDetail): Observable<WorkOrderDetail> {
    return this.http.doPut(`${this.baseUrl}/workOrderDetails/${workOrderNumber}`, updatedDetail).pipe(
      map((response) => response.data)
    );
  }

  updateWorkOrderDetail(workOrderNumber: number, updatedDetail: WorkOrderDetail): void {
    const index = this.workOrderDetails.findIndex((wo) => wo.WorkOrderNumber === workOrderNumber);
    if (index !== -1) {
      this.workOrderDetails[index] = updatedDetail;
    }
  }

  deleteWorkOrderDetail(workOrderNumber: number): Observable<void> {
    const url = `${this.baseUrl}/workOrderDetails/${workOrderNumber}`;
    return this.http.doDelete(url);
  }
}
