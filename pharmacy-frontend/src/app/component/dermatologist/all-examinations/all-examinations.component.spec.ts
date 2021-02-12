import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllExaminationsComponent } from './all-examinations.component';

describe('AllExaminationsComponent', () => {
  let component: AllExaminationsComponent;
  let fixture: ComponentFixture<AllExaminationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllExaminationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllExaminationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
