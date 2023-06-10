--Create database Railjet_db;

Create table RailCarData (
Id Serial primary key,
Wagennummer varchar(64) not null,
Wagenklasse varchar (64) not null,
WagenTyp varchar (64) not null,
Sitzplatzanzahl int not null,
Reservierungen int	
);