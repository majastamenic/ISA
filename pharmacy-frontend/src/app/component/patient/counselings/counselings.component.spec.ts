import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CounselingsComponent } from './counselings.component';

describe('CounselingsComponent', () => {
  let component: CounselingsComponent;
  let fixture: ComponentFixture<CounselingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CounselingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CounselingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
