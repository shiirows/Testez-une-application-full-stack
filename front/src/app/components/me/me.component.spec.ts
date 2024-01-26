import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { of } from 'rxjs';
import { SessionService } from 'src/app/services/session.service';

import { MeComponent } from './me.component';
import { User } from 'src/app/interfaces/user.interface';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { SessionInformation } from '../../interfaces/sessionInformation.interface';


describe('MeComponent', () => {

  const User: User = { id: 1, email: '', lastName: '', firstName: '', admin: true, password: '', createdAt: new Date(), updatedAt: new Date() };
  const SessionInformation: SessionInformation = { token: '', type: '', id: 1, username: '', firstName: '', lastName: '', admin: true };

  let component: MeComponent;
  let fixture: ComponentFixture<MeComponent>;
  let mockRouter: jest.Mocked<any>;
  let sessionService: jest.Mocked<SessionService>;
  let userService: jest.Mocked<UserService>;
  let mockMatSnackBar: jest.Mocked<MatSnackBar>;

  mockRouter = {
     navigate: jest.fn()
  } as unknown as jest.Mocked<Router>

  userService = {
    getById: jest.fn().mockReturnValue(of(User)),
    delete: jest.fn()
  } as unknown as jest.Mocked<UserService>;

  sessionService = {
    sessionInformation: SessionInformation,
    logOut: jest.fn()
  } as unknown as jest.Mocked<SessionService>;

  mockMatSnackBar = {
    open: jest.fn()
  } as unknown as jest.Mocked<MatSnackBar>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({
      declarations: [MeComponent],
      imports: [
        MatSnackBarModule,
        HttpClientModule,
        MatCardModule,
        MatFormFieldModule,
        MatIconModule,
        MatInputModule
      ],
      providers: [
        { provide: SessionService, useValue: sessionService },
        { provide: UserService, useValue: userService },
        { provide: Router, useValue: mockRouter },
        { provide: MatSnackBar, useValue: mockMatSnackBar }
      ],
    })
      .compileComponents();

    fixture = TestBed.createComponent(MeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();

  });

  describe('ngOnInit', () => {
    it('should call UserService.getById and set user', () => {
      component.ngOnInit();
      expect(userService.getById).toHaveBeenCalledWith(SessionInformation.id.toString());
      expect(component.user).toEqual(User);
    });
  });

  // le describe est une fonction qui permet de regrouper des tests qui ont un lien entre eux
  describe('back', () => {
    it('should call windows.history.back()', () => {
      const backSpy = jest.spyOn(window.history, 'back');
      component.back();
      expect(backSpy).toHaveBeenCalledTimes(1);
    });
  });

  describe('delete', () => {



    it('should call userService.delete()', () => {
      // jest.spyOn permet de créer un espion sur une méthode d'un objet (ici userService.delete) et de définir son comportement
      const deleteSpy = jest.spyOn(userService, 'delete').mockImplementation((userId: string) => { return of({})});
      // component.delete() appelle userService.delete()
      component.delete();
      // on vérifie que userService.delete() a bien été appelée avec le bon paramètre
      expect(deleteSpy).toHaveBeenCalledWith(SessionInformation.id.toString());
    });

    it('should call logOut()', () => {
      component.delete();
      expect(sessionService.logOut).toHaveBeenCalled;
    });

    it('should call matSnackBar.open() with correct parameter', () => {
      component.delete();
      expect(mockMatSnackBar.open).toHaveBeenCalledWith("Your account has been deleted !", 'Close', { duration: 3000 });
    });

    it('should navigate to the home page', () => {
      // jest.spyOn permet de créer un espion sur une méthode d'un objet (ici mockRouter.navigate) et de définir son comportement
      const navigateSpy = jest.spyOn(mockRouter, 'navigate');
      component.delete();
      // on vérifie que mockRouter.navigate a bien été appelée avec le bon paramètre
      expect(navigateSpy).toHaveBeenCalledWith(['/']);
    });


  });
});