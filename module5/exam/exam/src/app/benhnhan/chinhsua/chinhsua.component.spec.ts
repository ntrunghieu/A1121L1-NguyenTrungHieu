import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChinhsuaComponent } from './chinhsua.component';

describe('ChinhsuaComponent', () => {
  let component: ChinhsuaComponent;
  let fixture: ComponentFixture<ChinhsuaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChinhsuaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChinhsuaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
