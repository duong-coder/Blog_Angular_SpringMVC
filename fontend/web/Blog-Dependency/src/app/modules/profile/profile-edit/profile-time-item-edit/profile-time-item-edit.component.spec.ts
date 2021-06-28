import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileTimeItemEditComponent } from './profile-time-item-edit.component';

describe('ProfileTimeItemEditComponent', () => {
  let component: ProfileTimeItemEditComponent;
  let fixture: ComponentFixture<ProfileTimeItemEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileTimeItemEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileTimeItemEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
