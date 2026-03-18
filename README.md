# Spring_demo

> 课堂笔记

#### 项目结构

![image-20260318120252280](C:\Users\Pys\AppData\Roaming\Typora\typora-user-images\image-20260318120252280.png)

#### 文件结构

源代码在java文件夹下

![image-20260317175916535](C:\Users\Pys\AppData\Roaming\Typora\typora-user-images\image-20260317175916535.png)

`resources`放置前端静态文件或者一些配置文件

`test`测试文件

`pom.xml`整个项目的配置文件

#### 运行项目

![image-20260317180523105](C:\Users\Pys\AppData\Roaming\Typora\typora-user-images\image-20260317180523105.png)

打开`Application.java`文件，运行即可

此时需要把jpa依赖注释掉，因为尚未创建数据库

#### rest api规范

##### 路径

路径又称"终点"(endpoint),表示API的具体网址。

在RESTful架构中，每个网址代表一种资源(resource),所以网址中不能有动词，只能有名词，而且所用的名词往往与数据库的表格名对应。

##### Http动词

·GET(SELECT):从服务器取出资源(一项或多项)。

·POST(CREATE):在服务器新建一个资源。

·PUT(UPDATE):在服务器更新资源(客户端提供改变后的完整资源)。

·PATCH(UPDATE):在服务器更新资源(客户端提供改变的属性)。

·DELETE(DELETE):从服务器删除资源。

#### 创建数据库表

##### 建库语句

```mysql
CREATE DATABASE test
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_general_ci;
```

进入test数据库：

```mysql
use test;
```

##### 建表语句

```mysql
CREATE TABLE student (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	age INT
);
```



#### 测试接口

put 选择 form-data

post 选择 JSON

#### 打包项目

```bash
mvn clean install
```

打包后可得到一个.jar包，直接用java运行:

```bash
java -jar {path}.jar

#修改端口
java -jar {path}.jar --server.port=8081
```
