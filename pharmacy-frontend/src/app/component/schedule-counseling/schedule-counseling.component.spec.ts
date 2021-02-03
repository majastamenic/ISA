import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleCounselingComponent } from './schedule-counseling.component';

describe('ScheduleCounselingComponent', () => {
  let component: ScheduleCounselingComponent;
  let fixture: ComponentFixture<ScheduleCounselingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleCounselingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleCounselingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
