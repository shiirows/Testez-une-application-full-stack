/// <reference types="cypress" />

describe('Register spec', () => {
    it('Register successfull', () => {
      cy.visit('/register');
  
      cy.intercept('POST', '/api/auth/register', {
        body: {
            "message": "User created successfully"
        },
      });
  
      cy.intercept(
        {
          method: 'GET',
          url: '/api/session',
        },
        []).as('session')

        cy.get('input[formControlName=firstName]').type('firstName');
        cy.get('input[formControlName=lastName]').type('userName');
        cy.get('input[formControlName=email]').type("yoga@studio.com")
        cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)
        cy.get('button[type="submit"]').click({force: true});
  
        cy.url().should('include', '/login')  
      
        });

        
        it('Register unsuccessfull User already exists', () => {
            cy.visit('/register');
        
            cy.intercept('POST', '/api/auth/register', {
              body: {
                    "message": "User already exists"
                },
            });

            cy.intercept(
                {
                  method: 'GET',
                  url: '/api/session',
                },
                []).as('session')
        
                cy.get('input[formControlName=firstName]').type('firstName');
                cy.get('input[formControlName=lastName]').type('userName');
                cy.get('input[formControlName=email]').type("renedecarts@gmail.com");
                cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`);
                cy.get('button[type="submit"]').click({force: true});

                cy.url().should('include', '/login')  

                });

                it('Register unsuccessfull Email already exists', () => {
                    cy.visit('/register');
                
                    cy.intercept('POST', '/api/auth/register', {
                      body: {
                            "message": "Email already exists"
                        },

                      });

                      cy.intercept(
                        {
                          method: 'GET',
                          url: '/api/session',
                        },
                        []).as('session')
                
                        cy.get('input[formControlName=firstName]').type('firstName');
                        cy.get('input[formControlName=lastName]').type('userName');
                        cy.get('input[formControlName=email]').type("renedecarts@gmail.com");
                        cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`);
                        cy.get('button[type="submit"]').click({force: true});

                        cy.url().should('include', '/login')  

                        });


                        



      });