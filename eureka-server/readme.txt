mvn clean package -Dmaven.test.skip=true

java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s1
java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s2

配置eureka server参数参考：
org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean

配置eureka client参数参考：
org.springframework.cloud.netflix.eureka.EurekaClientConfigBean
