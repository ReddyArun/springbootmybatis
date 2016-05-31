drop table if exists city;
drop table if exists hotel;

create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);
create table hotel (city int, name varchar, address varchar, zip varchar);

insert into city (name, state, country) values ('Bangalore', 'KA', 'IN');
insert into hotel(city, name, address, zip) values (1, 'Taj Vivant', 'White Field', '560060')