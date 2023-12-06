import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterialStatisticComponent } from './material-statistic.component';

describe('MaterialStatisticComponent', () => {
  let component: MaterialStatisticComponent;
  let fixture: ComponentFixture<MaterialStatisticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaterialStatisticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaterialStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
