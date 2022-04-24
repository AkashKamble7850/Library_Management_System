CREATE DATABASE Library2;

USE Library2;

DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS IssueBook;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS MembershipPlan;
DROP TABLE IF EXISTS Feedback;
DROP TABLE IF EXISTS Vendor;
DROP TABLE IF EXISTS Fine;
DROP TABLE IF EXISTS Orders;

CREATE TABLE MembershipPlan (
planId INT PRIMARY KEY AUTO_INCREMENT,
planName VARCHAR(50),
planFee DOUBLE);

INSERT INTO MembershipPlan VALUES (
1,"One Month",500);

INSERT INTO MembershipPlan VALUES (
2,"Three Months",1400);

INSERT INTO MembershipPlan VALUES (
3,"Six Months",2600);

INSERT INTO MembershipPlan VALUES (
4,"One Year",5000);


CREATE TABLE User (
userId INT PRIMARY KEY AUTO_INCREMENT,
uFirstName VARCHAR(50) NOT NULL,
uLastName VARCHAR(50) NOT NULL,
uEmail VARCHAR(50) UNIQUE KEY NOT NULL,
uMobile VARCHAR(10) UNIQUE KEY,
uPassword VARCHAR(600) NOT NULL,
uAddress VARCHAR(100) ,
uRegisterDate timestamp default CURRENT_TIMESTAMP,
uEducation VARCHAR(50),
uIntrest VARCHAR(50),
uPlanId INT,
FOREIGN KEY(uPlanId) REFERENCES MembershipPlan(planId) ON UPDATE CASCADE ON DELETE CASCADE,
uStatus Boolean DEFAULT 0);

INSERT INTO User(userId,uFirstName,uLastName,uEmail,uMobile,uPassword,uAddress,uEducation,uIntrest,uPlanId) VALUES (
101, "Akash","Kamble", "abc@test.com", "9876543210", "$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm", "Solapur", "BE", "Biography", 4); 

INSERT INTO User(userId,uFirstName,uLastName,uEmail,uMobile,uPassword,uAddress,uEducation,uIntrest,uPlanId) VALUES (
102, "Abhishek","Deshmukh", "pqr@test.com", "0123456789", "$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm", "Pune", "ME", "Anime", 3); 

INSERT INTO User(userId,uFirstName,uLastName,uEmail,uMobile,uPassword,uAddress,uEducation,uIntrest,uPlanId) VALUES (
103, "Neha","Jumde", "xyz@test.com", "7894561230", "$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm", "Dhule", "BE", "Language", 2);

INSERT INTO User(userId,uFirstName,uLastName,uEmail,uMobile,uPassword,uAddress,uEducation,uIntrest,uPlanId) VALUES (
104, "Vivek","Ikhar", "lmn@test.com", "4567891230", "$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm", "Nagpur", "ME", "Novel", 1); 

CREATE TABLE Feedback (
feedbackId INT PRIMARY KEY AUTO_INCREMENT,
feedback VARCHAR(100),
userId INT,
FOREIGN KEY(userId) REFERENCES User(userId) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Feedback VALUES (
11, "Online issue book system is awesome", 101);

INSERT INTO Feedback VALUES (
12, "Faced issues while returning book", 103);

INSERT INTO Feedback VALUES (
13, "Very simple to access library functions", 101);

INSERT INTO Feedback VALUES (
14, "Great experience", 102);

CREATE TABLE Category(
	categoryId INT PRIMARY KEY AUTO_INCREMENT,
	categoryName VARCHAR(50) NOT NULL
);

INSERT INTO Category VALUES (
501, "Romance");

INSERT INTO Category VALUES (
502, "Thrillers");

INSERT INTO Category VALUES (
503, "Science Fiction");

INSERT INTO Category VALUES (
504, "Fantasy");

CREATE TABLE Staff(
	staffId INT PRIMARY KEY AUTO_INCREMENT,
	sFirstName VARCHAR(50) NOT NULL,
	sLastName VARCHAR(50) NOT NULL,
	sRole VARCHAR(50) NOT NULL,
	sGender VARCHAR(10),
	sEmail VARCHAR(100) UNIQUE KEY NOT NULL,
	sPassword VARCHAR(600) NOT NULL,
	sMobile VARCHAR(50),
	sAddress VARCHAR(100),
	sDateOfJoining DATE,
	sSalaryStatus Boolean
);

INSERT INTO Staff VALUES(201,'Divya','Raut','Admin','Female','Divya@test.com','$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm','897654321','Mumbai','2006-05-04',0);

INSERT INTO Staff VALUES(default,'Rohit','Sharma','Librarian','Male','rohit@test.com','$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm','987654321','Delhi','2021-05-06',0);

INSERT INTO Staff VALUES(default,'Aditya','Singh','Inventory Manager','Male','adi@test.com','$2a$10$oKwk4dDaN/xbYD2xWzPFNOeov3bWLe2nIyfu795Lhif9VPrjpjCRm','877654321','Chennai','2021-06-15',0);

create table Author(
authorId INT PRIMARY KEY AUTO_INCREMENT,
aFirstName VARCHAR(50) NOT NULL,
aLastName VARCHAR(50) NOT NULL
);

INSERT INTO Author VALUES(
301,"Paulo", "Coelho");


INSERT INTO Author VALUES(
default,"James", "Clear");

create table Vendor(
vendorId INT PRIMARY KEY AUTO_INCREMENT,
vendorName VARCHAR(50) NOT NULL,
vendorAddress VARCHAR(50),
vendorContact VARCHAR(50),
categoryId INT,
FOREIGN KEY (categoryId) REFERENCES Category(categoryId) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Vendor VALUES(
401,"XYZ", "Nagpur", "5465546565", 501
);

INSERT INTO Vendor VALUES(
402,"ABC", "Pune","5648568756", 502
);


create table Book (
	bookId INT PRIMARY KEY AUTO_INCREMENT,
	isbn VARCHAR(50) UNIQUE,
	bookName VARCHAR(100) NOT NULL,
	bookDescription VARCHAR(200),
	categoryId INT,
	authorId INT ,
	quantity INT NOT NULL,
	language VARCHAR(50),
	published INT,
	FOREIGN KEY (categoryId) REFERENCES Category(categoryId) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (authorId) REFERENCES Author(authorId) ON UPDATE CASCADE ON DELETE CASCADE
	);


INSERT INTO Book VALUES (1001, 
			"9780061122415", 
			"The Alchemist",
			"Paulo Coelho's enchanting novel has inspired a devoted following around the world.", 
			501,
			301,
			15,
			"English",
			2022);

INSERT INTO Book VALUES (default, 
			"9783442178582", 
			"Atomic Habits",
			"James Clear's book Atomic Habits states that big goals should not be the main focus of peoples' lives.", 
			502,
			302,
			12,
			"English",
			1998);


create table IssueBook (
	issueBookId INT PRIMARY KEY AUTO_INCREMENT,
	bookId INT,
	issueDate DATE NOT NULL,
	dueDate DATE,
	returnDate DATE DEFAULT NULL,
	issueStatus VARCHAR(50) NOT NULL,
	userId INT NOT NULL,
	staffId INT,
	FOREIGN KEY (bookId) REFERENCES Book(bookId) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (staffId) REFERENCES Staff(staffId) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (userId) REFERENCES User(userId) ON UPDATE CASCADE ON DELETE CASCADE

);

INSERT INTO IssueBook VALUES (10001, 
			      1001, 
			      (now()), 
			      NULL, 
			      NULL, 
			      "IR", 
                              101, 
			      201);

INSERT INTO IssueBook VALUES (10002, 
			      1001, 
			      (now()), 
			      NULL, 
			      NULL, 
			      "IR", 
			      101, 
			      201);

INSERT INTO IssueBook VALUES (10003, 
			      1001, 
			      "2022-03-26", 
			      NULL, 
			      NULL, 
			      "I", 
			      101, 
			      201);

INSERT INTO IssueBook VALUES (10004, 
			      1001, 
			      "2022-02-26", 
			      NULL, 
			      NULL, 
			      "IR", 
			      101, 
			      201);

<<<<<<< HEAD
INSERT INTO IssueBook VALUES (10007, 
			      1001, 
=======
INSERT INTO IssueBook VALUES (10006, 
			      1002, 
>>>>>>> 2a1fc94a52ec7ae2e0f0b0ff43fa98ecd0283959
			      "2022-02-26", 
			      NULL, 
			      NULL, 
			      "IR", 
			      105, 
			      201);

INSERT INTO IssueBook VALUES (100019, 
			      1008, 
			      now(), 
			      "2022-04-27", 
			      NULL, 
			      "I", 
			      102, 
			      202);



CREATE TABLE Fine(
	fineId INT PRIMARY KEY AUTO_INCREMENT,
	fineStatus VARCHAR(50),
	issueBookId INT NOT NULL,
	FOREIGN KEY(issueBookId) REFERENCES IssueBook(issueBookId)
	ON DELETE CASCADE ON UPDATE CASCADE	
);


INSERT INTO Fine VALUES(
601,"UNPAID",10001
);

INSERT INTO Fine VALUES(
604,"UNPAID",10007
);


CREATE TABLE Orders(
	orderId INT PRIMARY KEY AUTO_INCREMENT,
	bookName VARCHAR(50),
	aFirstName VARCHAR(50),
	quantity INT,
	language VARCHAR(50),
	vendorId INT,
	FOREIGN KEY(vendorId) REFERENCES Vendor(vendorId) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Orders VALUES(801,'Cinder','Marissa',19,'English',401);

INSERT INTO Orders VALUES(default,'Divergent','Veronica',13,'English',402);



