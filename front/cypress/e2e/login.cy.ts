/// <reference types="cypress" />

describe('Login spec', () => {
  it('Login successfull', () => {
    cy.visit('/login')

    cy.intercept('POST', '/api/auth/login', {
      body: {
        id: 1,
        username: 'userName',
        firstName: 'firstName',
        lastName: 'lastName',
        admin: true
    },
    })

    cy.intercept(
      {
        method: 'GET',
        url: '/api/session',
      },
      []).as('session')

    cy.get('input[formControlName=email]').type("yoga@studio.com")
    cy.get('input[formControlName=password]').type(`${"test!1234"}`)
    cy.get('button[type=submit]').click()

    cy.url().should('include', '/sessions')
  })

  it('Login unsuccessfull', () => {
    cy.visit('/login')

    cy.intercept('POST', '/api/auth/login', {
      statusCode: 401,
      body: {
        message: 'Invalid credentials'
      },
    })

   cy.intercept(
      {
        method: 'GET',
        url: '/api/session',
      },
      []).as('session')

    cy.get('input[formControlName=email]').type("renedecarts@gmail.com")
    cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)

    cy.url().should('include', '/login')  
  })


  it('should disabled submit button if empty password', () => {
    cy.visit('/login');
    cy.get('input[formControlName=password]').clear;
    cy.get('input[formControlName=email]').type(`${"renedecarts@gmail.com"}{enter}{enter}`);
    cy.get('input[formControlName=password]').should('have.class', 'ng-invalid');
    cy.get('.error').should('be.visible');
    cy.get('button[type=submit]').should('be.disabled');
  });

  it('should disabled submit button if empty email', () => {
    cy.visit('/login');
    cy.get('input[formControlName=email]').clear;
    cy.get('input[formControlName=password]').type(`${"wrongpass"}{enter}{enter}`);
    cy.get('input[formControlName=email]').should('have.class', 'ng-invalid');
    cy.get('.error').should('be.visible');
    cy.get('button[type=submit]').should('be.disabled');
  });




});