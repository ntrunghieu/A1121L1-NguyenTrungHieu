import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCustomerComponent } from './detail-customer.component';

describe('DetailCustomerComponent', () => {
  let component: DetailCustomerComponent;
  let fixture: ComponentFixture<DetailCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
