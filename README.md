# Account Enquiry API
API to retrieve the accounts and transactions.

## Endpoints  
Following endpoints are supported by this application.    
1. **GET /accounts**   
    This endpoint is to retrieve the account of a user, userId header should be passed.   
    example:     
    `curl -X GET "http://localhost:8080/accounts" -H "accept: */*" -H "userId: anzuser"`
2. **GET /account/{accountNumber}/transactions**        
    Api endpoint to retrieve the transactions of an account. Account number should be passed as path param.     
    example:   
    `curl -X GET "http://localhost:8080/account/123123345/transactions" -H "accept: */*"`
      

## Technologies Used
``` 
SpringBoot,  
Java8,  
Gradle,  
Junit,   
RestAssured,  
Lombok,  
H2 DB,  
Mockito,  
Swagger,
Jacoco
  ```   

## Build and Deployment

run the below command to build and start the application.  
 
`./gradlew clean build bootRun`

Or Application can be deployed by running the command 

```./gradlew clean build && java -jar build/libs/account-enquiry-0.0.1-SNAPSHOT.jar```

## Testing

This application is using Junit/Mockito for unit testing and RestAssured for API testing.
Jacoco tool for code coverage.
Run the below command for generating jacoco code coverage report.

`./gradlew clean test jacocoTestReport`

Report is generated at
/build/reports/jacoco/test/html/index.html

## Other Information

Swagger is used for API documentation , swagger can be accessed via below url.  
`http://localhost:8080/swagger-ui.html#/`

H2 in-memory DB is used in this application and h2 console can be accessed via below url.   
`http://localhost:8080/h2-console/login.jsp`

This application is using Lombok to reduce the boilerplate code. 
Please make sure to install Lombok plugin and enable annotation processor in IDE.
