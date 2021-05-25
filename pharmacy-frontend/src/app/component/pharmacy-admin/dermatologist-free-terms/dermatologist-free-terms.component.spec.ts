import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DermatologistFreeTermsComponent } from './dermatologist-free-terms.component';

describe('DermatologistFreeTermsComponent', () => {
  let component: DermatologistFreeTermsComponent;
  let fixture: ComponentFixture<DermatologistFreeTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DermatologistFreeTermsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DermatologistFreeTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
