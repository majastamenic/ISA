import { TestBed } from '@angular/core/testing';
import { HospitalService } from './hospital.service.service';



describe('Hospital.ServiceService', () => {
  let service: HospitalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HospitalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
