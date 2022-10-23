# Spring Boot-PostgreSQL Db-One To Many-Company&Employee-Project
Building Rest APIs with Spring Boot, JPA.
This is a Company-Employee relantioship project made with one to many with jpa and connected to PostgreSQL database.

# Tehcnologies
<ul>
  <li>Java</li>
  <li>Maven</li>
  <li>Lombok</li>
  <li>ModelMapper</li>
  <li>JPA</li>
</ul>

# Installation
The project is created with Maven, please build the project to resolve the dependencies. <br />



# Usage

 <li>Please create one PostgreSQL database named = "enocaDatabase"</li>
 <li>Run the project </li>
 <li>It is already have some data inside, check from Postman.</li>

# Employee-With-Company

localhost:8080/v1/api/employee

# Company

 <li>With using Postman you can add data to Company with = localhost:8080/v1/api/company</li>
 <li>With using Postman you can list data from Company with = localhost:8080/v1/api/company </li>
 <li>With using Postman you can list data you want to Company with = localhost:8080/v1/api/company/{id}</li>
 <li>With using Postman you can delete specific data from Company with = localhost:8080/v1/api/company/{id}</li>
 <li>With using Postman you can update data you want from Company with = localhost:8080/v1/api/company/{id}</li>

# Employee
<li>With using Postman you can add data to Employee with = localhost:8080/v1/api/employee</li>
<li>With using Postman you can get all data from Employee with = localhost:8080/v1/api/employee</li>
<li>With using Postman you can specific data from Employee with = localhost:8080/v1/api/employee/{id}</li>
<li>With using Postman you can update data from Employee with = localhost:8080/v1/api/employee/{id}</li>
<li>With using Postman you can delete data from Employee with = localhost:8080/v1/api/employee/{id}</li>



