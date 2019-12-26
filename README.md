# BACK - Version MVP - Projet Fil Rouge
Le projet fil rouge consiste à créer un site permettant aux utilisateurs de donner leur avis et de mettre des commentaires sur des médias. 
Des recommandations pourront être adressées aux utilisateurs du site en fonction de leurs préférences. 

![image info](./MVP_UML_diagram.png)
Ci-dessus:
- la partie jaune correspond au MVP (Minimal Viable Product).
- la partie verte correspond au MMP (Minimal Marketable Product).
- la partie bleue correspond au produit final. 

L'affichage à l'écran de la liste des médias présents dans la base h2 constitue le MVP de cette application. 

Le MVP côté BACK consiste à mettre à disposition du front une API permettant l'affichage de la liste des médias. 
Pour les tests, la base h2 a été préalablement remplie. La table média contient 4 enregistrements dupliqués plusieurs fois pour permettre des tests. 

Quelques fonctionnalités n'appartenant pas au MVP ont également été développées dans cette version: 
- Les API permettant la création, la modification, la suppression et la lecture d'un object media.
- Les API de création, modification, suppression et lecture des objets User (utilisateur) et Review (avis). 

La table user contient quelques enregistrements mais ils ne correspondent pas au format de la table finale: le userId sera au format Long et non String et un champ booleen active permettra d'activer ou de désactiver un utilisateur. 
