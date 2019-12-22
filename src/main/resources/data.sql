INSERT INTO MEDIA (ID, LABEL, CATEGORY, TYPE, AUTHOR_NAME, AUTHOR_SURNAME, DESCRIPTION, MEDIA_IMAGE_URL, PUBLICATION_DATE)
VALUES ('1', 'Starwars', 'FILM', 'SF', 'Lucas','George', 'Il y a bien longtemps, dans une galaxie très lointaine... La guerre civile fait rage entre l''Empire galactique et l''Alliance rebelle.', 'https://images-na.ssl-images-amazon.com/images/I/61zAtWHeXLL._SY550_.jpg', '1977-10-19');

INSERT INTO MEDIA (ID, LABEL, CATEGORY, TYPE, AUTHOR_NAME, AUTHOR_SURNAME, DESCRIPTION, MEDIA_IMAGE_URL, PUBLICATION_DATE)
VALUES ('2', 'Hotel California', 'MUSIQUE', 'ROCK', 'The Eagles','','Hotel California est le cinquième album studio du groupe rock américain Eagles','http://images.45cat.com/eagles-usa-hotel-california-asylum-3-s.jpg','1976-12-08');

INSERT INTO MEDIA (ID, LABEL, CATEGORY, TYPE, AUTHOR_NAME, AUTHOR_SURNAME, DESCRIPTION, MEDIA_IMAGE_URL, PUBLICATION_DATE)
VALUES ('3', 'L''appel de Cthulhu','JEU', 'HISTORIQUE', 'Petersen','Sandy','Ce jeu emprunte à l’univers de H. P. Lovecraft son ambiance mystérieuse et oppressante. Les joueurs sont confrontés à des situations où ils doivent déjouer les complots de ces créatures et de leurs adorateurs. ','https://en.wikipedia.org/wiki/File:Call_of_Cthulhu_RPG_1st_ed_1981.jpg','1981-01-01');

INSERT INTO MEDIA (ID, LABEL, CATEGORY, TYPE, AUTHOR_NAME, AUTHOR_SURNAME, DESCRIPTION, MEDIA_IMAGE_URL, PUBLICATION_DATE)
VALUES ('4', 'Le seigneur des anneaux','LIVRE', 'FANTASY', 'Tolkien','J.R.R','Roman en 3 prenant place dans le monde de fiction de la Terre du Milieu, il suit la quête du hobbit Frodo Bessac, qui doit détruire l''Anneau unique afin que celui-ci ne tombe pas entre les mains de Sauron, le Seigneur des ténèbres.','https://images.fr.shopping.rakuten.com/photo/1270487382.jpg','1954-07-29');

INSERT INTO USER (ID, LOGIN, PASSWORD, USER_NAME, USER_SURNAME, AVATAR_IMAGE_URL, EMAIL, ACTIVE)
VALUES ('1','Bilbo123','','John','Doe', 'https://greendestinations.org/wp-content/uploads/2019/05/avatar-exemple-300x277.jpg','john.doe@gmail.com','TRUE');

INSERT INTO USER (ID, LOGIN, PASSWORD,USER_NAME, USER_SURNAME, AVATAR_IMAGE_URL, EMAIL,ACTIVE)
VALUES ('2','Bebe Yoda','','Anne','Honime', 'https://s1.thcdn.com//productimg/1600/1600/12376863-2094725918660345.jpg','a.honime@gmail.com','TRUE');
/*
INSERT INTO USER (ID, LOGIN, PASSWORD,USER_NAME, USER_SURNAME, AVATAR_IMAGE_URL, EMAIL,ACTIVE)
VALUES ('3','Bebe zdfsdf','','sdfsdfs','sdfsdfsdfsdfsdf', 'https://s1.thcdn.com//productimg/1600/1600/12376863-2094725918660345.jpg','a.honime@gmail.com','TRUE');
*/
INSERT INTO MEDIA_NOTATION (NOTATION_ID, LIKED, MEDIAJPA_ID, USERJPA_ID)
VALUES (1, 'TRUE', '1', '1');

INSERT INTO MEDIA_NOTATION (NOTATION_ID, LIKED, MEDIAJPA_ID, USERJPA_ID)
VALUES (2, 'FALSE', '2', '1');

INSERT INTO MEDIA_NOTATION (NOTATION_ID, LIKED, MEDIAJPA_ID, USERJPA_ID)
VALUES (3, 'FALSE', '1', '2');
