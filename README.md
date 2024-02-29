# Yoga-app

### Database
SQL script for creating the schema `ressources/sql/script.sql`

By default the admin account is:
- login: yoga@studio.com
- password: test!1234
  
## Front

1. Go inside front folder:
   
   ```bash
   cd front

2. Install dependencies:

   ```bash
   npm install

3. Launch Front-end:

   ```bash
   npm run start

### Launch Back

open the project with your preferred IDE

## Ressource
### Postman collection
For Postman import the collection in 'ressources/postman/yoga.postman_collection.json'

## launch tests

### Front

#### Unitaries tests

1. Go inside front folder
   
   ```bash
   cd front

2. Run test
   
   ```bash
   npm run test
    
The report is in "Testez-une-application-full-stack/front/coverage/jest/lcov-report/index.html"
  
#### Tests d'intégration

1. Go inside front folder
   ```bash
   cd front

2. Run test
   
   ```bash
   npm run test int
    
The report is in "Testez-une-application-full-stack/front/coverage/jest/lcov-report/index.html"

### Back
For launch unitaries and integrations tests, the configuration launch this test on maven task, try with

1. Run Maven
   ```bash
   mvn clean install

He will generate a rapport in 'Testez-une-application-full-stack\back\target\jacoco.exec'.

### End to End tests

1. Go in front folder and launch the run command

   ```bash
   cd front

2. Run test End to End

   ```bash
   npm run e2e:ci

For create coverage, this report is in "/Testez-une-application-full-stack/front/coverage/lcov-report/index.html" 

3. Generate coverage

   ```bash
   npm run e2e:coverage
  
