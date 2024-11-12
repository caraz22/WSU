import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ModalComponent } from './modal.component';
import { By } from '@angular/platform-browser';

describe('ModalComponent', () => {
  let component: ModalComponent;
  let fixture: ComponentFixture<ModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render content when show is true', () => {
    component.show = true;
    fixture.detectChanges();
    const modalContent = fixture.debugElement.query(By.css('.modal-content'));
    expect(modalContent).toBeTruthy();
  });

  it('should not render content when show is false', () => {
    component.show = false;
    fixture.detectChanges();
    const modalContent = fixture.debugElement.query(By.css('.modal-content'));
    expect(modalContent).toBeFalsy();
  });

  it('should emit close event when close button is clicked', () => {
    spyOn(component.close, 'emit');
    component.show = true;
    fixture.detectChanges();
    const closeButton = fixture.debugElement.query(By.css('.close-button'));
    closeButton.triggerEventHandler('click', null);
    expect(component.close.emit).toHaveBeenCalled();
  });

  it('should emit close event when escape key is pressed', () => {
    spyOn(component.close, 'emit');
    component.show = true;
    fixture.detectChanges();
    const event = new KeyboardEvent('keydown', { key: 'Escape' });
    document.dispatchEvent(event);
    expect(component.close.emit).toHaveBeenCalled();
  });
});
