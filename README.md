# Kotlin-Angular 7
Rest based CRUD Application 

## Kotlin, JPA, Mysql, Angular 7 and Material CSS
There are two parts 
     - Kotlin + JPA
     - Angular 7 + Material CSS

### Kotlin + JPA + MySQL

#### MYSQL

    1. Create Database Slotbook
    
    2. CREATE TABLE slotbook.users (
        id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        firstname VARCHAR(30) NOT NULL,
        lastname VARCHAR(30) NOT NULL,
        email VARCHAR(50) NOT NULL
      );

#### JPA

    interface UsarioRepository: JpaRepository<Users, Long>
    
#### Maven Command To Run

    mvn spring-boot:run

## Angular 7 + Material CSS

#### Run Angular Application

    ng serve

#### Angular Proxy-conf.json

    {
     "/api": {
     "target": "http://localhost:8080/",
     "secure": false,
     "changeOrigin"
    }
    }



    
   


