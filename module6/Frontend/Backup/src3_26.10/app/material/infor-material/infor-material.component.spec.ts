import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InforMaterialComponent } from './infor-material.component';

describe('InforMaterialComponent', () => {
  let component: InforMaterialComponent;
  let fixture: ComponentFixture<InforMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InforMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InforMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
