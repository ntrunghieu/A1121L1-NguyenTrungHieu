import { TestBed } from '@angular/core/testing';

import { ImportServiceService } from './import-service.service';

describe('ImportServiceService', () => {
  let service: ImportServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImportServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
