import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';
import { expect } from '@jest/globals';
import { SessionService } from 'src/app/services/session.service';
import { AuthService } from '../../services/auth.service';

import { LoginComponent } from './login.component';
import { of, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { fakeAsync, tick } from '@angular/core/testing';


describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoginComponent],
      providers: [SessionService],
      imports: [
        RouterTestingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        MatCardModule,
        MatIconModule,
        MatFormFieldModule,
        MatInputModule,
        ReactiveFormsModule]
    })
      .compileComponents();
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ce test permet de vérifier que le formulaire contient 2 champs : email et password 
  it('should initialize form with empty values', () => {
    expect(component.form.value).toEqual({
      email: '',
      password: ''
    });
  });

  // ce test permet de  verifier que le formulaire contient le champ email 
  it('should make the email control required', () => {
    const control = component.form.get('email');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

  // ce test permet de vérifier que le formulaire contient le champ password
  it('should make the password control required', () => {
    const control = component.form.get('password');
    control?.setValue('');
    expect(control?.valid).toBeFalsy();
  });

  // ce test permet de vérifier que le formulaire est valide si les champs sont remplis
  it('should call login method from AuthService', () => {
    const authService = TestBed.inject(AuthService);
    const spy = jest.spyOn(authService, 'login').mockReturnValue(of());
    component.submit();
    expect(spy).toHaveBeenCalled();
  });

/* ce test permet de vérifier que la redirection vers /sessions a lieu si le login réussit
  it('should redirect to /sessions', fakeAsync(() => {
    const router = TestBed.inject(Router);
    const spy = jest.spyOn(router, 'navigate');
    const authService = TestBed.inject(AuthService);
    jest.spyOn(authService, 'login').mockReturnValue(of());
    component.submit();
    tick();
    expect(spy).toHaveBeenLastCalledWith('/sessions');
  }));



  // ce test permet de vérifier que la redirection vers /sessions n'a pas lieu si le login échoue
  it('should not redirect to /sessions if login failed', fakeAsync(() => {
    const router = TestBed.inject(Router);
    const spy = jest.spyOn(router, 'navigate');
    const authService = TestBed.inject(AuthService);
    jest.spyOn(authService, 'login').mockReturnValue(throwError({}));
    component.submit();
    tick();
    expect(spy).not.toHaveBeenCalledWith(['/sessions']);
  })); */

});
