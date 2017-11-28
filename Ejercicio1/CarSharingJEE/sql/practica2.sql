--rutina generacion tablas practica2

--borrado de los datos
DROP SCHEMA IF EXISTS practicaepcsd CASCADE;

--creacion del schema
CREATE SCHEMA IF NOT EXISTS practicaepcsd AUTHORIZATION "USER";

--creacion de la tabla
CREATE TABLE practicaepcsd.driver
(
	nif text NOT NULL,
	"name" text,
	surname text,
	phone text,
	"password" text,
	email text,
	globalRatting double precision,
	CONSTRAINT "Driver_pkey" PRIMARY KEY (nif)
)
WITH (
	OIDS=FALSE
);
ALTER TABLE practicaepcsd.driver OWNER TO "USER";

CREATE TABLE practicaepcsd.car
(
	id integer NOT NULL,
	brand text,
	photo text,
	model text,
	color text,
	nif text,
	CONSTRAINT "Car_pkey" PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
);
ALTER TABLE practicaepcsd.car OWNER TO "USER";

--insercion de datos en la tabla
--driver
insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('11111111A','NOMBRE1','APP1','123456789','PASS1','nombre1@car.com',1.0);
insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('22222222B','NOMBRE2','APP2','123456789','PASS2','nombre2@car.com',1.0);
insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('33333333C','NOMBRE3','APP3','123456789','PASS3','nombre3@car.com',1.0);
insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('44444444D','NOMBRE4','APP4','123456789','PASS4','nombre4@car.com',1.0);
insert into practicaepcsd.driver (nif,name,surname,phone,password,email,globalRatting) values ('55555555E','NOMBRE5','APP5','123456789','PASS5','nombre5@car.com',1.0);

--car
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (1,'brand1','photo1','model1','color1','11111111A');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (2,'brand2','photo2','model2','color2','11111111A');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (3,'brand1','photo1','model1','color1','22222222B');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (4,'brand2','photo2','model2','color2','22222222B');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (5,'brand1','photo1','model1','color1','33333333C');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (6,'brand2','photo2','model2','color2','33333333C');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (7,'brand1','photo1','model1','color1','44444444D');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (8,'brand2','photo2','model2','color2','44444444D');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (9,'brand1','photo1','model1','color1','55555555E');
insert into practicaepcsd.car (id,brand,photo,model,color,nif) values (10,'brand2','photo2','model2','color2','55555555E');
