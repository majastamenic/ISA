import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartCounselingComponent } from './start-counseling.component';

describe('StartCounselingComponent', () => {
  let component: StartCounselingComponent;
  let fixture: ComponentFixture<StartCounselingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartCounselingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StartCounselingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
