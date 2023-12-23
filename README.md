# Projet dont vous êtes le Héros
Décembre 2023

## Sujet
Ce projet consiste à produire un jeu du type “vous êtes le héros”. Ce style de jeu très populaire
s’adapte à différents types de récit : aventure, romance, horreur ; et permet de plonger le.la joueur.euse
dans une histoire dont l’issue sera déterminée par ses choix et possiblement des événements aléatoires
(e.g., un choix à pile ou face). Les choix réalisés seront déterminants car ils impacteront l’issue du récit à
un moment plus ou moins proche des décisions prises, assurant au joueur (à la joueuse) une fin heureuse
ou terrible.
Les différents choix possibles méneront donc à différents parcours de jeu. Tous ces parcours mènent
à une représentation sous forme d’un graphe orienté acyclic (acyclic pour éviter une partie infinie). Le
graphe est composé de nœuds (chaque nœud représentant une situation) et d’arcs (chaque arc représen-
tant une transisiton entre deux nœuds). Il existera différents types de nœud, des nœuds de décision pour
lesquels le.la joueur.euse est amené.e à faire un choix, des nœuds chance où un évenement aléatoire ce
produit, et des nœuds terminaux pour la fin du jeu (e.g., le.la joueur.euse termine vainqueur.euse d’une
lutte épique couvert.e de lauriers).   

## Spécifications techniques

### Langage de programmation

Programmation Orienté Objet en langage Java.

### Execution du projet Java
Eclipse IDE for Java Developers - 2022-09.
Pour l'execution il faut allez dans le package play et exécuter la classe Main.

### Consultation du résultat produit par le logiciel

Pendant son exécution, 
le logiciel génére des menus intéractifs afin d’intéragir dans la console avec l’utlisateur.
#### Exemple de résultat attendu (sans lancer le debut du game)
```
	****************************************
******************************
Choisir une action : 
********************
(1) Continuer l'histoire
(2) Description du personnage
(3) Quitter 
-> 
3
Au revoir !
```
