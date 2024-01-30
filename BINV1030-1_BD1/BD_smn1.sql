--1.1
SELECT * FROM bd1.albums;

--1.2
SELECT DISTINCT isbn, titre, scenariste, dessinateur, date_edition FROM bd1.albums;

--1.3
SELECT * FROM bd1.albums WHERE editeur = 'Dupuis';

--1.4
SELECT DISTINCT titre FROM bd1.albums WHERE scenariste = 'Sente';

--1.5
SELECT DISTINCT titre, editeur FROM bd1.albums WHERE scenariste = 'Uderzo' OR dessinateur = 'Uderzo' OR coloriste = 'Uderzo';

--1.6
SELECT  * FROM bd1.albums WHERE coloriste IS NULL;

--1.7
SELECT DISTINCT editeur FROM bd1.albums WHERE date_part('year', date_edition) = '1977';

--1.8
SELECT DISTINCT scenariste, dessinateur FROM bd1.albums WHERE editeur = 'Dargaud';