# Projet Fil Rouge - BACK - BNP Paribas Epita 
​

## Projet
Le projet fil rouge consiste à créer un site permettant aux utilisateurs de donner leur avis (like / dislike) et de mettre des commentaires sur des médias (livre, film, musique
jeux de rôles). 
Des recommandations sont adressées aux utilisateurs du site en fonction des avis déjà partagés. 

Le projet BACK stocké ici fonctionne avec le projet [FRONT](https://github.com/marmai-jma/Project_Front)

Ce projet a été initialisé via [Spring Initializr](https://start.spring.io/)
C'est un projet Maven, en JAVA avec le framework Spring Boot.

Les enregistrements sont persistés dans une base h2.

## Données 
A ce stade du développement du projet, il n'est pas possible de créer de nouveaux médias, ni de nouveaux utilisateurs. Pour cette raison un fichier **data.sql** est mis à disposition pour initialiser la base afin de permettre de tester et d'utiliser l'application. 

## Informations techniques
* Le projet BACK est lancé via `run` sur ProjectApplication dans l'IDE Intellij. Par défaut, le projet BACK tourne sur `http://localhost:8080/`
* La base h2 a pour JDBC URL: jdbc:h2:mem:mediadb avec User Name: jmarnr (sans Password). [Url en local](http://localhost:8080/h2/)
* Les API REST peuvent être testées via [swagger](http://localhost:8080/swagger-ui.html#) 

## API
Liste des API REST exposées par le BACK et appelées dans des composants du FRONT:

- **GET/medias** : Liste l'ensemble des medias présents en base. 

- **GET/medias/{mediaID}** : renvoie les informations d'un média, la liste des reviews associées à ce média (avec le nombre de useful/useless) et la liste des likes/dislikes (likes, avec user login et id).

- **POST/medias/{mediaID}/notation{userLogin}** permet d'enregistrer ou de modifier la notation like / dislike d'un utilisateur identifié par son login sur un média donné. 

- **GET/medias/{mediaID}/notation{userLogin}** renvoie la notation like / dislike d'un utilisateur identifié par son login sur un média donné. 

- **POST/medias/{mediaId}/review/{userLogin}** permet d'enregistrer ou de modifier l'avis (review) d'un utilisateur idéntifié par son login sur un média.

- **GET/medias/{mediaId}/review/{userLogin}** renvoie l'avis d'un utilisateur identifié par son login sur un média. 

- **DELETE/medias/{mediaId}/review/{userLogin}** supprime l'avis d'un utilisateur identifié par son login sur un média. 

- **GET/medias/{mediaId}/reviews** liste tous les avis associés à un média. 

- **GET/recommendations** liste toutes les recommandations. 

- **GET/users/login/{userLogin}** envoie les informations d'un utilisateur identifié par son login.


*Remarque*

*Des API "surnuméraires" ont été codées. Il s'agit soit d'API qui seront utiles dans des versions ultérieures du projet , soit d'API qui ont vocation à être supprimées parce qu'elles correspondent à une version ancienne du projet.* 

*Les API des versions ultérieures ont été codées à un moment où l'on pensait pouvoir les utiliser dans la version actuelle du projet. En vertu du principe YAGNI (You aren't gonna need it), certaines API de la version finale n'ont pas été créées quand il est devenu évident qu'il ne serait pas possible d'aller si loin.* 

*Il est prévu de faire disparaître les API obsolètes lors d'une refactorisation du BACK, à planifier lors d'un Sprint ultérieur du projet afin de respecter le principe KISS (Keep it simple and stupid).*

## Éléments de conception

Diagramme de classes: 
![image info](./UML_diagram.png)

- la partie jaune correspond au MVP (Minimal Viable Product).
- la partie verte correspond au MMP (Minimal Marketable Product).
- la partie bleue correspond au produit final. 


## Versions du projet
En MVP, le projet devait prendre en charge l'affichage à l'écran de la liste des médias présents dans la base h2.

En MMP, la possibilité pour un utilisateur existant de liker/disliker un média et d'émettre un avis persisté en base h2 sur ce média a été ajoutée.

En version actuelle, des recommandations sont proposées aux utilisateurs en fonction des like et des dislikes émis et il est possible de visualiser les informations utilisateur associées à un login. 

En version finale, il sera possible de créer des médias, de nouveaux utilisateurs, de gérer la connexion sécurisée, de liker/disliker un média depuis la liste de la première page et d'émettre un avis utile/inutile sur le commentaire d'un autre utilisateur.