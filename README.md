# Mentor on demand

## Dependencies

* Maven
* Java 8
* My sql
* Spring boot


## How to run

1. Maven. 
	* git clone https://github.com/samisofttech/MentorOnDemandBackend.git
	* cd to the mentor folder
	* cd to each folder
	* execute `mvn install`
	* execute `java -jar target/<jar-name>-0.0.1-SNAPSHOT.jar`

2. Spring boot.
	* git clone https://github.com/samisofttech/MentorOnDemandBackend.git
	* cd to the mentor folder
	* cd to each folder
	* execute `mvnw.cmd clean verify spring-boot:run`
	
3. Docker
	* git clone https://github.com/samisofttech/MentorOnDemandBackend.git
	* cd to the mentor folder
	* cd to each folder
	* create image - docker build -t <image_name>:v1
    * cd to docker/dev folder
	* execute 'docker-compose up -d'
	
## Usage 
1. Swagger UI ( this allow to test all api methods using the browser )
	* MentorProfile 	  - 	http://localhost:8958/swagger-ui.html
	* Payments 	  	  - 	http://localhost:8957/swagger-ui.html
	* Skill Technology  	  -	http://localhost:8960/swagger-ui.html
	* Traning                 -     http://localhost:8955/swagger-ui.html
	* Userprofile             -     http://localhost:8954/swagger-ui.html
	* Authentication	  -	http://localhost:8080/swagger-ui.html
	* Eureka		  -	http://localhost:9090/swagger-ui.html
	* Zuul		  	  -	http://localhost:8989/swagger-ui.html
	
## Consideration
1. Using jwt authentication mechanism.
2. Using microservices archietecture

