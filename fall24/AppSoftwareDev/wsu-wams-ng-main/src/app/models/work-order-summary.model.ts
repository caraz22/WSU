export interface WorkOrderSummary {
  workOrderNumber: number;
  customerFirstName: string;
  customerLastName: string;
  technicianFirstName: string;
  technicianLastName: string;
  technicianCode: string;
  dateScheduled: string | Date;
  dateLastUpdated: string | Date;
  workOrderStatus: string;
}
