import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaosanphamComponent } from './taosanpham.component';

describe('TaosanphamComponent', () => {
  let component: TaosanphamComponent;
  let fixture: ComponentFixture<TaosanphamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaosanphamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaosanphamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
