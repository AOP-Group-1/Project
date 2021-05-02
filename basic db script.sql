create database Journey;
	use Journey;
#Create table customer(
#Customerid varchar(40) not null,
#First_name varchar(30) not null,
#Last_name varchar(30) not null,
#Organization varchar(100) not null,
#Primary key(customerid)
#);

 
Create table container(
Containerid varchar(40) not null,
Ownerid varchar(40) not null,
Primary key(containerid)
);
 
#DROP TABLE journey;
Create table journey(
journeyid varchar(40) not null,
Containerid varchar(40) not null,
Clientid varchar(40) not null,
Origin varchar(30) not null,
Destination varchar(30) not null,
Content_type varchar(30) not null,
Company varchar(25) not null,
Complete boolean,
Primary key(journeyid)
);

Create table container_status(
journeyid varchar(40),
Internal_temperature int,
Humidity  int,
Atmospheric_pressure  int,
Time timestamp
);

Create table client(
Clientid varchar(40) not null,
Password varchar(30) not null,
Name varchar(30) not null,
Email varchar(30) not null,
Address varchar(100) not null,
Reference_Person varchar(30) not null,
Primary key(Clientid)
);

select * from container where Containerid = "s" ;
select*from container; 
select*from client;
select*from container_status;
select * from container_status where journeyid = "ef6e20fc-4c17-4d5e-942a-adbfc78c040d";
select*from journey where Complete = true;
UPDATE journey SET Complete = true where Clientid = "56742474-665d-435e-b5ff-f30642153159";
#insert into journey(journeyid,containerid,clientid,origin,destination,content_type
select * from client where name="Bourbon";