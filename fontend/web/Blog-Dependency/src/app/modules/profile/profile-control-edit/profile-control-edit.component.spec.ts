import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileControlEditComponent } from './profile-control-edit.component';

describe('ProfileControlEditComponent', () => {
  let component: ProfileControlEditComponent;
  let fixture: ComponentFixture<ProfileControlEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileControlEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileControlEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
