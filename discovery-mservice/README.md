Run the below services in the described sequence.

1. Eureka (ms-discovery):
main:
	java -jar ms-discovery-0.0.1-SNAPSHOT.jar
additional param:
	--server.port=3232 (Default 8761)

Example: java -jar ms-discovery-0.0.1-SNAPSHOT.jar --server.port=3232

2. Cloud Config (ms-cloud-config)
main:
	java -jar ms-cloud-config-0.0.1-SNAPSHOT.jar
additional params:
	--server.port=8888 (default)
	--eureka-url=http://localhost:8761/eureka/ (default)

Example: java -jar target/ms-cloud-config-0.0.1-SNAPSHOT.jar --server.port=7676 --eureka-url=http://localhost:3232/eureka/

3. Flight Plan Service (ms-flight-plan)
main:
	java -jar ms-flight-plan-0.0.1-SNAPSHOT.jar
additional params:
	--server.port=8080 (default)
	--eureka-url=http://localhost:8761/eureka/ (default)
VM params:
	-Dspring.profiles.active=dev (Default: default)
	
Example: 
	java -jar ms-flight-plan-0.0.1-SNAPSHOT.jar --server.port=8080 --eureka-url=http://localhost:8761/eureka/
Example (with profile): 
	java -jar -Dspring.profiles.active=dev ms-flight-plan-0.0.1-SNAPSHOT.jar --server.port=8080 --eureka-url=http://localhost:8761/eureka/