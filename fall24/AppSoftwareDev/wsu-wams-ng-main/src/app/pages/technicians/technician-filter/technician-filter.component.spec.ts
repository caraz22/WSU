import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { MultiSelectModule } from 'primeng/multiselect';
import { ButtonDirective } from 'primeng/button';
import { TechnicianFilterComponent } from './technician-filter.component';

describe('TechnicianFilterComponent', () => {
  let component: TechnicianFilterComponent;
  let fixture: ComponentFixture<TechnicianFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule,
        AutoCompleteModule,
        MultiSelectModule,
        ButtonDirective,
        TechnicianFilterComponent
      ],
      providers: [FormBuilder]
    }).compileComponents();

    fixture = TestBed.createComponent(TechnicianFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize form with default values', () => {
    const formValues = component.filterForm.value;
    expect(formValues.technicianName).toBe('');
    expect(formValues.permitTypes).toEqual([]);
    expect(formValues.permitStates).toEqual([]);
  });

  it('should assign input properties correctly', () => {
    const technicianNames = [{ fullName: 'John Doe' }];
    const permitTypeOptions = [{ label: 'Type A', value: 'A' }];
    const permitStateOptions = [{ label: 'State X', value: 'X' }];

    component.technicianNames = technicianNames;
    component.permitTypeOptions = permitTypeOptions;
    component.permitStateOptions = permitStateOptions;

    fixture.detectChanges();

    expect(component.technicianNames).toEqual(technicianNames);
    expect(component.permitTypeOptions).toEqual(permitTypeOptions);
    expect(component.permitStateOptions).toEqual(permitStateOptions);
  });

  it('should filter technician names correctly', () => {
    component.technicianNames = [
      { fullName: 'John Doe' },
      { fullName: 'Jane Smith' }
    ];

    component.filterTechnicianNames({ query: 'John' });
    expect(component.filteredTechnicianNames).toEqual([{ fullName: 'John Doe' }]);

    component.filterTechnicianNames({ query: 'Jane' });
    expect(component.filteredTechnicianNames).toEqual([{ fullName: 'Jane Smith' }]);
  });

  it('should emit filterChanged event on form value changes', () => {
    spyOn(component.filterChanged, 'emit');

    component.filterForm.patchValue({
      technicianName: 'John Doe',
      permitTypes: ['A'],
      permitStates: ['X']
    });

    expect(component.filterChanged.emit).toHaveBeenCalledWith({
      technicianName: 'John Doe',
      permitTypes: ['A'],
      permitStates: ['X']
    });
  });

  it('should reset form and emit clearFilters event on clear filters', () => {
    spyOn(component.clearFilters, 'emit');

    component.onClearFilters();

    expect(component.filterForm.value).toEqual({
      technicianName: null,
      permitTypes: [],
      permitStates: []
    });
    expect(component.clearFilters.emit).toHaveBeenCalled();
  });
});
