#部署依赖
1.JDK17
2.Maven-3.9.4



#部署步骤
1.将源码拉到本地
命令：git clone https://github.com/JiaXinNoobCoder/shopping-cart

2.使用习惯的编辑器打开项目，配置项目JDK为JDK17，语言级别为17，配置项目构建工具为Maven-3.9.4（不一定是这个版本，兼容JDK17就行）

3.使用maven插件可以直接执行package命令，默认会将打好的jar包放到target下面，在项目根目录下执行以下命令
命令：mvn clean package

4.打包成功后，会在target目录下面存放springboot-shopping-cart.jar，在项目根目录下执行以下命令
命令：java -jar ./target/springboot-shopping-cart.jar

5.查看服务是否成功启动，启动后默认监听8080端口

6.调用方式可以查看附带的api-docs.yaml接口文档，也可以直接访问http://localhost:8080/v3/api-docs查看

#服务调试
推荐使用api fox进行调试，也可以使用我分享的api在线调试地址: https://apifox.com/apidoc/shared-76ff2f44-3623-4f81-8a7f-1a65c68e406f 密码: j0lzaMJM

#设计说明
整体开发框架
spring-boot-3.3.4、spring-mvc、spring-data-jpa、junit5

#数据库
使用h2database内存数据库，基于JPA规范与数据库交互
服务启动成功后，可直接访问 http://localhost:8080/h2-console 查看数据库

#配置文件
src/main/resources/application.properties

#数据库初始化文件
src/main/resources/schema.sql 建表语句
src/main/resources/data.sql 初始化数据语句

#业务假设
1.假设调用时用户已经登录验证
2.调用时保证每个用户在数据库有且只有一个购物车

PS：服务启动时会自动执行数据库初始化文件






