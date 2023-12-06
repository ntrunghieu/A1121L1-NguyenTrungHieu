import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellExportComponent } from './sell-export.component';

describe('SellExportComponent', () => {
  let component: SellExportComponent;
  let fixture: ComponentFixture<SellExportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellExportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellExportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
