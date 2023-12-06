import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaomoiComponent } from './taomoi.component';

describe('TaomoiComponent', () => {
  let component: TaomoiComponent;
  let fixture: ComponentFixture<TaomoiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaomoiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaomoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
