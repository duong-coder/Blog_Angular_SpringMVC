import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileTimelineEditComponent } from './profile-timeline-edit.component';

describe('ProfileTimelineEditComponent', () => {
  let component: ProfileTimelineEditComponent;
  let fixture: ComponentFixture<ProfileTimelineEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileTimelineEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileTimelineEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
