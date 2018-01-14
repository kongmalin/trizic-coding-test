# Create a REST API from a RAML spec
I have created 2 REST APIs:
1. Get API (/v1/advisor/{advisorId}/portfolio/{pageNumber}/{pageSize}): for getting all portfolio records for advisor Id that will return as a pagination.
- Sample request:
http://localhost:8090/v1/advisor/e0fe83a1-7512-432f-ba66-d2ae677272c2/portfolio/1/10

2. Post API (/v1/advisor/{advisorId}/portfolio): for adding a new portfolio to advisor. It will insert if the portfolio record does not exist. Otherwise, it will update.
- Sample request:
http://localhost:8090/v1/advisor/e0fe83a1-7512-432f-ba66-d2ae677272c1/portfolio

- Body:
{
   "name":"example model 2",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":10,
   "driftPercentage":5,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"ANNUAL",
   "assetAllocations":[
      {
         "symbol":"SYMBOL01",
         "percentage":30
      },
      {
         "symbol":"SYMBOL02",
         "percentage":60
      }
   ]
}

## Database
I decided to use H2 database since spring supports it out of the box and it can support in memory storage and disk storage.
But I am using it as in memory story.

After you start the project up and running, you can verify the data in H2 database by going to http://localhost:8090/h2-console
- Driver class: org.h2.Driver
- Url: jdbc:h2:mem:testdb
- User: admin
- Password: admin

## Model
- Advisor oneToMany Portfolio
- Portfolio oneToMany AsserAllocation

## Validation

PortfolioReqDto
- name: String, not null
- description: String, not null
- cashHoldingPercentage: Long, not null and range from 0 -> 100
- driftPercentage: Long, not null and range from 0 -> 100
- createdOn: Date, not null, format=yyyy-MM-dd and timezone=Los Angeles
- modelType: String, not null and only "QUALIFIED/TAXABLE"
- rebalanceFrequency: Strint, not null and only "MONTHLY/QUARTERLY/SEMI_ANNUAL/ANNUAL"

AssetAllocationReqDto
- symbol: String, not null
- percentage: Long, not null and range from 0 -> 100

Before persist portfolio to portfolio table, there is a validation to check whether the sum of the cash allocation percentage and all of the individual asset allocations percentage equals 100%.

Controller validation
- validation for media type support Json only
- validation for data binding from Json to Pojo
- validation for any exceptions

## To run the project
- How to run the project in eclipse: right click on project -> run as -> Spring Boot App (require spring boot plugin in your eclipse)
- Or you can run in tomcat: right click -> run as -> Maven Build. It will create a war file in target folder. War name will be test-0.0.1-SNAPSHOT.war. and add to tomcat and run from there.
- The server port will be 8090 (http://localhost:8090).
- There are some initial data which located in data.sql in resources folder.

## Unit test
The unit testing and integration testing are located in src/test/java; package com.trizic.coding.test
There are 2 type of tests:
- Unit testing: which can run from test suit file: AdvisorTestSuit.java but right click -> run as -> Junit Test
- Integration testing: which can run from test file: AdvisorIntegrationTesting.java but right click -> run as -> Junit Test
