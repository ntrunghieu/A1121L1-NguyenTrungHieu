import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceCreateComponent } from './service-create.component';

describe('ServiceCreateComponent', () => {
  let component: ServiceCreateComponent;
  let fixture: ComponentFixture<ServiceCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
