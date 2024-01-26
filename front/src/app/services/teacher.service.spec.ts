import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { TeacherService } from './teacher.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('TeacherService', () => {
  let service: TeacherService;
  let httpTesting:HttpTestingController
  const path = 'api/teacher';


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientTestingModule],
      providers: [TeacherService]
    });
    service = TestBed.inject(TeacherService);
    httpTesting = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get All Teacher', () => {

 const mockTeacher = {
  lastName: 'John',
  firstName: 'Doe',
  createdAt: new Date(),
  updatedAt: new Date(),
};

service.all().subscribe((teachers) => {
  expect(teachers).toEqual([mockTeacher]);
});

const req = httpTesting.expectOne(path);
expect(req.request.method).toBe('GET');
req.flush([mockTeacher]);
  });

  it('should get Teacher by ID', () => {
    const teacherId = '1'
    const mockTeacher = {
      id:teacherId,
      lastName: 'John',
      firstName: 'Doe',
      createdAt: new Date(),
      updatedAt: new Date(),
    };
    expect(service.detail(teacherId).subscribe(teacher => {
      expect(teacher).toEqual(mockTeacher);
    }))
    const req = httpTesting.expectOne(`${path}/${teacherId}`);
    expect(req.request.method).toEqual('GET');
    req.flush(mockTeacher)
  })

  it('should get Teacher is not found', ()  => {
    const teacherId = '10'
    expect(service.detail(teacherId).subscribe(teacher => {
      expect(teacher).toBe(404);
    }))
    const req = httpTesting.expectOne(`${path}/${teacherId}`);
    expect(req.request.method).toEqual('GET');
    req.flush('teacher is not found');

  })

  

});
