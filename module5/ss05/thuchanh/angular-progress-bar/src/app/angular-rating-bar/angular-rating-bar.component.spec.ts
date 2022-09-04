import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularRatingBarComponent } from './angular-rating-bar.component';

describe('AngularRatingBarComponent', () => {
  let component: AngularRatingBarComponent;
  let fixture: ComponentFixture<AngularRatingBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularRatingBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularRatingBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
