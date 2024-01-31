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