# TravelAgency_RestFull_Security

An project created with Spring Boot. 
The application use MySQL: 8.0.29.

# About
The "TravelAgency" application allows to:

add humans and vouchers to the database; remove humans and vouchers from the database; make search of data using particular parameters (type of vouchers, name for humans etc.) ; attach vouchers to humans; count total cost of the vouchers.

-Exception handling to maintain the normal flow of the application implemented.

- Simple Logging Facade for Java (SLF4J) implemented as a facade for different logging frameworks 
   (e.g.,  java.util.logging, logback, Log4j).
   
-Database migration implemented using the “Liquibase” framework 
  for managing automatic code delivery to test and live environment, using dialect YAML.
  
-Token-based API authentication with Spring and JWT implemented.


# Launch
Before launch, make sure that your device support MySQL. 
Install software for database developing and administrating if necessary (PHP Adminer, Postgres, Workbench etc).
1.	Check connection to the database.
2.	Run TaxiDepotApplication.

If the application doesn't fill the database automatically:
1.	Run dump.sql file (taxi_spring\api\src\main\resources\sql\dump.sql) 
              to create the database and to fill it with data.
2.	Run TravelAgency file (TravelAgency/app/src/main/java/by/step/test/TestApplication.java)

The application will fill the database automatically for 3 humans and 3 vouchers for future testing:


For interaction with the application use Swagger UI: 
open your browser and enter localhost:8070/swagger-ui/index.html    in the address bar.

Or go to link: http://localhost:8070/swagger-ui/index.html

# Edit configurations in your IDE if necessary.
