import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LohanglistComponent } from './lohanglist.component';

describe('LohanglistComponent', () => {
  let component: LohanglistComponent;
  let fixture: ComponentFixture<LohanglistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LohanglistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LohanglistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
