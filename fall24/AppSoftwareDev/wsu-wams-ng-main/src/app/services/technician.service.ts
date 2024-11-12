import { Injectable } from '@angular/core';
import { Technician } from '../models/technician.model';
import {map, Observable, of} from "rxjs";
import { HttpWrapperService } from '../shared/http-wrapper.service';

@Injectable({
  providedIn: 'root',
})
export class TechnicianService {
  private technicians: Technician[] = [
    // Sample data
    {
      code: 'JASMITH',
      firstName: 'Jane',
      lastName: 'Smith',
      type: 'Plumbing',
      workPermits: [
        { code: 'CA'},
        { code: 'NY'},
        { code: 'OH'},
      ],
    },
    {
      code: 'LEJENKINS',
      firstName: 'Leroy',
      lastName: 'Jenkins',
      type: 'Electrical',
      workPermits: [
        { code: 'OR'},
        { code: 'PA'},
      ],
    },
  ];

  private readonly baseUrl = 'http://localhost:8080/technician-service';

  constructor(private readonly http: HttpWrapperService) {}

  getTechnicians(): Observable<Technician[]> {
    return of(this.technicians);
  }

  getTechnicianByName(firstName: string, lastName: string): Technician | undefined {
    return this.technicians.find(
      (tech) => tech.firstName === firstName && tech.lastName === lastName
    );
  }

  addTechnician(technician: Technician): void {
    this.technicians.push(technician);
  }

  updateTechnician(firstName: string, lastName: string, updatedTechnician: Technician): void {
    const index = this.technicians.findIndex(
      (tech) => tech.firstName === firstName && tech.lastName === lastName
    );
    if (index !== -1) {
      this.technicians[index] = updatedTechnician;
    }
  }

  getTechniciansViaHttp(): Observable<Technician[]> {
    return this.http.doGet(`${this.baseUrl}/technicians`, {}).pipe(
      map((response) => response.data)
    );
  }

  getTechnicianByIdViaHttp(technicianId: number): Observable<Technician> {
    return this.http.doGet(`${this.baseUrl}/technicians/${technicianId}`, {}).pipe(
      map((response) => response.data)
    );
  }

  addTechnicianViaHttp(technician: Technician): Observable<Technician> {
    return this.http.doPost(`${this.baseUrl}/technicians`, technician).pipe(
      map((response) => response.data)
    );
  }

  updateTechnicianViaHttp(technicianId: number, updatedTechnician: Technician): Observable<Technician> {
    return this.http.doPut(`${this.baseUrl}/technicians/${technicianId}`, updatedTechnician).pipe(
      map((response) => response.data)
    );
  }

  deleteTechnicianViaHttp(technicianId: number): Observable<void> {
    return this.http.doDelete(`${this.baseUrl}/technicians/${technicianId}`);
  }
}
