import { TestBed } from '@angular/core/testing';

import { StatisticServiceService } from './statistic-service.service';

describe('StatisticServiceService', () => {
  let service: StatisticServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatisticServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
