ActiveDirectory
===============

##ʹ��java��ldap����Active Directory

* ʵ�������¹��ܣ�
    * У���û��Ƿ��Ѿ�����
    * ����û�
    * ɾ���û�
    * �޸��û�����

* ��ȡ֤�飺
    * ʵ��ʹ��ʱ����Ҫ֤��
    * ������ AD �䷢һ����֤�飬���磺 *.cer
    * ʹ�� keytool �� *.cer ����Ϊ *.keystore ���͵��ļ����������
    
* ����֤�飬�����¼��ַ�ʽ
    * ʹ�� keytool �� *.cer д�뵽�����ļ��У� jre6\lib\security\cacerts
    * ��Ե�ǰϵͳ��ÿ��ʹ��ʱ����֤��
```Java
System.setProperty("javax.net.ssl.trustStore", keystore);
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
```