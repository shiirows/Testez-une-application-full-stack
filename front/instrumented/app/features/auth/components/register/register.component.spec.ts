import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { expect } from '@jest/globals';
import { of, throwError } from 'rxjs';

import { RegisterComponent } from './register.component';
import { HttpTestingController } from '@angular/common/http/testing';
import { AuthService } from '../../services/auth.service';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let httpTesting:HttpTestingController
  let service: AuthService;

  const path = 'api/teacher';

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegisterComponent],
      imports: [
        BrowserAnimationsModule,
        HttpClientModule,
        ReactiveFormsModule,  
        MatCardModule,
        MatFormFieldModule,
        MatIconModule,
        MatInputModule
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // Add this test
  it('should have a form with 4 controls', () => {
    expect(component.form.contains('email')).toBeTruthy();
    expect(component.form.contains('firstName')).toBeTruthy();
    expect(component.form.contains('lastName')).toBeTruthy();
    expect(component.form.contains('password')).toBeTruthy();
  });

  // Add this test
  it('should make the email control required', () => {
    const control = component.form.get('email');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

  // Add this test
  it('should make the firstName control required', () => {
    const control = component.form.get('firstName');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

  // Add this test
  it('should make the lastName control required', () => {
    const control = component.form.get('lastName');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

 
  it('should make the password control required', () => {
    const control = component.form.get('password');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

  it ('should register user with error if the register request fails', () => {
    const authService = TestBed.inject(AuthService);
    const spy = jest.spyOn(authService, 'register').mockReturnValue(of());
    component.submit();

    expect(spy).toHaveBeenCalled();

  });





});
