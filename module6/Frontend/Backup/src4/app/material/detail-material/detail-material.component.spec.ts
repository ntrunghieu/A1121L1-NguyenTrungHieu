import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailMaterialComponent } from './detail-material.component';

describe('DetailMaterialComponent', () => {
  let component: DetailMaterialComponent;
  let fixture: ComponentFixture<DetailMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
