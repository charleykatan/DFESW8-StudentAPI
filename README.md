# DFESW8-StudentAPI
Final project for DFESW8 - creating a fully-functional RESTful Spring Boot API, using an application back-end developed in Java, a managed database hosted on MySQL, and a means of making API calls using Postman and a means of checking data persistence using MySQL Workbench.

This API manages the records of Students in a school/university database.

Coverage: 98.6%

## Why are we doing this?
This project was undertaken as a means of testing each of the topics covered over the duration of the 9-week intensive Software Development bootcamp with QA. 
This project involved:

- ascribing to Agile principles in Project Management (explified by the usage of GitHub and Jira);
- consolidating knowledge of Databases and Cloud Fundamentals (exemplified by the usage of MySQL and H2);
- using Java programming fundamentals and knowledege of Object Oriented Programming in order to create a new domain (Students) and a fully-functional and tested set of CRUD methods.
- using Spring Boot to create and run the API.
- testing the created API using JUnit and Mockito automated testing.

## How I expected the challenge to go
Having never undertaken a wholly independent software development challenge before, I was apprehensive about all of the many moving pieces coming together.
Specifically, I was anxious that I didn't fully recall how to ascribe to the feature-branch model. I anticipated having some trouble with Git, and potentially with connecting to MySQL database as this had proven difficult previously. 
I wasn't sure I remembered how to build a .jar file either.
I felt confident with the coding back-end, including the full suite of testing.
I expected to finish the basic model of the project within the time-frame allocated, and hoped to have time to develop further features if I finished early.

## What went well?
I was able to complete the API's back-end speedily, while adhering to the feature branch model! 
Further, for the first time I was able to connect to MySQL database and see the data being persisted in realtime when running the API. 
I was also able to reach 98.6% testing coverage, including on the Controller, which I hadn't expected.
My time-management was very good - I lost 3 hours on the first day of the project to an OS update but managed to make progress in half the time I expected.

## What didn't go as planned?
There was one episode during which my otherwise gorgeous feature-branch model became tainted with a messy merge. 
Essentially, I finished my testing suite, and everything was fine and dandy - I pushed it to the remote repo\s feature-test branch, made a pull request to merge it with dev branch, and made another pull request to merge dev to main. All good. 
Then, in my local repo, I tried to build a .jar file - and eventually I succeeded! 
In the great excitement of the moment, I forgot to pull from the remote repo's dev branch before pushing the .jar file up - as such I ended up merging dev with dev on my local repo, and eventually pushing that up to the remote repo. I think. 
Either way it made my feature-branch model look a bit strange.
I think I understand what went wrong so I feel like it's unlikely I'd make the same mistake again - always remember to pull before pushing!

## Possible improvements for future revisions of the project
Apart from ensuring the aforementioned feature-branch mishap was avoided, the project could be improved by including multiple tables with different constraints and relationships between them. 
I also would like to add some custom methods to the Service/Controller, and include some custom ResponseEntities if, for example, one wished to GetStudentByID and the student didn't exist. 
I will use the rest of my time this week to do so, and will include a link to that repository here.

## Screenshots of Postman Requests and output from the API

## Screenshots of database proving that the data is being persisted

## Screenshot of test results, including coverage report

## Link to Jira board
https://id.atlassian.com/invite/p/jira-software?id=iT3J_11wQ7-CHOgZ4W3sQA
https://charleykatan.atlassian.net/jira/software/projects/DS/boards/3

## Authors
Charley Katan - Initial work - charleykatan

## Acknowledgments
Massive thanks to my trainers and coursemates at the QA Academy for their patience and assistance!
