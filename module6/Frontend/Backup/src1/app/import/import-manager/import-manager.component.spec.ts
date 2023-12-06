import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportManagerComponent } from './import-manager.component';

describe('ImportManagerComponent', () => {
  let component: ImportManagerComponent;
  let fixture: ComponentFixture<ImportManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
