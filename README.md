# Architecture Workshop Demo: The Demo Info Center

The Demo Info Center project, implemented in Java, presented in the Spring Architectural Workshops.

## Motivation and Objective

This project is a first effort to try to detail architectural standards the org can use in their many Java projects. The patterns presented here are largely used in the IT industry and comply with many of the practices adopted across the globe in Spring Boot projects.

So far, the detailed patterns here are:

- Controller
- Controller Advisor
- Service
- Repository
- Validator
- Mapper

Other patterns should be included as the workshop series advances.

## Setup

To have it running in your local machine, make sure you have Java 11 installed. 

An instance of MySQL is also recommended. This is easily obtainable using Docker Desktop. Make sure you run the Docker image with the environment parameter `MYSQL_ROOT_PASSWORD` set as `org#123` and a database called `fantasy_info_center` exists in the instance. The connection parameters are stored in `/src/main/resources/application.properties`.

The command below is enough to build and run the project:

    $ mvn spring-boot:run
