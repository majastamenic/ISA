import { TestBed } from '@angular/core/testing';

import { UploadQrService } from './upload-qr.service';

describe('UploadQRService', () => {
  let service: UploadQrService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UploadQrService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
