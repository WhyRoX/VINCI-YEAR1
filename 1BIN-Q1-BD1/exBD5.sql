--SMN5
-- 1
SELECT al1.isbn, al1.titre, al1.date_edition, al1.prix, ed.nom
FROM bd3.albums al1, bd3.editeurs ed
WHERE al1.editeur = ed.id_editeur AND
      al1.prix > (SELECT AVG(al2.prix) FROM bd3.albums al2)
ORDER BY prix DESC, date_edition;

-- 2
SELECT DISTINCT au.id_auteur, au.nom
FROM bd3.auteurs au, bd3.participations pa
WHERE au.id_auteur = pa.auteur AND
      au.id_auteur NOT IN (SELECT pa.auteur FROM bd3.participations pa WHERE pa.role = 'c' OR pa.role = 'd');

-- 3
SELECT DISTINCT ed.*
FROM bd3.editeurs ed, bd3.albums al
WHERE ed.id_editeur = al.editeur
AND al.isbn NOT IN (SELECT pa.isbn FROM bd3.participations pa);