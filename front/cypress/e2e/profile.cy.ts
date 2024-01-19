describe('profile spec', () => {
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
        cy.get('input[formControlName=password]').type(`${"test!1234"}{enter}{enter}`)
    
        cy.url().should('include', '/sessions')
      })



      it('delete user by id', () => {
        cy.url().should('include', '/sessions');
    
        cy.intercept('GET', '/api/user/1', {
            body: [{
                    id: 1,
                    firstName: 'Decarts',
                    lastName: 'Rene',
                    createdAt: '2024-18-12T00:00:00',
                    updatedAt: '2023-18-19T00:00:00',
                    email: 'renedecartes@gmail.com',
                    admin: true
            }]
        }).as('user');
    
        cy.get('[routerLink=me]').click();
        cy.url().should('include', '/me');
        
        cy.intercept('DELETE', '/api/user/1', {
            status: 200
        });
        cy.contains('delete').click();
    });



});

