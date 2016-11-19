# Struts-Spring-MyBatis
struts+spring+mybatis 框架搭建

###结构简介：
```
用struts2来控制方法调用和页面跳转，jps和Action通过strtus2的标签方式传值(OGNL)。
Action负责业务逻辑处理，Action调用Service接口，Service接口注入某个Service的实现，
在Service的实现里调用Dao来处理数据库。
而Dao是用Mybatis通过对应的xml文件来映射的,
且Action里的Service实现类注入和Service实现类里的Dao注入,Dao的Section注入，
都是通过Spring配置文件实现的。
```

![image](https://github.com/AndyFightting/Struts-Spring-MyBatis/blob/master/ssm.png)


