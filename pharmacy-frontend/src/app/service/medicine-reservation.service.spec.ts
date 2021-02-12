import { TestBed } from '@angular/core/testing';

import { MedicineReservationService } from './medicine-reservation.service';

describe('MedicineReservationService', () => {
  let service: MedicineReservationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicineReservationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
