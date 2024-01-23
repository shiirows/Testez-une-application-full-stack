import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { UserService } from './user.service';

describe('UserService', () => {
  let service: UserService;
  let httpTestingController :HttpClientModule

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientModule ],
      providers: [UserService]
    });
    service = TestBed.inject(UserService);
    httpTestingController = TestBed.inject(HttpClientModule);
  });


  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it('should get user by ID', () => {
 const userId = '1'
 const mockUser = {id:userId, name: 'John Doe'};

expect(service.getById(userId).subscribe(user => {
  expect(user).toEqual(mockUser);
  }))
})

it('should get user is not found', ()  => {
  const userId = '10'
  
  expect(service.getById(userId).subscribe(user => {

    expect(user).toBe(404);
   
  }))
})

});
