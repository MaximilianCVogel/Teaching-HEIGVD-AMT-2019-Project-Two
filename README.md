# AMT Projet 2

Author: Julien Huguet | Maximilian Vogel
Date: 2020-01-19

# Introduction

Pour ce projet 2 d'AMT, nous avons du mettre en place deux REST API. La première permet le management et la connexion des utilisateurs et la deuxième permet d'effectuer des opérations CRUD sur des bières et bars. De plus, nous avons du mettre en place une table intermédiaire afin de récupérer les bières servies par un bar donné et les bars servant une bière donnée.

# Déploiement de l'architecture

Traefik n'a pas pu être implémenté.

Pour cette raison les API doivent être accédés via Swagger2SpringBoot, l'interface d'administration sur la branche master et l'interface de gestion d'inventaire via la branche feature/beer-cyclopedia (nous avons essayé de rendre les deux API éxécutables sous la même branche, mais cela mène à des problèmes de configuration pour une des deux APIs si on renomme son dossier swagger).

Les scripts .sql se trouvent sous images/mysql/data et un Docker est présent pour les utilser, mais dans ce cas il faut changer spring.datasource.url dans application.properties afin de rendre la machine accessible. Nos tests ont été faits avec mysql en natif sur ubuntu, soit accessible depuis localhost.

# Utilisation des APIs

Pour pouvoir se connecter à nos applications, vous allez devoir générer un JWT Token. Pour ce faire, nous avons mis en place deux utilisateurs.

| Email Utilisateur   | Password | Administrateur |
| ------------------- | -------- | -------------- |
| john.doe@boozify.ch | test123  | Oui            |
| user@boozify.ch     | test123  | Non            |

# Implémentation

La documentation concernant l'implémentation des APIs se trouve 
[ici](Documentation/implementation.md).
