import { TestBed } from '@angular/core/testing';
import { WorkOrderDetailService } from './work-order-detail.service';
import { WorkOrderDetail } from '../models/work-order-detail.model';
import { WorkOrderSummary } from '../models/work-order-summary.model';
import { of } from 'rxjs';
import {HttpWrapperService} from "../shared/http-wrapper.service";

describe('WorkOrderDetailService', () => {
  let service: WorkOrderDetailService;
  let httpWrapperServiceSpy: jasmine.SpyObj<HttpWrapperService>;

  beforeEach(() => {
    const spy = jasmine.createSpyObj('HttpWrapperService', ['doGet']);

    TestBed.configureTestingModule({
      providers: [
        WorkOrderDetailService,
        { provide: HttpWrapperService, useValue: spy }
      ]
    });

    service = TestBed.inject(WorkOrderDetailService);
    httpWrapperServiceSpy = TestBed.inject(HttpWrapperService) as jasmine.SpyObj<HttpWrapperService>;
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return work order summaries', (done) => {
    const mockSummaries: WorkOrderSummary[] = [
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
      }
    ];

    service.getWorkOrderSummaries().subscribe(summaries => {
      expect(summaries).toEqual(mockSummaries);
      expect(summaries.length).toBe(2);
      done();
    });
  });

  it('should return work order summaries with correct structure', (done) => {
    service.getWorkOrderSummaries().subscribe(summaries => {
      expect(summaries.length).toBeGreaterThan(0);
      summaries.forEach(summary => {
        expect(summary).toEqual(jasmine.objectContaining({
          workOrderNumber: jasmine.any(Number),
          customerLastName: jasmine.any(String),
          customerFirstName: jasmine.any(String),
          technicianLastName: jasmine.any(String),
          technicianFirstName: jasmine.any(String),
          technicianCode: jasmine.any(String),
          dateScheduled: jasmine.any(String),
          dateLastUpdated: jasmine.any(String),
          workOrderStatus: jasmine.any(String)
        }));
      });
      done();
    });
  });

  it('should return work order details', (done) => {
    service.getWorkOrderDetails().subscribe(details => {
      expect(details.length).toBeGreaterThan(0);
      expect(details[0].WorkOrderNumber).toBeDefined();
      done();
    });
  });

  it('should return work order details by number', (done) => {
    const testWorkOrderNumber = 147875;

    service.getWorkOrderDetailsByNumber(testWorkOrderNumber).subscribe(details => {
      expect(details.length).toBeGreaterThan(0);
      expect(details[0].WorkOrderNumber).toBe(testWorkOrderNumber);
      done();
    });
  });

  it('should add a new work order detail', () => {
    const newDetail: WorkOrderDetail = {
      WorkOrderNumber: 147876,
      SKUCode: '987654321098',
      Quantity: 3,
      UnitCost: 15.00,
      Taxable: true,
      Tax: 2.25,
    };

    service.addWorkOrderDetail(newDetail);

    service.getWorkOrderDetails().subscribe(details => {
      expect(details).toContain(newDetail);
    });
  });

  it('should update an existing work order detail', () => {
    const updatedDetail: WorkOrderDetail = {
      WorkOrderNumber: 147875,
      SKUCode: '123456789012',
      Quantity: 7,
      UnitCost: 12.00,
      Taxable: true,
      Tax: 8.40,
    };

    service.updateWorkOrderDetail(147875, updatedDetail);

    service.getWorkOrderDetailsByNumber(147875).subscribe(details => {
      expect(details[0]).toEqual(updatedDetail);
    });
  });

  it('should call the HTTP service for work order summaries', () => {
    const mockSummaries: WorkOrderSummary[] = [
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
      }
    ];

    httpWrapperServiceSpy.doGet.and.returnValue(of(mockSummaries));

    service.getWorkOrderSummariesViaHttp().subscribe(summaries => {
      expect(summaries).toEqual(mockSummaries);
      expect(httpWrapperServiceSpy.doGet).toHaveBeenCalledWith('https://your-base-url-here.com/work-order-summaries', {});
    });
  });
});
