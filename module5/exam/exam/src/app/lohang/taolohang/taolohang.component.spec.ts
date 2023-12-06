import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaolohangComponent } from './taolohang.component';

describe('TaolohangComponent', () => {
  let component: TaolohangComponent;
  let fixture: ComponentFixture<TaolohangComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaolohangComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaolohangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
