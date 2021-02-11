import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UploadQRComponent } from './upload-qr.component';

describe('UploadQRComponent', () => {
  let component: UploadQRComponent;
  let fixture: ComponentFixture<UploadQRComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadQRComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadQRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
