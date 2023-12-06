import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuadetaiComponent } from './suadetai.component';

describe('SuadetaiComponent', () => {
  let component: SuadetaiComponent;
  let fixture: ComponentFixture<SuadetaiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuadetaiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuadetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
