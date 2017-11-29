mvn clean package install

reference:
打包命令: $ mvn clean package -Dmaven.test.skip=true
mvn install:install-file -Dfile=alipay-sdk-java20170829142630.jar -DgroupId=com.alipay -DartifactId=alipay-sdk-java -Dversion=20170829142630 -Dpackaging=jar
