import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingBarComponentComponent } from './rating-bar-component.component';

describe('RatingBarComponentComponent', () => {
  let component: RatingBarComponentComponent;
  let fixture: ComponentFixture<RatingBarComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RatingBarComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingBarComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
