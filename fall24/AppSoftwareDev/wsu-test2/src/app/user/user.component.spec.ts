import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserComponent } from './user.component';
import { User } from '../../models/user.model';

class MockUserService {
  private User = [
    {
      id: '1',
      name: 'John Doe',
      email: 'john@doe.gov'
    },
    {
      id: '2',
      name: 'Jane Doe',
      email: 'jane@doe.gov'
    }
  ]
}

describe('UserComponent', () => {
  let component: UserComponent;
  let fixture: ComponentFixture<UserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('users initialized correctly', () => {
    expect(component.users.length == 2).toBeTruthy();
  });

  it('correct user setup', () => {
    expect(component.users.length == 3).toBeFalsy();
    expect(component.users.includes({
      id: 5,
      name: 'John Secret',
      email: 'madeup@aol.net'
    })).toBeFalsy();
  });
});
