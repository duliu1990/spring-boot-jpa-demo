use test;
create table person (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LastName varchar(255),
    FirstName varchar(255),
    Age int,
    Birth DATE,
    Salary decimal(11,2)
);

insert person (LastName, FirstName, Age, Birth, Salary) values ('Jack', 'Li', 18, '1990-09-01', 50000.12);
