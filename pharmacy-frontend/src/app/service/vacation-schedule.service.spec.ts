import { TestBed } from '@angular/core/testing';

import { VacationScheduleService } from './vacation-schedule.service';

describe('VacationScheduleService', () => {
  let service: VacationScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VacationScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
