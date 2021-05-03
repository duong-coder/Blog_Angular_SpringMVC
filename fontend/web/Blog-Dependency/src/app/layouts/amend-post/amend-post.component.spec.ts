import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmendPostComponent } from './amend-post.component';

describe('AmendPostComponent', () => {
  let component: AmendPostComponent;
  let fixture: ComponentFixture<AmendPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AmendPostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AmendPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
