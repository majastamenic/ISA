import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExaminationScheduleComponent } from './examination-schedule.component';

describe('ExaminationScheduleComponent', () => {
  let component: ExaminationScheduleComponent;
  let fixture: ComponentFixture<ExaminationScheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExaminationScheduleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExaminationScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
