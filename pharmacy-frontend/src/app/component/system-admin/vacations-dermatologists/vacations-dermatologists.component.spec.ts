import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VacationsDermatologistsComponent } from './vacations-dermatologists.component';

describe('VacationsDermatologistsComponent', () => {
  let component: VacationsDermatologistsComponent;
  let fixture: ComponentFixture<VacationsDermatologistsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VacationsDermatologistsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VacationsDermatologistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
