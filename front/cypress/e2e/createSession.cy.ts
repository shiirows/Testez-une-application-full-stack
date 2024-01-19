/// <reference types="cypress" />

describe('Session with admin credential', () => {
    it('should login as admin', () => {
      cy.visit('/login');
  
      cy.intercept('POST', '/api/auth/login', {
        body: {
          id: 1,
          username: 'yoga@studio.com',
          firstName: 'firstName',
          lastName: 'lastName',
          admin: true
        },
      });
  
      cy.intercept('GET','/api/session',[]).as('session');
  
      cy.get('input[formControlName=email]').type("yoga@studio.com");
      cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`);
  
      cy.url().should('include', '/sessions');
  
    })
  
    it('should create a session', () => {
  
      cy.url().should('include', '/sessions');
  
      cy.intercept('GET', '/api/teacher', {body: [{ id: 1, firstName: 'René', lastName: 'Descartes'}]});
  
      cy.intercept('POST', '/api/session', {
        body: {
          id: 1,
          name: 'mea culpa',
          description: 'New session for philosopher',
          date: '2023-05-15T00:00:00.000+00:00',
          teacher_id: 1,
        },
     });
  
     cy.intercept('GET', '/api/session', {
        body: [{
          id: 1,
          name: 'mea culpa',
          description: 'New session for philosopher',
          date: '2024-05-15T00:00:00.000+00:00',
          teacher_id: 1,
          users: []
        }]
      });
  
  
      cy.url().should('include', '/sessions');
      cy.get('button[routerLink=create]').click();
      cy.get('input[formControlName=name]').type("mea culpa");
      cy.get('input[formControlName=date]').type("2023-05-15");
      cy.get('mat-select[formControlName=teacher_id]').click().get('mat-option').contains('René Descartes').click();
      cy.get('textarea[formControlName=description]').type("New session for philosopher");
      cy.get('button[type=submit]').click()
      cy.url().should('include', '/sessions');
    })




  })