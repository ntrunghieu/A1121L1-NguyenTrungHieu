import { TestBed } from '@angular/core/testing';

import { MaterialServiceService } from './material-service.service';

describe('MaterialServiceService', () => {
  let service: MaterialServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MaterialServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
