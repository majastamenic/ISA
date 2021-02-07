import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegDermatologistComponent } from './reg-dermatologist.component';

describe('RegDermatologistComponent', () => {
  let component: RegDermatologistComponent;
  let fixture: ComponentFixture<RegDermatologistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegDermatologistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegDermatologistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
