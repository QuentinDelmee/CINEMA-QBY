import { TestBed } from '@angular/core/testing';

import { SecurityLevelService } from './security-level.service';

describe('SecurityLevelService', () => {
  let service: SecurityLevelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecurityLevelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
