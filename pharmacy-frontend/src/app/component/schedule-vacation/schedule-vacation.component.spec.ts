import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleVacationComponent } from './schedule-vacation.component';

describe('ScheduleVacationComponent', () => {
  let component: ScheduleVacationComponent;
  let fixture: ComponentFixture<ScheduleVacationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleVacationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleVacationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
