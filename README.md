ActiveDirectory
===============

##ʹ��java��ldap����Active Directory

* ʵ�������¹��ܣ�
    * У���û��Ƿ��Ѿ�����
    * ����û�
    * ɾ���û�
    * �޸��û�����

* ֤�飺
    * ʵ��ʹ��ʱ����Ҫ֤��
    * ������ʹ�����´������֤��
```Java
System.setProperty("javax.net.ssl.trustStore", keystore);
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
```
ceshi
    * ������AD�취һ����֤�飬���磺*.cer
    * ʹ��keytool��*.cer����Ϊ*.keystore���͵��ļ����������
    * ����֤�������ַ�ʽ
        * ��1��ʾ����Ե�ǰϵͳ��ÿ��ʹ��ʱ����֤��
        * ʹ��keytool��*.cerд�뵽�����ļ��У�jre6\lib\security\cacerts