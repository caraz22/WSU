import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TechnicianFormComponent } from './technician-form.component';

describe('TechnicianFormComponent', () => {
  let component: TechnicianFormComponent;
  let fixture: ComponentFixture<TechnicianFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TechnicianFormComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnicianFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should have an invalid form when empty', () => {
    expect(component.technicianForm.valid).toBeFalse();
  });

  function testControlRequiredAndPattern(
    controlName: string,
    validValue: string,
    invalidValue: string,
    patternErrorKey = 'pattern'
  ) {
    it(`should validate ${controlName} as required and pattern`, () => {
      const control = component.technicianForm.get(controlName);
      expect(control?.valid).toBeFalsy();

      if (control) {
        // Test required validation
        expect(control?.hasError('required')).toBeTrue();

        // Set invalid value
        control?.setValue(invalidValue);
        expect(control?.hasError(patternErrorKey)).toBeTrue();

        // Set valid value
        control?.setValue(validValue);
        expect(control?.valid).toBeTrue();
      }
    });
  }

  testControlRequiredAndPattern('firstName', 'John', '123');
  testControlRequiredAndPattern('lastName', 'Doe', '456');
  testControlRequiredAndPattern('state', 'NY', 'New York');
  testControlRequiredAndPattern('workPermitState', 'CA', 'California');

  it('should validate zip as required and pattern', () => {
    const control = component.technicianForm.get('zip');
    expect(control?.valid).toBeFalsy();

    if (control) {
      // Test required validation
      expect(control?.hasError('required')).toBeTrue();

      // Set invalid value
      control?.setValue('1234');
      expect(control?.hasError('pattern')).toBeTrue();

      // Set valid values
      control?.setValue('12345');
      expect(control?.valid).toBeTrue();

      control?.setValue('12345-6789');
      expect(control?.valid).toBeTrue();
    }
  });

  it('should validate address as required', () => {
    const control = component.technicianForm.get('address');
    expect(control).toBeFalsy(); // Ensure the control is defined

    if (control) {
      expect(control.valid).toBeFalse();

      // Test required validation
      expect(control.hasError('required')).toBeTrue();

      // Set valid value
      control.setValue('123 Main St');
      expect(control.valid).toBeTrue();
    }
  });

  it('should validate city as required', () => {
    const control = component.technicianForm.get('city');
    expect(control?.valid).toBeFalsy();

    if (control) {
      // Test required validation
      expect(control.hasError('required')).toBeTrue();

      // Set valid value
      control?.setValue('Anytown');
      expect(control?.valid).toBeTrue();
    }
  });

  it('should validate workPermitType as required', () => {
    const control = component.technicianForm.get('workPermitType');
    expect(control?.valid).toBeFalsy();

    if (control) {
      // Test required validation
      expect(control?.hasError('required')).toBeTrue();

      // Set valid value
      control?.setValue('Electrical');
      expect(control?.valid).toBeTrue();
    }
  });


  it('should return true if control is invalid and touched', () => {
    const controlName = 'firstName';
    const control = component.technicianForm.get(controlName);
    control?.setValue('');
    control?.markAsTouched();

    expect(component.isControlInvalid(controlName)).toBeTrue();
  });

  it('should return false if control is valid', () => {
    const controlName = 'firstName';
    const control = component.technicianForm.get(controlName);
    control?.setValue('John');
    control?.markAsTouched();

    expect(component.isControlInvalid(controlName)).toBeFalse();
  });

  it('should return false if control is not touched', () => {
    const controlName = 'firstName';
    const control = component.technicianForm.get(controlName);
    control?.setValue('');

    expect(component.isControlInvalid(controlName)).toBeFalse();
  });

  it('should add a work permit', () => {
    component.addWorkPermit('CA');
    expect(component.workPermits.length).toBe(1);
    expect(component.workPermits.at(0).value).toEqual({ code: 'CA' });
  });

  it('should remove a work permit', () => {
    component.addWorkPermit('CA');
    component.removeWorkPermit(0);
    expect(component.workPermits.length).toBe(0);
  });

  it('should update work permits on state change', () => {
    component.onStateChange(['CA', 'NY']);
    expect(component.workPermits.length).toBe(2);
    expect(component.workPermits.at(0).value).toEqual({ code: 'CA' });
    expect(component.workPermits.at(1).value).toEqual({ code: 'NY' });
  });

  it('should submit the form when valid', () => {
    spyOn(component.formSubmitted, 'emit');
    component.technicianForm.setValue({
      firstName: 'John',
      lastName: 'Doe',
      type: 'Electrical',
      workPermits: []
    });
    component.onSubmit();
    expect(component.formSubmitted.emit).toHaveBeenCalled();
  });

  it('should not submit the form when invalid', () => {
    spyOn(component.formSubmitted, 'emit');
    component.technicianForm.setValue({
      firstName: '',
      lastName: '',
      type: '',
      workPermits: []
    });
    component.onSubmit();
    expect(component.formSubmitted.emit).not.toHaveBeenCalled();
  });
});
