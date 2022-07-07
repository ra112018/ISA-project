insert into authority(id, name) values (1, 'ROLE_ADMIN');
insert into authority(id, name) values (2, 'ROLE_CLIENT');

--password 123
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('Administrator',1,false,'pera@gmail.com','Pera','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0645654324','Perovic',true);
insert into users (role,id,deleted,email,name,password,phone_number,surname,enabled) values
('Client',2,false,'mila@gmail.com','Mila','$2a$10$EfRcY6qiz3FUbUZ/UUdyCuFE9QcB8BlN25NXBqbvdBHAhAOiFOfn6','0696754324','Milic',true);

insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(1,0,0,'Njegoseva','Novi Sad','Srbija','5','21000');
insert into address (id,longitude,latitude,street,city,state,house_number,postcode) values
(2,0,0,'Bulevar oslobodjenja','Novi Sad','Srbija','10','21000');

insert into user_authority(user_id,authority_id) values (1,1);
insert into user_authority(user_id,authority_id) values (2,2);

alter sequence user_entity_id_seq restart with 3;
alter sequence user_address_id_seq restart with 3;