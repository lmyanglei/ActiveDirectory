ActiveDirectory
===============

使用java的ldap操作Active Directory

===========================

* 实现了以下功能：
  *校验用户是否已经存在<br>
  *添加用户<br>
  *删除用户<br>
  *修改用户密码<br>

* 证书：
  *实际使用时，需要证书<br>
  *代码中使用以下代码加载证书
  System.setProperty("javax.net.ssl.trustStore", keystore);   
  System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
  *首先由AD办法一个根证书，形如：*.cer
  *使用keytool将*.cer导出为*.keystore类型的文件供代码加载
  *加载证书有两种方式
    *(a) 如1所示，针对当前系统，每次使用时加载证书
    *(b) 使用keytool将*.cer写入到以下文件中：jre6\lib\security\cacerts