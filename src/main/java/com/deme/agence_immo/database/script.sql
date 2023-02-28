-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

Exploitation de la base de données : Proposer des requêtes pour exploiter votre base de données et
les écrire en syntaxe SQL, et les exécuter.

A. Les requêtes d’ordres simples (2 exemples pour chaque type) :
▪ Écrire des requêtes simples avec l'ordre SELECT.
▪ Éliminer les doublons avec DISTINCT.
▪ Création et utilisation d'alias.

B. Les requêtes d’ordres complexes (2 exemples pour chaque type) :
▪ Trier les données.
▪ Filtrer les données (filtre simple, filtres multiples).
▪ Regrouper les données.
▪ Filtrer par groupes avec la commande HAVING.

C. Les jointures (2 exemples pour chaque type) :
▪ Utiliser des tables jointes avec les différents types de jointure INNER JOIN, NATURAL JOIN et LEFT or RIGHT JOIN.

D. Les requêtes imbriquées (2 exemples pour chaque type) :
▪ Écrire des requêtes imbriquées.

E. Utilisation des opérateurs, des prédicats et des fonctions mathématiques (1 exemples pour
chaque type) :
▪ Utiliser les prédicats : IN, ANY, ALL et EXISTS.
▪ Utiliser les opérateurs : union, intersection et différence.
▪ Utiliser les opérateurs : BETWEEN et IN.
▪ Utiliser les opérateurs : IS NULL et IS NOT NULL.
▪ Utiliser les opérateurs de comparaisons avec : <, >, <=, ==, >= et Like.
▪ Utiliser les fonctions mathématiques : MAX, MIN, SUM, AVG et COUNT.

--REQUETES SIMPLES
SELECT * FROM LOGEMENTS;
SELECT nom,prenom, FROM PERSONNE;
--
SELECT DISTINCT (ville) FROM logement;
SELECT DISTINCT (Num_acheteur) FROM transactions;

--Nombre de logement par ville
SELECT Ville, COUNT(Num_logement) as nombre_logement FROM logement GROUP BY ville;
SELECT AVG(montant) as moyenne_prix FROM offre;

-- REQUETES COMPLEXES
SELECT * FROM personne ORDER BY nom, prenom;
SELECT * FROM offre ORDER BY date_debut DESC;
--
SELECT * FROM offre WHERE NOT date_fin > NOW() OR date_fin IS NULL;
SELECT * FROM logement WHERE ville = 'Cergy' AND Surface_habitable >= 100;
--
SELECT COUNT(Num_logement), rue, ville FROM logement GROUP BY rue ORDER BY ville, rue;
SELECT Num_acheteur, COUNT(id_transaction) as nombre_transactions FROM transactions GROUP BY Num_acheteur;
--▪ Utiliser des tables jointes avec les différents types de jointure INNER JOIN, NATURAL JOIN et LEFT or RIGHT JOIN.
--SELECT * FROM Personne as P INNER JOIN Transactions as T ON P.Num_client = Num_vendeur;
--SELECT * FROM logement as L INNER JOIN Offre as O ON L.Num_logement = O.Num_logement

SELECT * FROM offre AS O INNER JOIN Logement AS L ON O.Num_logement = L.Num_logement WHERE NOT O.date_fin > NOW() OR O.date_fin IS NULL AND O.Id_offre NOT IN (SELECT Id_offre FROM TRANSACTION);

SELECT Id_garage, COUNT(Id_garage) as nb_garage FROM GARAGE GROUP BY (Num_logement) HAVING COUNT(Id_garage) > 1;
