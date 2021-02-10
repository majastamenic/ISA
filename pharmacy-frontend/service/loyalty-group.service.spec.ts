import { TestBed } from '@angular/core/testing';

import { LoyaltyGroupService } from './loyalty-group.service';

describe('LoyaltyGroupService', () => {
  let service: LoyaltyGroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoyaltyGroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
