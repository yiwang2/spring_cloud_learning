# Spring Learning
## Register a simple service at Eureka
folder eurekaservicereg
## Register a simple service at Eureka and setup a consumer with ribbon LB
- folder ribbonresttemplate
- folder ribbonhystrix has circuit breaker hystrix added
## Register a simple service at Eureka and setup a consumer with Feign
- folder feign
- folder feincircuitbreaker has circuit breaker hystrix added
## Server config
- folder configserverandclient
- folder serverconfig is used as config property repo
## Service and consumer are using server config
folder spring-cloud-learning-lb-plus-config
## Cloud bus with rabbit mq
folder springcloudbuswithrabbitmq
## Spring + sleuth
- folder spring-cloud-learning-sleuth
- remember java -jar zipkin-server-2.10.1-exec.jar
## Multi Eureka server
- folder spring-cloud-learning-multi-eureka
- 2 peers, peer1 and peer2
- java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1 and java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
- check eureka server application yml
## Hystrix dashboard
folder spring-cloud-learning-hystrix-dashboard
## Hystrix + Turbine dashboard
folder spring-cloud-learning-hystrix-turbine
## Spring gateway
- spring-cloud-learning-gateway
- spring-cloud-learning-gateway-predicate
- spring-cloud-learning-gateway-filter
- spring-cloud-learning-gateway-limit
- spring-cloud-learning-gateway-reg
## Spring security
- folder spring-cloud-learning-gateway-security
- running under consul by command:  consul agent -dev -node machine
- running example:  POST http://http://localhost:8762/auth/login body: application/x-www-form-urlencoded with username and password. password is pass +salt username by md5 encoding
- test api GET api/demo
