import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleExaminationDermatologistComponent } from './schedule-examination-dermatologist.component';

describe('ScheduleExaminationDermatologistComponent', () => {
  let component: ScheduleExaminationDermatologistComponent;
  let fixture: ComponentFixture<ScheduleExaminationDermatologistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleExaminationDermatologistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleExaminationDermatologistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
