--1.1
SELECT * FROM bd1.albums;

--1.2
SELECT DISTINCT isbn, titre, scenariste, dessinateur, date_edition
FROM bd1.albums;

--1.3
SELECT *
FROM bd1.albums
WHERE editeur = 'Dupuis';

--1.4
SELECT DISTINCT titre
FROM bd1.albums
WHERE scenariste = 'Sente';

--1.5
SELECT DISTINCT titre, editeur
FROM bd1.albums
WHERE scenariste = 'Uderzo' OR dessinateur = 'Uderzo' OR coloriste = 'Uderzo';

--1.6
SELECT *
FROM bd1.albums
WHERE coloriste IS NULL;

--1.7
SELECT DISTINCT editeur
FROM bd1.albums
WHERE date_part('year', date_edition) = '1977';

--1.8
SELECT DISTINCT scenariste, dessinateur
FROM bd1.albums
WHERE editeur = 'Dargaud' AND scenariste <> dessinateur;

--1.9
SELECT *
FROM bd1.albums
WHERE scenariste = dessinateur AND coloriste <> scenariste;

--1.10
SELECT *
FROM bd1.albums
WHERE scenariste = dessinateur AND scenariste = coloriste;

--1.11
SELECT *
FROM bd1.albums
WHERE (scenariste = dessinateur AND scenariste = coloriste) OR
      (scenariste IS NULL AND dessinateur = coloriste) OR
      (dessinateur IS NULL AND scenariste = coloriste) OR
      (coloriste IS NULL AND scenariste = dessinateur) OR
      (scenariste IS NULL AND dessinateur IS NULL AND coloriste IS NOT NULL) OR
      (scenariste IS NULL AND coloriste IS NULL AND dessinateur IS NOT NULL) OR
      (coloriste IS NULL AND dessinateur IS NULL AND scenariste IS NOT NULL);

--1.12
SELECT DISTINCT scenariste
FROM bd1.albums
WHERE date_part('year', date_edition) >= '1980' AND prix < '12' AND scenariste IS NOT NULL;

--1.13
SELECT DISTINCT isbn, titre
FROM bd1.albums
WHERE (date_part('year', date_edition) < '1990' OR date_part('year', date_edition) > '1999') AND
      editeur <> 'Casterman' AND
      (coloriste IS NULL OR coloriste = dessinateur);

--1.14
SELECT DISTINCT titre
FROM bd1.albums
WHERE editeur <> 'Casterman' AND
      editeur <> 'Dupuis' AND
      scenariste <> coloriste AND
      dessinateur <> coloriste AND
      scenariste <> dessinateur;

--1.15
SELECT *
FROM bd1.albums
WHERE serie = 'Lucky Luke' AND editeur = 'Dargaud' OR
      serie = 'Astérix' AND (editeur = 'Albert René' OR editeur ='Le Lombard') OR
      scenariste IS NULL AND dessinateur IS NULL AND coloriste IS NULL;

--1.16
SELECT DISTINCT titre, prix
FROM bd1.albums
WHERE pays_edition = 'fr' AND ((dessinateur IS NULL OR coloriste IS NULL) OR
      (dessinateur IS NULL AND coloriste IS NULL));

--1.17
SELECT DISTINCT isbn, titre, date_edition
FROM bd1.albums
WHERE serie = 'Astérix'
ORDER BY date_edition;

--1.18
SELECT DISTINCT titre
FROM bd1.albums
WHERE serie = 'Astérix'
ORDER BY titre;

--1.19
SELECT DISTINCT isbn, titre, editeur, date_edition
FROM bd1.albums
ORDER BY editeur, date_edition;

--1.20
SELECT DISTINCT isbn, titre, prix
FROM bd1.albums
WHERE editeur = 'Dupuis'
ORDER BY prix DESC;

--1.21
SELECT MIN(date_edition)
FROM bd1.albums;

--1.22
SELECT MAX(prix)
FROM bd1.albums
WHERE dessinateur <> 'Uderzo';

--1.23
SELECT COUNT(*)
FROM bd1.albums
WHERE editeur = 'Casterman';

--1.24
SELECT AVG(prix)
FROM bd1.albums
WHERE editeur = 'Blake et Mortimer' AND
      (date_part('year', date_edition) >= '1990' AND date_part('year', date_edition) <= '1999');

--1.25
SELECT SUM(prix)
FROM bd1.albums
WHERE serie = 'Spirou';

--1.26
SELECT DISTINCT titre
FROM bd1.albums
WHERE LOWER(titre) LIKE '%mystère%';

--1.27
SELECT 3*SUM(prix) * 0.75
FROM bd1.albums
WHERE editeur = 'Blake et Mortimer';

--1.28
SELECT MAX(date_part('year', date_edition)) - MIN(date_part('year', date_edition))
FROM bd1.albums;

--1.29
SELECT DISTINCT editeur
FROM bd1.albums
WHERE editeur LIKE '_% %_';

--1.30
SELECT DISTINCT scenariste
FROM bd1.albums
WHERE (serie = 'Astérix' OR serie = 'Blake et Mortimer') AND date_part('year', date_edition) >= '2000' AND scenariste IS NOT NULL
ORDER BY scenariste;

--1.31
SELECT COUNT(DISTINCT serie)
FROM bd1.albums;

--1.32
SELECT COUNT(*)
FROM bd1.albums
WHERE serie IS NOT NULL;

--1.32 1
SELECT COUNT(serie)
FROM bd1.albums;

--1.32 2
--SELECT COUNT(CASE WHEN serie IS NOT NULL THEN 1 END)
--FROM bd1.albums;

--1.33
SELECT COUNT(serie)
FROM bd1.albums
WHERE serie IS NULL;

--1.33 1
SELECT COUNT(*) - COUnt(serie)
FROM bd1.albums;

--1.33 2
--SELECT COUNT(CASE WHEN serie IS NULL THEN 1 END)
--FROM bd1.albums;

--1.34
SELECT * --DISTINCT USELESS CAR ISBN TJRS DIFF NO?
FROM bd1.albums
WHERE LOWER(isbn) LIKE '2%x';

--1.35
SELECT COUNT(DISTINCT editeur)
FROM bd1.albums
WHERE serie = 'Astérix';

--1.35 2
--SELECT COUNT(DISTINCT CASE WHEN serie = 'Astérix' THEN editeur END)
--FROM bd1.albums;

--1.36
SELECT DISTINCT coloriste
FROM bd1.albums
WHERE LOWER(coloriste) LIKE 'de%';

--1.37
SELECT COUNT(*), MIN(date_edition), MAX(date_edition)
FROM bd1.albums
WHERE coloriste = 'Uderzo' OR dessinateur = 'Uderzo' OR scenariste = 'Uderzo';

--1.38
SELECT AVG(prix)
FROM bd1.albums
WHERE editeur = 'Dupuis' AND NOT (date_part('year', date_edition) >= '1990' AND date_part('year', date_edition) <= '1999');

--1.39
SELECT *
FROM bd1.albums
WHERE isbn LIKE '%00%'
ORDER BY prix DESC, editeur;

--1.40
SELECT DISTINCT editeur
FROM bd1.albums
WHERE (pays_edition = 'be' OR pays_edition IS NULL) AND (date_part('year', date_edition) >= '2000' AND date_part('year', date_edition) <= '2020');

--1.41
SELECT DISTINCT isbn, titre, serie, date_edition
FROM bd1.albums
WHERE (date_part('year', date_edition) >= '1980' AND date_part('year', date_edition) <= '1990')
ORDER BY serie, date_edition DESC;

--1.41 2
--SELECT DISTINCT isbn, titre, serie, date_edition
--FROM bd1.albums
--WHERE date_part('year', date_edition) BETWEEN 1980 AND 1990
--ORDER BY serie, date_edition DESC;

--1.42
SELECT SUM(prix)
FROM bd1.albums
WHERE scenariste = 'Goscinny' OR dessinateur = 'Uderzo';

--1.43
SELECT SUM(prix)
FROM bd1.albums
WHERE scenariste <> 'Goscinny' AND scenariste <> 'Uderzo';

--1.43
SELECT isbn, titre, scenariste, scenariste
FROM bd1.albums
WHERE LOWER(titre) LIKE '%' || LOWER(serie) || '%';