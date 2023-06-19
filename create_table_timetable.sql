--select current_database();

create table TimeTable_Rjx162(
Id Serial primary key,
Bahnhof varchar(64) not null,
BahnhofNummer int not null,
Abfahrtszeit varchar(10) not null);

