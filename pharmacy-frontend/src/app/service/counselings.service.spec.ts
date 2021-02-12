import { TestBed } from '@angular/core/testing';

import { AllCounselingsService } from './counselings.service';

describe('AllCounselingsService', () => {
  let service: AllCounselingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllCounselingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
