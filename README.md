ActiveDirectory
===============

##ʹ��java��ldap����Active Directory

* ʵ�������¹��ܣ�
    * У���û��Ƿ��Ѿ�����
    * ����û�
    * ɾ���û�
    * �޸��û�����

* ����֤�飬������ʹ�����´������֤�飺

```Java
System.setProperty("javax.net.ssl.trustStore", keystore);
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
```

* ��ȡ֤�飺
    * ʵ��ʹ��ʱ����Ҫ֤��
    * ������AD�취һ����֤�飬���磺*.cer
    * ʹ��keytool��*.cer����Ϊ*.keystore���͵��ļ����������
    * ����֤�������ַ�ʽ
        * ������ʾ����Ե�ǰϵͳ��ÿ��ʹ��ʱ����֤��
        * ʹ��keytool��*.cerд�뵽�����ļ��У�jre6\lib\security\cacerts