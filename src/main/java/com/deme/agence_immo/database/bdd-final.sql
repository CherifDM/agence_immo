/*DROP TABLE TRANSACTIONS;
DROP TABLE OFFRE;
DROP TABLE VISITE;
DROP TABLE GARAGE;
DROP TABLE LOGEMENT;
DROP TABLE PERSONNE;*/
DROP TABLE IF EXISTS TRANSACTIONS, OFFRE, VISITE, GARAGE, LOGEMENT, PERSONNE;



CREATE TABLE Personne(
   Num_client INT,
   Nom VARCHAR(50) NOT NULL,
   Prenom VARCHAR(50) NOT NULL,
   Numero INT NOT NULL,
   Rue VARCHAR(255) NOT NULL,
   Code_postal INT NOT NULL,
   Ville VARCHAR(255) NOT NULL,
   PRIMARY KEY(Num_client)
);

CREATE TABLE Logement(
   Num_logement INT,
   Nombre_pieces INT NOT NULL,
   Surface_habitable INT NOT NULL,
   Id_display_pic VARCHAR(255),
   Type_loge VARCHAR(50) NOT NULL,
   Numero INT NOT NULL,
   Rue VARCHAR(255) NOT NULL,
   Code_postal INT NOT NULL,
   Ville VARCHAR(255) NOT NULL,
   Num_proprio INT NOT NULL,
   PRIMARY KEY(Num_logement),
   FOREIGN KEY(Num_proprio) REFERENCES Personne(Num_client)
);

CREATE TABLE Garage(
   Id_garage INT,
   Num_logement INT,
   PRIMARY KEY(Id_garage),
   FOREIGN KEY(Num_logement) REFERENCES Logement(Num_logement)
);
CREATE TABLE Offre(
   Id_offre INT,
   Montant INT NOT NULL,
   Objectif VARCHAR(50) NOT NULL,
   Etat VARCHAR(50) NOT NULL,
   Date_debut DATE NOT NULL,
   Date_fin DATE,
   Num_logement INT NOT NULL,
   Disponible INT NOT NULL,
   PRIMARY KEY(Id_offre),
   FOREIGN KEY(Num_logement) REFERENCES Logement(Num_logement)
);

CREATE TABLE Transactions(
   Id_transaction VARCHAR(50),
   commision INT,
   Jour DATE NOT NULL,
   Num_vendeur INT NOT NULL,
   Num_acheteur INT NOT NULL,
   Id_offre INT NOT NULL,
   PRIMARY KEY(Id_transaction),
   FOREIGN KEY(Num_vendeur) REFERENCES Personne(Num_client),
   FOREIGN KEY(Num_acheteur) REFERENCES Personne(Num_client),
   FOREIGN KEY(Id_offre) REFERENCES Offre(Id_offre)
);

CREATE TABLE Visite(
   Num_logement INT,
   Num_client INT,
   Jour DATE,
   PRIMARY KEY(Num_logement, Num_client, Jour),
   FOREIGN KEY(Num_logement) REFERENCES Logement(Num_logement),
   FOREIGN KEY(Num_client) REFERENCES Personne(Num_client)
);
INSERT INTO Personne VALUES (10, 'Michel', 'Alice', 11, 'Rue De Ravioli',75000,'Paris');
INSERT INTO Personne VALUES (11, 'Dupont', 'Antoine', 15, 'Rue De Ravioli',75000,'Paris');
INSERT INTO Personne VALUES (12, 'Pormanove', 'Jean', 45, 'Rue De',75000,'Paris');

INSERT INTO Personne VALUES (13, 'Dubois', 'Gabriel', 1, 'Rue De La Fountaine Au Roi',75000,'Paris');
INSERT INTO Personne VALUES (14, 'Durand', 'Emma', 2, 'Rue De La Fountaine Au Roi',75000,'Paris');
INSERT INTO Personne VALUES (15, 'Laurent', 'Charles', 3, 'Rue De La Fountaine Au Roi',75000,'Paris');
INSERT INTO Personne VALUES (20, 'El Rey', 'Manuel', 1, 'Rue Des Bois',95000,'Cergy');
INSERT INTO Personne VALUES (21, 'Gaulle', 'Alex', 78, 'Rue Des Bois',95000,'Cergy');
INSERT INTO Personne VALUES (22, 'Andriana', 'Tiana', 69, 'Rue Des Bois',95000,'Cergy');
INSERT INTO Personne VALUES (23, 'La Porte', 'Anne', 12, 'Rue De Panama',95300,'Cergy');
INSERT INTO Personne VALUES (24, 'Andrina', 'Andy', 1, 'Rue De Panama',95300,'Cergy');
INSERT INTO Personne VALUES (25, 'Mercedes', 'Mathieu', 20, 'Rue De Panama',95300,'Cergy');
INSERT INTO Personne VALUES (26, 'Joana', 'Ratos', 117, 'Rue De Panama',95300,'Cergy');
INSERT INTO Personne VALUES (30, 'Balanom','Macro', 1, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (31, 'Idris','Elbow', 3, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (32, 'Shiki','Mona', 5, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (33, 'John','Macro', 4, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (34, 'Forecast','Eve', 17, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (35, 'Balanom','Joji', 19, 'Rue Sigmund Fraud',93000,'Bobigny');
INSERT INTO Personne VALUES (90, 'Chihab', 'Abdul',13,'Avenue Voltaire',93071,'Sevran');
INSERT INTO Personne VALUES (91, 'Sime', 'Alexis',14,'Avenue Voltaire',93071,'Sevran');
INSERT INTO Personne VALUES (92, 'Hel Karki', 'Adain',3,'Avenue Voltaire',93071,'Sevran');
INSERT INTO Personne VALUES (93, 'Dasse', 'Aurel',6,'Rue Bundy',93071,'Sevran');
INSERT INTO Personne VALUES (94, 'Manson', 'Jesse',21,'Rue Bundy',93071,'Sevran');
INSERT INTO Personne VALUES (95, 'Ted', 'Bonnie',17,'Rue Bundy',93071,'Sevran');

INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (1,5,108,'Maison',13, 'Rue De Gamebetta',75000,'Paris',95);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (2,4,98,'Maison',12, 'Rue De Pantheon',75000,'Paris',11);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (3,3,40,'Appartement',11, 'Bel-Air',75012,'Paris', 22);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (4,3,71,'Appartement',14, 'Bel-Air',75012,'Paris',11);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (5,4,71,'Appartement',77, 'Quartier Muette Sud',75016,'Paris',15);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (6,4,50,'Appartement',81, 'Quartier Muette Sud',75016,'Paris',15);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (7,2,44,'Appartement',83, 'Quartier Muette Sud',75016,'Paris',15);

INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (8,10,447,'Maison',13, 'Avenue Emilie Zola',92100,'Boulogne',25);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (9,4,101,'Appartement', 28, 'Avenue Emilie Zola',92100,'Boulogne',14);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (10,10,350,'Maison', 16, 'Rue Prince-Marmottan',92100,'Boulogne',25);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (11,5,120,'Appartement', 11, 'Rives De Seine',92100,'Boulogne',32);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (12,4,56,'Appartement', 17, 'Rives De Seine',92100,'Boulogne',32);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (13,2,44,'Appartement', 17, 'Rives De Seine',92100,'Boulogne',32);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (14,8,150,'Maison',13, 'Port Ham-Village',95000,'Cergy',14);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (15,7,187,'Maison', 28, 'Port Ham-Village',95000,'Cergy',14);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (16,3,60,'Appartement',77, 'Le Hazay',95800,'Cergy',20);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (17,3,64,'Appartement', 31,'Le Hazay',95800,'Cergy',20);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (18,10,145,'Maison', 46, 'Chat Perche',95800,'Cergy',32);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (19,1,16,'Appartement', 111, 'Axe-Majeur',95800,'Cergy',32);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (20,1,27,'Appartement', 27, 'Touleuses-Bocages',95800,'Cergy',20);
INSERT INTO Logement (Num_logement, Nombre_pieces, Surface_habitable, Type_loge, Numero, Rue, Code_postal, Ville, Num_proprio) VALUES (21,2,44,'Appartement', 27, 'Touleuses-Bocages',95800,'Cergy',20);

INSERT INTO Offre VALUES (1,1390000.00,'Vente','Neuve', '2023-02-05',NULL,1,0);
INSERT INTO Offre VALUES (2,1490000.00,'Vente','Neuve', '2022-12-11',NULL,1,1);
INSERT INTO Offre VALUES (3,927000.00,'Vente','Tres Bon Etat', '2022-11-01',NULL,2,1);
INSERT INTO Offre VALUES (4,390000.00,'Vente','Neuve', '2022-10-12',NULL,3,1);
INSERT INTO Offre VALUES (5,710000.00,'Vente','Neuve', '2022-12-21',NULL,4,1);
INSERT INTO Offre VALUES (6,2520.00,'Location','Tres Bon Etat', '2022-06-01','2022-12-01',5,1);
INSERT INTO Offre VALUES (7,3400.00,'Location','Neuve', '2022-11-01','2023-11-01',6,1);
INSERT INTO Offre VALUES (8,1290.00,'Location','Bon Etat', '2023-03-01','2023-09-01',7,1);
INSERT INTO Offre VALUES (9,3790000.00,'Vente','Neuve', '2023-03-01',NULL,8,1);
INSERT INTO Offre VALUES (10,1045000.00,'Vente','Bon Etat', '2022-04-01',NULL,9,0);
INSERT INTO Offre VALUES (11,1095000.00,'Vente','Neuve', '2023-05-01',NULL,9,1);
INSERT INTO Offre VALUES (12,20900.00,'Location','Tres Bon Etat', '2022-10-01',NULL,10,1);
INSERT INTO Offre VALUES (13,2890.00,'Location','Neuve', '2022-05-01',NULL,11,1);
INSERT INTO Offre VALUES (14,445000.00,'Vente','Bon etat', '2022-05-01',NULL,14,1);
INSERT INTO Offre VALUES (15,730000.00,'Vente','Tres Bon Etat', '2022-05-01',NULL,15,1);
INSERT INTO Offre VALUES (16,197000.00,'Vente','Neuve', '2022-05-01',NULL,16,1);
INSERT INTO Offre VALUES (17,117000.00,'Vente','A Renover', '2022-01-01',NULL,17,0);
INSERT INTO Offre VALUES (18,1750.00,'Location','Neuve', '2023-02-01',NULL,17,1);
INSERT INTO Offre VALUES (19,890.00,'Location','Tres Bon Etat', '2022-05-01',NULL,18,1);
INSERT INTO Offre VALUES (20,520.00,'Location','Tres Bon Etat', '2022-05-01',NULL,19,1);
INSERT INTO Offre VALUES (21,660.00,'Location','Tres Bon Etat', '2021-02-01',NULL,20,0);
INSERT INTO Offre VALUES (22,840.00,'Location','Neuve', '2023-01-01',NULL,20,1);

INSERT INTO Garage VALUES (1,1);
INSERT INTO Garage VALUES (2,2);
INSERT INTO Garage VALUES (3,3);
INSERT INTO Garage VALUES (4,3);
INSERT INTO Garage VALUES (5,4);
INSERT INTO Garage VALUES (6,4);
INSERT INTO Garage VALUES (7,8);
INSERT INTO Garage VALUES (8,8);
INSERT INTO Garage VALUES (9,10);
INSERT INTO Garage VALUES (10,10);
INSERT INTO Garage VALUES (11,11);
INSERT INTO Garage VALUES (12,14);
INSERT INTO Garage VALUES (13,15);
INSERT INTO Garage VALUES (14,15);
INSERT INTO Garage VALUES (15,16);
INSERT INTO Garage VALUES (16,16);
INSERT INTO Garage VALUES (17,17);
INSERT INTO Garage VALUES (18,19);

INSERT INTO Transactions VALUES (1,5,'2022-11-28',11,22,4);
INSERT INTO Transactions VALUES (2,5,'2022-05-04',15,23,6);
INSERT INTO Transactions VALUES (3,5,'2022-02-01',26,14,10);
INSERT INTO Transactions VALUES (4,5,'2022-12-11',25,14,12);
INSERT INTO Transactions VALUES (5,5,'2022-04-21',24,20,17);
INSERT INTO Transactions VALUES (6,5,'2021-02-15',20,34,21);
INSERT INTO Transactions VALUES (7,5,'2023-01-30',20,92,22); 
INSERT INTO Transactions VALUES (8,5,'2023-01-21',32,95,1);

INSERT INTO Visite VALUES (4,22,'2022-10-16');
INSERT INTO Visite VALUES (6,23,'2022-03-29');




---REQUETES---
--Recherche de logement
Tous les logements actuellemnt disponible
Tous les logements actuellemnt indisponible avec la date de fin de location
Logement avec garage qui se sur une rue en particulier
Liste de logements qui one apporte le plus de profit a lagence
Logements avec plusieurs garage
--Gestion comptes
Historique de tout les achats / ventes de un client
Tous les visite a venir de un client en particulier
--Gestion clients
Tous les clients qui possede au moins 1 logement ()
Liste des clients qui one apporte le plus de profit a lagence
Liste de clients qui habitent actuellemt dans un logement que ils souhaite vendre
--
Liste des transaction de client qui sont proprio de un logement a boulogne
Liste des logement qui nont jamais ete vendu(order by oldest)