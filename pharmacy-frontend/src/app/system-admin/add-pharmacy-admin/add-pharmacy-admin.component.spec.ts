import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPharmacyAdminComponent } from './add-pharmacy-admin.component';

describe('AddPharmacyAdminComponent', () => {
  let component: AddPharmacyAdminComponent;
  let fixture: ComponentFixture<AddPharmacyAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPharmacyAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPharmacyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
