import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChinhsuasanphamComponent } from './chinhsuasanpham.component';

describe('ChinhsuasanphamComponent', () => {
  let component: ChinhsuasanphamComponent;
  let fixture: ComponentFixture<ChinhsuasanphamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChinhsuasanphamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChinhsuasanphamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
