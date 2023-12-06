import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMaterialComponent } from './edit-material.component';

describe('EditMaterialComponent', () => {
  let component: EditMaterialComponent;
  let fixture: ComponentFixture<EditMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
