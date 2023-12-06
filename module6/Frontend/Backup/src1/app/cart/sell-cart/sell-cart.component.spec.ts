import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellCartComponent } from './sell-cart.component';

describe('SellCartComponent', () => {
  let component: SellCartComponent;
  let fixture: ComponentFixture<SellCartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellCartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
