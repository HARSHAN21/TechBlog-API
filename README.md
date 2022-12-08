# TechBlog-API

•	TechBlog is a Web App for user to create, update & delete blog(s).
•	User can also read the blog of other users, they can also search blog of their required topic. 
•	Angular is used to create the user interface of TechBlog & Spring boot is used for back-end.
•	This repository is back-end code of TechBlog.
•	https://github.com/HARSHAN21/TechBlog is back-end repo of TechBlog.


## prerequisite

•	Eclipse with J2EE & Maven.
•	MySQL data Base.
•	Create following tables. 
•	blogUser (id int auto_increment primary_key, emailId varchar(20), password varchar(20), name varchar (15) );
•	blog (id int auto_increment primary_key, heading varchar(80), content varchar(500), shortIntro varchar(100), timeToRead int, isPublic boolean, autherId int foreign key blogUser(Id), autherName varchar(20) );

## Local Development server

•	Clone project into local machine.
•	Import this project as existing maven project into eclipse.
•	update resources\application.properties with data base credentials.
