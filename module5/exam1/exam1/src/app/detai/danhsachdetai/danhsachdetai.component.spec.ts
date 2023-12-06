import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DanhsachdetaiComponent } from './danhsachdetai.component';

describe('DanhsachdetaiComponent', () => {
  let component: DanhsachdetaiComponent;
  let fixture: ComponentFixture<DanhsachdetaiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DanhsachdetaiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DanhsachdetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
