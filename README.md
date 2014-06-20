ActiveDirectory
===============

##使用java的ldap操作Active Directory

* 实现了以下功能：
    * 校验用户是否已经存在
    * 添加用户
    * 删除用户
    * 修改用户密码

* 获取证书：
    * 实际使用时，需要证书
    * 首先由 AD 颁发一个根证书，形如： *.cer
    * 使用 keytool 将 *.cer 导出为 *.keystore 类型的文件供代码加载
    
* 加载证书，有以下几种方式
    * 使用 keytool 将 *.cer 写入到以下文件中： jre6\lib\security\cacerts
    * 针对当前系统，每次使用时加载证书
```Java
System.setProperty("javax.net.ssl.trustStore", keystore);
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
```