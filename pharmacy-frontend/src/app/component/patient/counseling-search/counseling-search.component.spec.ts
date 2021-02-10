import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CounselingSearchComponent } from './counseling-search.component';

describe('CounselingSearchComponent', () => {
  let component: CounselingSearchComponent;
  let fixture: ComponentFixture<CounselingSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CounselingSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CounselingSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
