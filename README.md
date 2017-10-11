![](http://eventspro.bg/wp-content/uploads/2017/08/J2D_690x351psd-690x351.jpg)

# Example cloud native app developped for java2days

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
+ Logback
+ Graylog
+ Swagger v_2.6.1 for testing and documentation purposes