import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaodetaiComponent } from './taodetai.component';

describe('TaodetaiComponent', () => {
  let component: TaodetaiComponent;
  let fixture: ComponentFixture<TaodetaiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaodetaiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaodetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
