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
      (scenariste IS NULL AND dessinateur IS NULL) OR
      (scenariste IS NULL AND coloriste IS NULL) OR
      (coloriste IS NULL AND dessinateur IS NULL) OR
      (NOT(scenariste IS NULL AND dessinateur IS NULL AND coloriste IS NULL));
