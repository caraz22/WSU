export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  addressLine1: string;
  addressLine2?: string;
  city: string;
  state: string;
  zip: string;
  phone: string;
  email: string;
  dateAdded?: Date;
  dateLastUpdated?: Date;
  latestWorkOrderStatus?: string;
}
