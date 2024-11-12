import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TechniciansComponent } from './technicians.component';
import { TechnicianService } from '../../services/technician.service';
import { ReactiveFormsModule } from '@angular/forms';

describe('TechniciansComponent', () => {
  let component: TechniciansComponent;
  let fixture: ComponentFixture<TechniciansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReactiveFormsModule],
      providers: [
        {
          provide: TechnicianService,
        },
      ],
    })
      .compileComponents();

    fixture = TestBed.createComponent(TechniciansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
