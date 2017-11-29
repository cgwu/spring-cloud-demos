mvn clean package -Dmaven.test.skip=true

java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s1
java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s2

ref: https://segmentfault.com/a/1190000008378268

配置eureka server参数参考：
org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean
server 所有配置说明：
/home/sam/.m2/repository/org/springframework/cloud/spring-cloud-netflix-eureka-server/1.3.5.RELEASE/spring-cloud-netflix-eureka-server-1.3.5.RELEASE.jar!/META-INF/spring-configuration-metadata.json

配置eureka client参数参考：
org.springframework.cloud.netflix.eureka.EurekaClientConfigBean
client所有配置说明：
/home/sam/.m2/repository/org/springframework/cloud/spring-cloud-netflix-eureka-client/1.3.5.RELEASE/spring-cloud-netflix-eureka-client-1.3.5.RELEASE.jar!/META-INF/spring-configuration-metadata.json

spring eureka 服务实例实现快速下线快速感知快速刷新配置解析
ref: http://blog.csdn.net/zhxdick/article/details/78560993
