
Objective and Tools
PartA:
1.	Demo of REST apis to get search file in directory or subdirectory ( user will decide depth). 
2. Get files information from the configured MIME type
3. JSP page to let user choose from front end too. 
4. Swagger,AOP, custome exception , Java8 feature in demo.
Used: Springboot, Hibernate, File-IO , InteliJ, Maven,Postman
	

PART-1
Run project 
clean spring-boot:run -Dspring.profiles.active="dev" test -Dtest=com.yogi.testrunner.CucumberRunner
Setting the Project and dev-env
a.	Use maven compiler plugin to set J1.8 while creating a maven Project in IntelliJ 
b.	Create controller-model-view package
c.	Insert commonly used dependencies such as spring, guava, joda-time, commons, junit , poi, mysql ( enable auto import in IntelliJ)
d.	Make spring-boot-starter-parent in parent tag and use property for version

Project Skelton
Creating the controller, service, request response structure (I skipped, repository, business delegate layer)
 

e.	Create the Base controller in common so it can be utilize by all controllers
f.	Map the @RestController.
g.	Provide the property using @PropertySource, the same can achieved by value annotation of spring.
@PropertySource(value = {"classpath:properties.${ENV_SYSTEM:dev}/props-for-api-tests.properties", "classpath:properties.${ENV_SYSTEM:dev}/props-for-ui-tests.properties"})

h.	Provide the request mapping 
i.	http://<Server:port> /v1/api/scanfiles
ii.	method.POST
i.	@Autowired Environment to gte property and pass the property while creating the bean 
Create logic:
API #1:Retreive the files based on mimeTypes provided.
Case 1: If no MimeTypes are provided it will return the default files of mimeTypes excel & csv.
	Case 2: If mimeTypes are not valied,it will return with the status error.
Case 3: It will return the files with mimeTypes from the user input(multiple mimeTypes are separated by comma)
 

 

API #2:Retrieves all the files irrespective of the mimeTypes.
Case 1: Retrieves all the files in the preconfigured directory.
Case 2: Retrieves all the files in the directory specified
 
 
Code WalkThrough:
 
Control flow will be from the controller(com.yogi.api.controller) to the service layer(com.yogi.api.service).
controller & service layers will make use of util (com.yogi.api.util) classes for processing the code and 
The controller will return response (com.yogi.api.dto.BaseResponseDto) with the status field and the result.
Swagger is integrated and can be accessed at below url:
http://localhost:8080/swagger-ui.html
UI for API #1:
http://localhost:8080/scanner.html

Preconfigured properties can be found under application-dev.yml
directory.toscan: C:\Automation\vehicleManagement
supported.mime.types: 
valied.mime.types: 

 

