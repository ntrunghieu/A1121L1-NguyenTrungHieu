import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancialStatisticComponent } from './financial-statistic.component';

describe('FinancialStatisticComponent', () => {
  let component: FinancialStatisticComponent;
  let fixture: ComponentFixture<FinancialStatisticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancialStatisticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancialStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
