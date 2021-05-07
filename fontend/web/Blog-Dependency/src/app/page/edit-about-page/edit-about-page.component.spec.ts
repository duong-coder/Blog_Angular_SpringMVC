import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAboutPageComponent } from './edit-about-page.component';

describe('EditAboutPageComponent', () => {
  let component: EditAboutPageComponent;
  let fixture: ComponentFixture<EditAboutPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditAboutPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAboutPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
