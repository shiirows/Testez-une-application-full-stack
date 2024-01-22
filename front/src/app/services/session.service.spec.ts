import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { SessionService } from './session.service';
import { SessionInformation } from '../interfaces/sessionInformation.interface';
import { Observable } from 'rxjs';

describe('SessionService', () => {
  const mockSessionUser: SessionInformation = { token: '', type: '', id: 1, username: '', firstName: '', lastName: '', admin: true };

  let service: SessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should log in', () => {
    const user = {
      name: 'test',
      email: 'toto@gmail.com',
      password: 'test',
      admin: true
    };

    it('should init  set isLogged to false', () => {
      expect(service.isLogged).toBeFalsy();
    });

    it('should init set sessionInformation to undefined', () => {
      expect(service.sessionInformation).toBeUndefined();
    });
  });

  describe('$isLogged', () => {
    it('should return an Observable for $isLogged()', () => {
      expect(service.$isLogged()).toBeInstanceOf(Observable);
    });
  });

  describe('logIn', () => {
    it('should set sessionInformation and set isLogger to true on logIn', () => {
      service.logIn(mockSessionUser);
      expect(service.isLogged).toBeTruthy();
      expect(service.sessionInformation).toEqual(mockSessionUser);
    });
  });

  describe('logOut', () => {
    it('should set sessionInformation to undefined and set isLogger to false on logOut', () => {
      service.logOut();
      expect(service.isLogged).toBeFalsy();
      expect(service.sessionInformation).toBeUndefined();
    });


});

});