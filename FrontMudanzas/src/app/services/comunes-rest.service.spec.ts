import { TestBed, inject } from '@angular/core/testing';

import { ComunesRestService } from './comunes-rest.service';

describe('ComunesRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComunesRestService]
    });
  });

  it('should be created', inject([ComunesRestService], (service: ComunesRestService) => {
    expect(service).toBeTruthy();
  }));
});
