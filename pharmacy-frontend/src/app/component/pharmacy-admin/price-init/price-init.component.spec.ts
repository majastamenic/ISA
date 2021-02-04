import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceInitComponent } from './price-init.component';

describe('PriceInitComponent', () => {
  let component: PriceInitComponent;
  let fixture: ComponentFixture<PriceInitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriceInitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PriceInitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
