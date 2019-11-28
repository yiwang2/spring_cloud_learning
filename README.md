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
