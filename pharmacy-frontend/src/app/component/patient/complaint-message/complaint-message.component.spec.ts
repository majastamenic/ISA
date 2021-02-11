import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplaintMessageComponent } from './complaint-message.component';

describe('ComplaintMessageComponent', () => {
  let component: ComplaintMessageComponent;
  let fixture: ComponentFixture<ComplaintMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplaintMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplaintMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
