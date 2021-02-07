import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegSystemAdminComponent } from './reg-system-admin.component';

describe('RegSystemAdminComponent', () => {
  let component: RegSystemAdminComponent;
  let fixture: ComponentFixture<RegSystemAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegSystemAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegSystemAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
