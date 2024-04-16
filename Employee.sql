create table Employee (
	id varchar(10) primary key,
	fullName nvarchar(50),
	birthday varchar(20),
	phone varchar(10),
	email varchar(30),
	employeeType varchar(30),
);

create table Experience (
	id varchar(10) primary key,
	fullName nvarchar(50),
	birthday varchar(20),
	phone varchar(10),
	email varchar(30),
	employeeType varchar(30),
	expInYear int,
	proSkill varchar(30),
);

create table Fresher (
	id varchar(10) primary key,
	fullName nvarchar(50),
	birthday varchar(20),
	phone varchar(10),
	email varchar(30),
	employeeType varchar(30),
	graduatioDate varchar(30),
	graduatioRank varchar(30),
	education varchar(30)
);

create table Intern (
	id varchar(10) primary key,
	fullName nvarchar(50),
	birthday varchar(20),
	phone varchar(10),
	email varchar(30),
	employeeType varchar(30),
	majors varchar(30),
	semester varchar(30),
	universityName varchar(30)
);

select * from Employee