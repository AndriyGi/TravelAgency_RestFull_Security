# TravelAgency_RestFull_Security

An educational project created with Spring Boot. The application use MySQL: 8.0.29.

About
The "TravelAgency" application allows to:

add humans and vauchers to the database; remove humans and vauchers from the database; make search of data using particular parameters (type of vauchers, name for humans etc) ; attach vauchers to humans; count total cost of the vauchers.

-Database migration implemented using the The Liquibase framework 
for managing automatic code delivery to  test and live environment, using dialect YAML.
-Spring Security Authentication Using Token implemented.

Launch
Before launch, make sure that your device support MySQL. Install software for database developing and administrating if necessary (PHP Adminer, Postgres, Workbench etc).

Check connection to the database.

Run Travel Agency Application.
The application will fill the database automatically for 3 humans and 3 vauchers for future testing:

Run TravelAgency file (TravelAgency/app/src/main/java/by/step/test/TestApplication.java).

For interaction with the application use Swagger UI: open your browser and enter localhost:8070/swagger-ui/index.html in the adress bar.

Or go to link: http://localhost:8070/swagger-ui/index.html

Edit configurations in your IDE if necessary.
