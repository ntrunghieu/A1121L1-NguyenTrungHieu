import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerStatisticComponent } from './customer-statistic.component';

describe('CustomerStatisticComponent', () => {
  let component: CustomerStatisticComponent;
  let fixture: ComponentFixture<CustomerStatisticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerStatisticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
