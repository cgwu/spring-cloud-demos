mvn clean package -Dmaven.test.skip=true

java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s1
java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=s2
