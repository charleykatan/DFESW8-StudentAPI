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
There was one episode during which my otherwise gorgeous feature-branch model became tainted by a messy merge. 
Essentially, I finished my testing suite, and everything was fine and dandy - I pushed it to the remote repo's feature-test branch, made a pull request to merge it with dev branch, and made another pull request to merge dev to main. All good. 
Then, in my local repo, I tried to build a .jar file - and eventually I succeeded! (N.B. I later discovered that my .jar file wasn't "fat" enough, so I had to edit my pom.xml and reupload the correct .jar file - persistence and testing is key!)
In the great excitement of the moment, I forgot to pull from the remote repo's dev branch before pushing the .jar file up - as such I ended up merging dev with dev on my local repo, and eventually pushing that up to the remote repo. I think. 
Either way it made my feature-branch model look a bit strange.
I think I understand what went wrong so I feel like it's unlikely I'd make the same mistake again - always remember to pull before pushing!

## Possible improvements for future revisions of the project
Apart from ensuring the aforementioned feature-branch mishap was avoided, the project could be improved by including multiple tables with different constraints and relationships between them. 
I also would like to add some custom methods to the Service/Controller, and include some custom ResponseEntities if, for example, one wished to GetStudentByID and the student didn't exist. 
I will use the rest of my time this week to do so, and will include a link to that repository here.

## Screenshots of Postman Requests and output from the API
Post request in Postman (creating new Student("Donald", 1948-05-12", false, 4.2f) <img width="829" alt="Post - Postman" src="https://user-images.githubusercontent.com/95347202/153022509-809cc593-435e-421f-a415-bfeb88915099.png">

Put request in Postman (editing Donald to become Charley L Katan) <img width="808" alt="Put - Postman" src="https://user-images.githubusercontent.com/95347202/153023217-ae324fde-d4da-40e8-b674-576b7f8b79fb.png">

Delete request in Postman (Charley L Katan is deleted) <img width="796" alt="Delete - Postman" src="https://user-images.githubusercontent.com/95347202/153023647-43b0b20f-968b-457c-892a-bad01f954882.png">

Get all request in Postman (after deleting myself!) <img width="838" alt="Get All - Postman" src="https://user-images.githubusercontent.com/95347202/153024124-9810e2f9-d36c-494b-a56c-2f713dafd9da.png">

Get by id=2 request in Postman <img width="803" alt="Screenshot 2022-02-08 at 15 53 04" src="https://user-images.githubusercontent.com/95347202/153024794-6eb0c71a-bb95-447b-ac39-8712ce7bf57e.png">

## Screenshots of database proving that the data is being persisted
Post request (creating new Student("Donald", 1948-05-12", false, 4.2f) in Workbench ![Post - Workbench](https://user-images.githubusercontent.com/95347202/153022953-e0115d49-eba3-4879-bf46-13e9b3ed5ec8.png)

Put request (editing Donald to become Charley L Katan) ![Put - Workbench](https://user-images.githubusercontent.com/95347202/153023368-19512656-05b3-4850-aa18-e825444469a8.png)

Delete request (deleting Charley L Katan) ![Delete - Workbench](https://user-images.githubusercontent.com/95347202/153023867-22bfe868-8471-45cc-8116-cc8b91515ae7.png)

Get all request (after deleting myself!) ![Screenshot 2022-02-08 at 15 54 15](https://user-images.githubusercontent.com/95347202/153024742-85be54d0-8ae5-495d-9ae6-6763dbad9bf4.png)

Get by id=2 in Workbench![Screenshot 2022-02-08 at 15 53 28](https://user-images.githubusercontent.com/95347202/153024849-9a67e5f6-7fc9-48b3-8b61-d21f68e259e9.png)

## Screenshot of test results, including coverage report
Test results - ![Test](https://user-images.githubusercontent.com/95347202/153025014-fb3eb792-e482-41a2-88fa-fc317f565025.png)

Coverage report - ![Screenshot 2022-02-08 at 15 40 44](https://user-images.githubusercontent.com/95347202/153025081-61aeece8-8d1a-41d2-811e-5790a8b6ca0f.png)

## Link to Jira board
https://id.atlassian.com/invite/p/jira-software?id=iT3J_11wQ7-CHOgZ4W3sQA
https://charleykatan.atlassian.net/jira/software/projects/DS/boards/3

Screenshots from Jira board:![Screenshot 2022-02-10 at 11 53 05](https://user-images.githubusercontent.com/95347202/153403829-b365b506-0a68-478b-9918-82277075d19b.png)
![Screenshot 2022-02-10 at 11 53 28](https://user-images.githubusercontent.com/95347202/153403832-7abdb158-8e04-4d5d-b0c3-d38cfc692638.png)
![Screenshot 2022-02-10 at 11 53 41](https://user-images.githubusercontent.com/95347202/153403834-38ac512a-a99f-47d6-9f09-d3739d8eddec.png)

## Authors
Charley Katan - Initial work - charleykatan

## Acknowledgments
Massive thanks to my trainers and coursemates at the QA Academy for their patience and assistance!
