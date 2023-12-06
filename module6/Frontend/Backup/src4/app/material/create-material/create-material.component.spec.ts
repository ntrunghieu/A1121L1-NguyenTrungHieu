import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMaterialComponent } from './create-material.component';

describe('CreateMaterialComponent', () => {
  let component: CreateMaterialComponent;
  let fixture: ComponentFixture<CreateMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
