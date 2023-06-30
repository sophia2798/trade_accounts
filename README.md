# Java Trade Accounts Project
Trade Accounts Capstone project to finish out a [Java Udemy course](https://www.udemy.com/course/the-complete-java-development-bootcamp/). You can visit the link to view topics covered throughout the course.

The application is organized using the following 3 layer design to ensure the maintainability, scalability, and security of the application:

1. Presentation Layer - presenting information to the user
2. Service Layer - middleman between Presentation layer and the Repository
3. Repository Layer - only layer with direct access to the datastore/database

## Overview

This application manages Cash Accounts and Margin Accounts in a database. In this particular case, the database and transactions are populated by a pre-defined .txt file in the data directory. Users are able to perform full CRUD functionality on the database. The application contains logic to instantiate either a Cash Account or Margin Account class/a Cash Account Service or Margin Account Service depending on the ingested data. The main principles utilized in this application are:

- High Order Functions
- Stream Functions
- Inheritance/Polymorphism
- Abstract Classes/Methods
- Interface
- Exception Handling
- Maps and Lists
- Immutable vs. Mutable Objects
- Enums

## Layer Functionality

Presentation
- This layer presents information to the user
- In this case, that would be the Driver class since that is where we handle the user input and output

Service
- This layer is the middleman between the Presentation layer and the Repository layer
- The Presentation layer has to go through the Service layer
- Then the Service layer talks to the Repository
- This layer contains the application's business logic
- In this case, our Service layer contains two classes that implement an Interface
- Classes implementing the Interface are required to override every method inside of the Interface
    - This allows for Polymorphism as a class that implements the Interface is guaranteed to have a concrete implementation of its methods

Repository
- This is the only layer that can access the data store
- Can create, retrieve, delete, or update data from the data store