文件编码转换：
$ native2ascii feign-consumer-dev.properties feign-consumer-test.properties

/{application}/{profile}[/{label}]
http://s1:7001/feignconsumer/dev/
http://s1:7001/demo/dev/branch2.0

/{label}/{application}-{profile}.properties
http://s1:7001/feignconsumer/feignconsumer-dev.properties

