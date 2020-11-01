import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlagAcountComponent } from './flag-acount.component';

describe('FlagAcountComponent', () => {
  let component: FlagAcountComponent;
  let fixture: ComponentFixture<FlagAcountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlagAcountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlagAcountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
