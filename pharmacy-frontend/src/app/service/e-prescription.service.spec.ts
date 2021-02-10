import { TestBed } from '@angular/core/testing';

import { EPrescriptionService } from './e-prescription.service';

describe('EPrescriptionService', () => {
  let service: EPrescriptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EPrescriptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
