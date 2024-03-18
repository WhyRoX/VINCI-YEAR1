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


--SM3
-- 1. Donnez la liste des albums, avec, pour chacun d'eux, l'isbn, le titre, le scénariste, le dessinateur et le numéro de l'éditeur.
SELECT isbn, titre, scenariste, dessinateur, editeur
FROM bd2.albums;

-- 2. Donnez la liste des albums, avec, pour chacun d'eux, l'isbn, le titre, le scénariste, le dessinateur et le nom de l'éditeur.
SELECT albums.isbn, albums.titre, albums.scenariste, albums.dessinateur, edits.nom
FROM bd2.albums albums, bd2.editeurs edits
WHERE albums.editeur = edits.id_editeur;

-- 3. Donnez la liste des albums (isbn, titre et nom de l'éditeur) dont l'éditeur est belge.
SELECT albums.isbn, albums.titre, edits.nom
FROM bd2.albums albums, bd2.editeurs edits
WHERE albums.editeur = edits.id_editeur AND edits.pays = 'be';

-- 4. Donnez la liste des albums dont l'éditeur est belge sans la condition de jointure (isbn, titre et nom de l'éditeur). Que constatez-vous ?
SELECT isbn, titre, editeur
FROM bd2.albums albums, bd2.editeurs edits
WHERE edits.pays = 'be';

-- 5. Quels sont les albums (isbn et titre) de la série « Astérix » qui n'ont pas été édités chez « Dargaud » ?
SELECT isbn, titre
FROM bd2.albums albums, bd2.editeurs edits
WHERE albums.editeur = edits.id_editeur AND serie = 'Astérix' AND edits.nom <> 'Dargaud';

-- 6. Quels sont les éditeurs (id et nom) qui ont édité en 1999 des livres coûtant au moins 10 euros ?
SELECT DISTINCT edits.id_editeur, edits.nom
FROM bd2.albums albums, bd2.editeurs edits
WHERE albums.editeur = edits.id_editeur AND (date_part('year', albums.date_edition) = 1999) AND albums.prix >= 10;

-- 7. Chez quel(s) éditeur(s) (id et nom) « Uderzo » a-t-il publié des albums (en tant que scénariste, dessinateur ou coloriste) ?
SELECT DISTINCT edits.id_editeur, edits.nom
FROM bd2.albums albums, bd2.editeurs edits
WHERE albums.editeur = edits.id_editeur AND
      (scenariste = 'Uderzo' OR dessinateur = 'Uderzo' OR coloriste = 'Uderzo');

-- 8. Quels sont les éditeurs (id et nom) localisés ailleurs qu'en Belgique ou pour lequel le pays n'est pas précisé ?
SELECT DISTINCT edits.id_editeur, edits.nom
FROM  bd2.editeurs edits
WHERE
    (edits.pays <> 'be' OR edits.pays IS NULL);

-- 9. Quels sont les albums qui ont été édités en Belgique ou en France, et qui ne sont ni des albums de la série « Tintin », ni des albums de la série « Astérix » ?

-- 10. Quels sont les dessinateurs qui ont été édités par « Dupuis » ? Affichez-les en ordre alphabétique.

-- 11. Donnez la liste des albums édités par « Dupuis » entre 1990 et 2000 (bornes incluses), en affichant pour chacun son isbn, son titre, son dessinateur et sa date d’édition. Triez le tout par dessinateur. Pour chaque dessinateur, les albums doivent être rangés en ordre chronologique.

-- 12. Chez quels éditeurs (id et nom) y a-t-il des albums pour lesquels aucun auteur n'est fourni ?

-- 13. Y a-t-il des albums pour lesquels le nom de l'éditeur est le même que celui de la série ? Donnez, pour ces albums, leur isbn et leur titre.

-- 14. Donnez le nom des éditeurs qui portent le même nom qu’au moins un auteur.

-- 15. Quelle est la date d’édition du dernier album édité en octobre 2013 ?

-- 16. Combien y a-t-il d'albums édités en Belgique dont le dessinateur et le scénariste sont des personnes différentes ?

-- 17. Quelle est la date d'édition la plus ancienne pour les albums édités chez « Casterman » ?

-- 18. Quel est le prix moyen des albums édités par des éditeurs français ?

-- 19. Si je n'ai que 5 euros en poche, quelle est la date d'édition de l'album le plus ancien que je puisse acheter ?

-- 20. Combien d'albums n'ont ni scénariste, ni dessinateur, ni coloriste mentionné ?

-- 21. Combien dois-je débourser pour acheter tous les albums dont l’éditeur est belge et coûtant moins de 8 euros ? Et combien d'albums achèterai-je ainsi ? Quel sera leur prix moyen ?

-- 22. Combien d'années « Franquin » a-t-il écrit ?

-- 23. Oscar a reçu pour son anniversaire l’album « Le mystère de la grande pyramide » dont l’ISBN est 2-87097-008-0. Malheureusement, il l’a déjà. Heureusement, il peut l’échanger contre n’importe quel autre album du même prix mais dont le titre est différent. Contre quels albums peut-il l’échanger ?


--SMN4

--SM5
-- 1.


