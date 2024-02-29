import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { SessionApiService } from './session-api.service';
import { Session } from '../interfaces/session.interface';

describe('SessionsService', () => {
  let service: SessionApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpClientModule
      ]
    });
    service = TestBed.inject(SessionApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all sessions', () => {
    expect(service.all()).toBeTruthy();
  });

  it('should get session by id', () => {
    expect(service.detail("1")).toBeTruthy();
  });

  it('should create session', () => {
// mock session 
    const session: Session = {
      name: "test",
      description : "session de test",
      users: [0],
      teacher_id: 2
    } as any as Session;

    expect(service.create(session)).toBeTruthy();
  });

  it('should update session', () => {
    const session: Session = {
      id: 1,
      users: [0],
      teacher_id: 2
    } as any as Session;

    expect(service.update("1", session)).toBeTruthy();
  });

  it('should delete session', () => {
    expect(service.delete("1")).toBeTruthy();
  });

  it('should participate to session', () => {
    expect(service.participate("1", "1")).toBeTruthy();
  });

  it('should unparticipate to session', () => {
    expect(service.unParticipate("1", "1")).toBeTruthy();
  });

});
