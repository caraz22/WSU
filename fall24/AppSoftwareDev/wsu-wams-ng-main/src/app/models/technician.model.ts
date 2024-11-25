export interface WorkPermit {
  code: string;
}

export interface Technician {
  code: string;
  firstName: string;
  lastName: string;
  type: string;
  workPermits?: WorkPermit[];
}
