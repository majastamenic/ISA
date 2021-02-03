import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegSupplierComponent } from './reg-supplier.component';

describe('RegSupplierComponent', () => {
  let component: RegSupplierComponent;
  let fixture: ComponentFixture<RegSupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegSupplierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegSupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
