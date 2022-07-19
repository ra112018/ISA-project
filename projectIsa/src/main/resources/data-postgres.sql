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

insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Njegoseva','Novi Sad','Srbija','5','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar oslobodjenja','Novi Sad','Srbija','10','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(3,0,0,'Radnicka','Novi Sad','Srbija','21','21000');

insert into user_authority(user_id,authority_id) values (1,1);
insert into user_authority(user_id,authority_id) values (2,2);
insert into user_authority(user_id,authority_id) values (3,3);

alter sequence user_entity_id_seq restart with 4;
alter sequence user_address_id_seq restart with 4;
alter sequence renting_item_id_seq restart with 8;
