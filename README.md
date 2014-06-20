ActiveDirectory
===============

java ldap Active Directory

使用java操作Active Directory

* 实现了以下功能：
1、校验用户是否已经存在
2、添加用户
3、删除用户
4、修改用户密码

* 证书：
实际使用时，需要证书
1、代码中使用以下代码加载证书
System.setProperty("javax.net.ssl.trustStore", keystore);   
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
2、首先由AD办法一个根证书，形如：*.cer
3、使用keytool将*.cer导出为*.keystore类型的文件供代码加载
4、加载证书有两种方式
(a) 如1所示，针对当前系统，每次使用时加载证书
(b) 使用keytool将*.cer写入到以下文件中：jre6\lib\security\cacerts