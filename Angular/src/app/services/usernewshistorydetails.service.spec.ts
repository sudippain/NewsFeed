import { TestBed } from '@angular/core/testing';

import { UsernewshistorydetailsService } from './usernewshistorydetails.service';

describe('UsernewshistorydetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsernewshistorydetailsService = TestBed.get(UsernewshistorydetailsService);
    expect(service).toBeTruthy();
  });
});
