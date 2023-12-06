import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SualohangComponent } from './sualohang.component';

describe('SualohangComponent', () => {
  let component: SualohangComponent;
  let fixture: ComponentFixture<SualohangComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SualohangComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SualohangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
