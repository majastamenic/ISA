import { TestBed } from '@angular/core/testing';

import { ActionsBenefitsService } from './actions-benefits.service';

describe('ActionsBenefitsService', () => {
  let service: ActionsBenefitsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActionsBenefitsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
