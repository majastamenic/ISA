import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacistInitComponent } from './pharmacist-init.component';

describe('PharmacistInitComponent', () => {
  let component: PharmacistInitComponent;
  let fixture: ComponentFixture<PharmacistInitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PharmacistInitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacistInitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
