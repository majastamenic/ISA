import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionsBenefitsComponent } from './actions-benefits.component';

describe('ActionsBenefitsComponent', () => {
  let component: ActionsBenefitsComponent;
  let fixture: ComponentFixture<ActionsBenefitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActionsBenefitsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionsBenefitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
