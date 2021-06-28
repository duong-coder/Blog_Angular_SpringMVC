import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileTimeItemComponent } from './profile-time-item.component';

describe('ProfileTimeItemComponent', () => {
  let component: ProfileTimeItemComponent;
  let fixture: ComponentFixture<ProfileTimeItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileTimeItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileTimeItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
