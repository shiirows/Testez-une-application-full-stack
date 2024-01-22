describe('Login spec', () => {
  beforeEach(() => {
    cy.intercept('POST', '/api/auth/login', {
      body: {
        id: 1,
        username: 'userName',
        firstName: 'firstName',
        lastName: 'lastName',
        admin: true
      },
    }).as('login');


    cy.intercept('GET', '/api/session', {
      body: [
        {
          "id": 1,
          "name": "Yoga",
          "date": "2024-01-22T10:00:00.000+00:00",
          "teacher_id": 1,
          "description": "Cours de yoga",
          "users": [],
          "createdAt": "2024-01-16T11:12:11",
          "updatedAt": "2024-01-17T11:12:11"
        },
        {
          "id": 2,
          "name": "Yoga 2",
          "date": "2024-01-22T10:00:00.000+00:00",
          "teacher_id": 2,
          "description": "Cours de yoga 2",
          "users": [],
          "createdAt": "2024-01-16T11:12:11",
          "updatedAt": "2024-01-17T11:12:11"
        },
      ]
    }).as('session');


  });


  it('show details if admin', () => {
      //Given
      cy.visit('/sessions/detail/1')

      cy.get('input[formControlName=email]').type("renedecarts@gmail.com")
      cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)

      cy.get('@session');

      //When
      cy.url().should('include', '/sessions')
      //Then
      cy.get('button[routerLink="create"]').should('contain', 'Create')
      cy.get('div[class="ng-star-inserted"]').should('contain', 'Logout')
      cy.get('span[class="mat-button-wrapper"]').should('contain', 'Detail')
      cy.get('span[class="mat-button-wrapper"]').should('contain', 'Edit')
      cy.get('span[routerLink="sessions"]').should('contain', 'Sessions')
      cy.get('span[routerLink="me"]').should('contain', 'Account')
    });

    it('delete session successful', () => {
      cy.url().should('include', '/sessions');
  
      cy.intercept('GET', '/api/session/1', {
        body: {
          id: 1,
          name: 'Workout',
          description: 'A workout session',
          date: '2023-12-30T00:00:00.000+00:00',
          teacher_id: 1,
          users: []
        }
      },);
  
      cy.intercept('GET', '/api/teacher', {
        body: [
          {
            id: 1,
            firstName: 'Margot',
            lastName: 'DELAHAYE',
          }
        ]
      },);

      cy.intercept('DELETE', '/api/session/1', {statusCode: 200}).as('updateSession');


      cy.contains('button', 'Detail').click();
      cy.contains('button', 'Delete').click();

      cy.intercept('GET', '/api/session', {
        body: [
          {
            "id": 1,
            "name": "Yoga",
            "date": "2024-01-22T10:00:00.000+00:00",
            "teacher_id": 1,
            "description": "Cours de yoga",
            "users": [],
            "createdAt": "2024-01-16T11:12:11",
            "updatedAt": "2024-01-17T11:12:11"
          }
        ]
      });
  
  
    

      });

});