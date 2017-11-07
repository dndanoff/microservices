![](http://eventspro.bg/wp-content/uploads/2017/08/J2D_690x351psd-690x351.jpg)

# Example cloud native app developed for java2days

The application demonstrates microservice architecture that uses Spring Cloud and Netflix OSS components to achieve common patterns such as loadbalancing, high availability and etc.

# Technology stack

Spring Cloud and Netflix OSS

+ Spring Boot v_1.5.6
+ Spring Cloud v_Camden.SR5
  -  Discovery server - Eureka
  -  Config server
  -  API Gateway - Zuul
  -  Circuit Breaker - Hystrix, Hystrix Dashboard
  -  Spring Retry
  -  Sleuth, Zipkin - for tracing requests
  -  Feign
  -  OAuth2.0
+ Logback
+ Graylog
+ Swagger v_2.6.1 for testing and documentation purposes

# How to start the application

**There are 2 options:**
+ You can use STS to start each application as a Spring Boot App
+ You can pacakge each application to a jar file and after that start it from the command line with java -jar JAR_NAME.jar

**Order of projects**
1. Start Discovery service
2. Start Config service
3. Start all other services
4. Start API Gateway as the last service

# How to use the application

1. You must obtain valid token from the authentication service. To obtain the token invoke the oath/token endpoint with payload:
URL= http://localhost:8080/auth-mservice/oauth/token
Header= Authorization: Basic ZGVuaXM6c2VjcmV0
(Basic authentication credentials username=denis, password=secret)
Payload= grant_type=password&username=denis.danov@dreamix.eu&password=password
2. Copy your token
3. Call member service with the saved token
URL= http://localhost:8080/team-mservice/members
Header= Authorization: Bearer 9e9be35c-0bf7-424e-b3c4-108ccf842a7c
4. **Optional** If you want to test the external service copy team member id and invoke joke endpoint
URL= http://localhost:8080/team-mservice/members/296/joke
Header= Authorization: Bearer 9e9be35c-0bf7-424e-b3c4-108ccf842a7c