import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { UserService } from './user.service';

describe('UserService', () => {
  let service: UserService;
  let httpTesting:HttpTestingController
  const path = 'api/user';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientTestingModule ],
      providers: [UserService]
    });
    service = TestBed.inject(UserService);
    httpTesting = TestBed.inject(HttpTestingController);
  });


  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get user by ID', () => {
 const userId = '1'
 const mockUser = {
  id:userId,
  email: 'johndoe@gmail.com',
  lastName: 'John',
  firstName: 'Doe',
  admin: true,
  createdAt: new Date(),
  updatedAt: new Date(),
};

expect(service.getById(userId).subscribe(user => {
  expect(user).toEqual(mockUser);
  }))

  const req = httpTesting.expectOne(`${path}/${userId}`);
  expect(req.request.method).toEqual('GET');
  req.flush(mockUser)

})

it('should get user is not found', ()  => {
  const userId = '10'
  expect(service.getById(userId).subscribe(user => {
    expect(user).toBe(404);
  }))
  const req = httpTesting.expectOne(`${path}/${userId}`);
  expect(req.request.method).toEqual('GET');
  req.flush('user is not found');

})

it('should delete user by id', () => {
  const userId = '1'

  expect(service.delete(userId).subscribe(res => {
    expect(res).toBeNull()
  }))

  const req = httpTesting.expectOne(`${path}/${userId}`);
  expect(req.request.method).toEqual('DELETE');
  req.flush(null);

})

});
