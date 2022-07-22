insert into authority(id, name) values (1, 'ROLE_ADMIN');
insert into authority(id, name) values (2, 'ROLE_CLIENT');
insert into authority(id, name) values (3, 'ROLE_INSTRUCTOR');

insert into cottages(id,description,name,address,rules,capacity,type) values 
(1,'Odlicna vikendica na Kopaoniku za odmor sa porodicom.','Vikendica Anastasija','Njegoseva 8,Kopaonik','Potrebno je dati 50e unaped.',30,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,type) values 
(2,'Savrsena vikendica za odmor.','Vikendica Raj','Despotova 14,Zlatibor','Morate dati depozit u iznosu od 60e.',50,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,type) values 
(3,'Vikendica vasih snova','Vikendica San','Markova 11,Tara','Nema nikakvih pravila.',10,'Cottage');
insert into cottages(id,description,name,address,rules,capacity,type) values 
(4,'Vikendica samo za Vas','Moja vikendica','Markova 20,Tara','Potrebno je dati depozit u iznosu od 70e.',6,'Cottage');

insert into boats(id,name,address,description,rules,capacity,type) values
(5,'Brod Sloboda','Bulevar Cara Lazara 8,Novi Sad','Velik brod za vise osoba','Potrebno je znati upravljati brodom',15,'Boat');
insert into boats(id,name,address,description,rules,capacity,type) values
(6,'Andrijana','Maksima Gorkog 8,Novi Sad','Mali brod','Potrebno je znati upravljati brodom',3,'Boat');
insert into boats(id,name,address,description,rules,capacity,type) values
(7,'San','Beogradska 2,Beograd','Brod za vase potrebe','Potrebno je znati upravljati brodom',5,'Boat');

--password 123
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('Administrator',1,false,'pera@gmail.com','Pera','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0645654324','Perovic',true);
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('Client',2,false,'mila@gmail.com','Mila','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0696754324','Milic',true);
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('FishingInstructor',3,false,'vlada@gmail.com','Vladimir','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0626554304','Vladic',true);
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('FishingInstructor',4,false,'veljko@gmail.com','Veljko','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','064432123','Veljkovic',true);

insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Njegoseva','Novi Sad','Srbija','5','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar oslobodjenja','Novi Sad','Srbija','10','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Radnicka','Novi Sad','Srbija','21','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(4,0,0,'Danila Kisa','Novi Sad','Srbija','4','21000');

insert into fishing_instructor_adventure(id,name,address,description,rules,capacity,fishing_instructor_id,instructor_biography,type) values 
(8,'Pecajte s Vladom','Marka Miljanova 22,Novi Sad','Vlada ima iskustva u pecanju i sa njim cete uzivati u pecanju',
'Pecanje traje 2 sata.Sve dodatno se dodatno naplacuje po dogovoru.',5,3,'Vlada je iskusni pecaros.','FishingInstructorAdventure');
insert into fishing_instructor_adventure(id,name,address,description,rules,capacity,fishing_instructor_id,instructor_biography,type) values 
(9,'Pecanje sa Veljkom','Kraljeva 33,Beograd','Veljko vas vodi na nezaboravno pecanje',
'Pecanje traje 4 sata.',3,4,'Veljko ima 10 godina iskustva u pecanju','FishingInstructorAdventure');


insert into user_authority(user_id,authority_id) values (1,1);
insert into user_authority(user_id,authority_id) values (2,2);
insert into user_authority(user_id,authority_id) values (3,3);

insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (1,1,2,'2021-10-15 10:00:00','2021-10-25 10:00:00',15000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (2,6,2,'2021-11-01 10:00:00','2021-11-11 10:00:00',20000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (3,7,2,'2022-03-27 10:00:00','2022-03-29 10:00:00',5000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (4,9,2,'2022-06-21 10:00:00','2022-06-23 10:00:00',2000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (5,2,2,'2022-08-25 10:00:00','2022-08-27 10:00:00',6000,false);
insert into reservations(id,renting_item_id,client_id,start_time,end_time,price,cancelled) values (6,3,2,'2022-07-24 10:00:00','2022-07-27 10:00:00',7000,false);

alter sequence user_entity_id_seq restart with 5;
alter sequence user_address_id_seq restart with 5;
alter sequence renting_item_id_seq restart with 10;
