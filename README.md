# Longest Common Substring

## Overview

The LongestCommonSubstring is a microservice responsible for identifying the longest common substring in the given list of strings. This is a self contained component designed to identify and share the longest common substring.

## Usage
 Install the application with mvn clean install spring-boot:run and can test through below ways
- Accessing through http://localhost:9080/
- Through Soap-ui or postman
    - Sample payload
    Http Operation: POST
    Headers: N/A
    {  
    	"setOfStrings": [{"value": "comacast"},
    	{"value": "comacastic"},
    	{"value": "broadcastercoma"}
    	] 
    }




### Prerequisites


```
- JDK 1.8
- Maven
- Java IDE - Eclipse or IntelliJ, STS
```


## Installing

The service written in Java leveraging the Spring Boot framework. Developers can use any IDE to view and/or modify the code. 

```
mvn clean install spring-boot:run
```
in the project folder to build and deploy the code with built-in tomcat.

## Building

The following Maven command will clean the target directory, compile and test the application.


```
mvn clean install
```

## Running Tests

**All code must have test coverage!**

```
mvn test
```

## Deployment

### Tomcat Embedded Server

Spring Boot allows us to easily run the LongestCommonSubstring service in an embedded Tomcat contatiner. All program and application server dependencies are packaged in the JAR file constructed using the following:

```
mvn clean install spring-boot:run
```
The executable JAR is written to 

```
${PROJECT_DIR}/target/LongestCommonSubstring-<version>.jar
```

This can now be run on any machine with a JVM installed.

```
java -jar LongestCommonSubstring-<version>.jar
```

Or, can be deployed to any other application server like Wildfly, Websphere, Weblogic.

### Application Properties Reference



***
System
***
- maintenance-mode=false
- server.port=9080
- log-external-calls=true
- ignore-ssl-cert-warning=true

##Pending
- AsyncResponse Integration
- Circuit breaker integration
- Logging request and responses
- Client side validations
- Test classes for rest api testing and other flows
- Swagger integration
- mvnw integration

## Authors

* **Venugopal Kommineni** - *Development* 


## Acknowledgments

* Thanks to the Comcast Technology team!
