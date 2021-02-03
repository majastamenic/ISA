import { TestBed } from '@angular/core/testing';

import { ScheduleCounselingService } from './schedule-counseling.service';

describe('ScheduleCounselingService', () => {
  let service: ScheduleCounselingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleCounselingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
