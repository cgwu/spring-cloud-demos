<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
spring-boot-starter-actuator 包含[POST]/refresh端点的实现，用于实现客户端应用配置信息的重新获取与刷新。

<!-- Spring Cloud Bus -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
spring-cloud-starter-bus-amqp 包含[POST]/bus/refresh端点的实现，用于实现客户端应用配置信息的重新获取与刷新。
指定刷新范围:
某个实例
POST http://localhost:9001/bus/refresh?destination=feign-consumer:9001
feign-consumer的所有实例
POST http://localhost:9001/bus/refresh?destination=feign-consumer:**

使用kafka作为spring cloud bus:
1.创建topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
2.列出topic
bin/kafka-topics.sh --list --zookeeper localhost:2181
# 以下命令创建消息时，自动创建Topics.
3.消息生产者
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
4.消息消费者
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
