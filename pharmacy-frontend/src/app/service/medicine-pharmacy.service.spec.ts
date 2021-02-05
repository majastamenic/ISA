import { TestBed } from '@angular/core/testing';

import { MedicinePharmacyService } from './medicine-pharmacy.service';

describe('MedicinePharmacyService', () => {
  let service: MedicinePharmacyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicinePharmacyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
