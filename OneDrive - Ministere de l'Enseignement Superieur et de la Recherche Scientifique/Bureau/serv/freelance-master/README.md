# 📌 Freelance Profile Platform

Une plateforme simple pour gérer les profils de freelances avec leurs compétences et leurs liens professionnels. Ce projet est basé sur **Spring Boot**, **GraphQL**, **H2**, et **Thymeleaf**.

---

## 🚀 Fonctionnalités

- 🔍 Liste des freelances
- ➕ Création / suppression de profils
- 🛠️ Gestion des compétences et des liens professionnels
- 📡 API GraphQL pour les opérations CRUD
- 💾 Base de données H2 en mémoire (console intégrée)
- 🖥️ Vue simple en Thymeleaf

---

## ⚙️ Technologies utilisées

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring for GraphQL
- H2 Database (in-memory)
- Thymeleaf

---

## 📁 Structure du projet

- `Freelance`, `Competence`, `LienProfessionnel` : Entités JPA
- `FreelanceService`, etc. : Logique métier
- `GraphQLController` : API GraphQL
- `schema.graphqls` : Définition des requêtes/mutations
- `index.html` : Vue Thymeleaf
- `application.properties` : Configuration H2, GraphQL et templates

---

## 🔌 API GraphQL

### 📤 Mutations

```graphql
mutation {
  createFreelance(nom: "Jean", email: "jean@mail.com", bio: "Dev Java") {
    id
    nom
  }

  createCompetence(nom: "Java", niveau: "Avancé", freelanceId: 1) {
    id
    nom
  }

  createLien(type: "LinkedIn", url: "https://linkedin.com/in/jean", freelanceId: 1) {
    id
    url
  }

  deleteFreelance(id: 1)
}
