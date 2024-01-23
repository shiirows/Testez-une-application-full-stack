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

  it('user login', () => {
    const user = {
      name: 'test',
      email: 'toto@gmail.com',
      password: 'test',
      admin: true
    };


});

describe('user is Logged', () => {
  it('should return an Observable for $isLogged()', () => {
    expect(service.$isLogged()).toBeInstanceOf(Observable);
  });
});


it('should init set user login to false', () => {
  expect(service.isLogged).toBeFalsy();
});

it('should init set sessionInformation to undefined', () => {
  expect(service.sessionInformation).toBeUndefined();
});


describe('logIn', () => {
  it('should set sessionInformation and set user Logger to true on logIn', () => {
    service.logIn(mockSessionUser);
    expect(service.isLogged).toBeTruthy();
    expect(service.sessionInformation).toEqual(mockSessionUser);
  });
});

describe('logOut', () => {
  it('should set sessionInformation to undefined and set user Logger to false on logOut', () => {
    service.logOut();
    expect(service.isLogged).toBeFalsy();
    expect(service.sessionInformation).toBeUndefined();
  });


})




});