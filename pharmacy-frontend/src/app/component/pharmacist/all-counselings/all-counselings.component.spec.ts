import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCounselingsComponent } from './all-counselings.component';

describe('AllCounselingsComponent', () => {
  let component: AllCounselingsComponent;
  let fixture: ComponentFixture<AllCounselingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllCounselingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllCounselingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
