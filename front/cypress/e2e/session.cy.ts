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



      cy.intercept('GET', '/api/session/1', {
        body: {
            "id": 1,
            "name": "Yoga",
            "date": "2024-01-22T10:00:00.000+00:00",
            "teacher_id": 1,
            "description": "Cours de yoga",
            "users": [],
            "createdAt": "2024-01-16T11:12:11",
            "updatedAt": "2024-01-17T11:12:11"
          }
      }).as('sessionWithId1');


      cy.intercept('GET', '/api/teacher/1', {
        body: {
          id: 1,
          lastName: "DECARTS",
          firstName: "Rene",
          "createdAt": "2024-01-16T11:12:11",
          "updatedAt": "2024-01-17T11:12:11"
        }
      }).as('teacher1');
    });
  
    it('show details if admin', () => {
      //Given
      cy.visit('/sessions');
      cy.get('@login');
      cy.get('@session');
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
      }
    );
  
    it('show Edit and Delete in Detail page if you are the owner', () => {
      cy.visit('/sessions');
      cy.get('@login');
      cy.get('input[formControlName=email]').type("renedecarts@gmail.com")
      cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)
      cy.get('@session');
      cy.contains('Detail').click();
      cy.wait('@teacher1');
      cy.get('button[color="warn"]').should('contain', 'Delete');
      cy.get('div[class="description"]').should('contain', 'Cours de yoga');
    });
  });