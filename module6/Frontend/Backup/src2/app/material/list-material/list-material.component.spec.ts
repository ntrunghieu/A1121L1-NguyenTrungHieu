import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMaterialComponent } from './list-material.component';

describe('ListMaterialComponent', () => {
  let component: ListMaterialComponent;
  let fixture: ComponentFixture<ListMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
