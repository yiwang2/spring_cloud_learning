# Server Config example
- config server is at module config-server
- config client will talk to config server to fetch config properties
- config repo is at https://github.com/yiwang2/spring_cloud_learning server config

# property file name trick

- example of spring application property 

```
spring.application.name=config-client
spring.cloud.config.label=master
spring.cloud.config.profile=dev
```
- the config property file name will be as follow formate 
```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```
