import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { TeacherService } from './teacher.service';
import { HttpTestingController } from '@angular/common/http/testing';

describe('TeacherService', () => {
  let service: TeacherService;
  let httpTesting:HttpTestingController
  const path = 'api/user';


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientModule],
      providers: [TeacherService]
    });
    service = TestBed.inject(TeacherService);
    httpTesting = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get All Teacher', () => {

 const mockUser = {
  id:,
  email: 'johndoe@gmail.com',
  lastName: 'John',
  firstName: 'Doe',
  admin: true,
  createdAt: new Date(),
  updatedAt: new Date(),
};

});
