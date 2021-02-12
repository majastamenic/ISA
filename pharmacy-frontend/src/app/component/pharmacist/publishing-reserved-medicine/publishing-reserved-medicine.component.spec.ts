import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingReservedMedicineComponent } from './publishing-reserved-medicine.component';

describe('PublishingReservedMedicineComponent', () => {
  let component: PublishingReservedMedicineComponent;
  let fixture: ComponentFixture<PublishingReservedMedicineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublishingReservedMedicineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublishingReservedMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
