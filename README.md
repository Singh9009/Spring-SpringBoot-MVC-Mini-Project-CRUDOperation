There are certain steps that I have followed to develop this Mini project.

step 1) create spring starter project by adding the following dependencies:
        a) Spring web MVC
        b) Lombok
        c) Spring data JPA
        d) Oracle Driver
        e) Tomcat Embedded Jasper
        f) JSTL

Add some extra dependencies to pom.xml by collecting from mvnrepository.com 

Step 2) create the following packages in the project:

        in.spring.model
        in.spring.controller
        in.spring.repository
        in.spring.service
        
Step 3) Add the following entries in application.properties file.

       For DataSource configuration
       For JPA-Hibernate properties
       For View Resolver
       For Embedded server ports
       For Context path of WebApplication by running embedded server.

Step 4) Create images folder and WEB-INF and inside WEB_INF create pages(not a standard folder) folder folder under 
        src/main/webapp folder to save project related images and to place view components.

Step 5) Create java class EmployeeOperationController under in.spring.controller package and write the following code.

Step 6) create home.jsp folder under WEB_INF/pages folder and write the following code.

Step 7) Develop Model/entity class and map with respected database table.

Step 8) Develop repository interace for Employee class.

Step 9) Develop the following class in their respective package and write the code.


