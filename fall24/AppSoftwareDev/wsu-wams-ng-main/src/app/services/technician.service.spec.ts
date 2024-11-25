import { TestBed } from '@angular/core/testing';
import { TechnicianService } from './technician.service';
import { Technician } from '../models/technician.model';

describe('TechnicianService', () => {
  let service: TechnicianService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TechnicianService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all technicians', (done) => {
    service.getTechnicians().subscribe(technicians => {
      expect(technicians.length).toBe(2);
      done();
    });
  });

  it('should find a technician by name', () => {
    const firstName = 'Jane';
    const lastName = 'Smith';
    const technician = service.getTechnicianByName(firstName, lastName);
    expect(technician).toBeTruthy();
    expect(technician?.firstName).toBe(firstName);
    expect(technician?.lastName).toBe(lastName);
  });

  it('should add a new technician', (done) => {
    const newTechnician: Technician = {
      code: 'ALJOHNSON',
      firstName: 'Alice',
      lastName: 'Johnson',
      type: 'Plumbing',
      workPermits: [{ code: 'CA' }],
    };
    service.addTechnician(newTechnician);
    service.getTechnicians().subscribe(technicians => {
      expect(technicians.length).toBe(3);
      expect(technicians).toContain(newTechnician);
      done();
    });
  });

  it('should update an existing technician', () => {
    const updatedTechnician: Technician = {
      code: 'JASMITH',
      firstName: 'Jane',
      lastName: 'Smith',
      type: 'Electrical',
      workPermits: [{ code: 'CA' }],
    };
    service.updateTechnician('Jane', 'Smith', updatedTechnician);
    const technician = service.getTechnicianByName('Jane', 'Smith');
    expect(technician).toBeTruthy();
    expect(technician?.type).toBe('Electrical');
  });
});
