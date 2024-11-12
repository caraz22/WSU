import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToastMessageComponent } from './toast-message.component';
import { HttpWrapperService } from '../http-wrapper.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

describe('ToastMessageComponent', () => {
  let component: ToastMessageComponent;
  let fixture: ComponentFixture<ToastMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [HttpWrapperService, HttpClient],
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ToastMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
