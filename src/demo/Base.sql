DROP DATABASE flotte;
CREATE DATABASE flotte;
DROP ROLE s5;
CREATE ROLE s5 login password 'root';
ALTER DATABASE flotte OWNER TO s5;
\c flotte s5;




-- create table Marque(
--     id_Marque serial primary key,
--     marque 
-- );


create table avion(
    id serial primary key,
    marque VARCHAR(20) not null unique,
    capacite_personne int,
    capacite_carburant VARCHAR (10),
    vitesse_max VARCHAR (15),
    imageavion VARCHAR(50)
);

create table kilometrage(
    id_kilometrage serial primary key,
    id_Avion int not null REFERENCES Vehicule(id_Vehicule),
    dates Date not null,
    debutkm int not null check(debutkm>=0),
    finkm int not null check(finkm>0)
);
create table assurance(
    id_avion int,
    id_assurance serial primary key,
    Date_assurancedebut date,
    Date_assurancefin date
);

-- view 
    -- vehicule avec marque
    create view VehiculeM as select id_Vehicule,Vehicule.id_Marque,immatriculation,marque from Vehicule join Marque on Vehicule.id_Marque=Marque.id_Marque; 
    --  kilometre_effectue
    create view kilometre_effectue as select VehiculeM.id_Vehicule,Kilometrage.id_kilometrage,VehiculeM.immatriculation,VehiculeM.marque,Kilometrage.date,(Kilometrage.finkm-kilometrage.debutkm)as trajet ,kilometrage.debutkm,Kilometrage.finkm from kilometrage join VehiculeM on Kilometrage.id_Vehicule=VehiculeM.id_Vehicule;

-- -- insert--
    insert into Marque(marque) values('Peugeot'),('Citroen');
 insert into Avion(marque, capacite_personne, capacite_carburant,vitesse_max,imageavion) values('Boeing 737','1200','1000l','500km/h','iamge.png');
 
 
 --insert into Kilometrage(id_Vehicule,date,debutkm,finkm) values('?','2022-11-14',100,105),('?','2022-11-14',50,80);

-- --select--
-- select * from VehiculeM
-- select* from Kilometrage


--     --historique kilometrage
-- select* from kilometre_effectue where id_Vehicule=?
--     --kilometrage a une date donnee 
-- select* from kilometre_effectue where date=?
--     -- kilometrage vehicule a une date
-- select* from kilometre_effectue where id_Vehicule=? and date=?

create table utilisateur(
    id Serial PRIMARY KEY,
    mail VARCHAR(30) not null,
    mdp VARCHAR(20) not null
);

insert into utilisateur(mail, mdp)values('test@gmail.com','test');


create table tokenAdmin(
                           id serial not null,
                           idAdmin int,
                           token varchar(255),
                           EXPIRATION_DATE timestamp
);
