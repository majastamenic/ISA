import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllMedicationsComponent } from './all-medications.component';

describe('AllMedicationsComponent', () => {
  let component: AllMedicationsComponent;
  let fixture: ComponentFixture<AllMedicationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllMedicationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllMedicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
