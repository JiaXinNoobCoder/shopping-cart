#部署依赖
1.JDK17
2.Maven-3.9.4

#部署步骤
1.将源码拉到本地
2.使用maven插件可以直接执行package命令，默认会将打好的jar包放到target下面
3.命令行执行 java -jar {包名}.jar
4.查看服务是否成功启动，启动后默认监听8080端口
5.调用方式可以查看附带的api-docs.yaml接口文档，也可以直接访问http://localhost:8080/v3/api-docs查看

#服务调试
推荐使用api fox进行调试
也可以使用我分享的api在线调试地址: https://apifox.com/apidoc/shared-76ff2f44-3623-4f81-8a7f-1a65c68e406f 密码: j0lzaMJM

#设计说明
整体开发框架
spring-boot-3.3.4、spring-mvc、spring-data-jpa、junit5

#数据库
使用h2database内存数据库，基于JPA规范与数据库交互
服务启动成功后，可直接访问 http://localhost:8080/h2-console 查看数据库

配置文件
src/main/resources/application.properties

数据库初始化文件
src/main/resources/schema.sql 建表语句
src/main/resources/data.sql 初始化数据语句

PS：服务启动时会自动执行数据库初始化文件






