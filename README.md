ActiveDirectory
===============

java ldap Active Directory

ʹ��java����Active Directory

* ʵ�������¹��ܣ�
1��У���û��Ƿ��Ѿ�����
2������û�
3��ɾ���û�
4���޸��û�����

* ֤�飺
ʵ��ʹ��ʱ����Ҫ֤��
1��������ʹ�����´������֤��
System.setProperty("javax.net.ssl.trustStore", keystore);   
System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
2��������AD�취һ����֤�飬���磺*.cer
3��ʹ��keytool��*.cer����Ϊ*.keystore���͵��ļ����������
4������֤�������ַ�ʽ
(a) ��1��ʾ����Ե�ǰϵͳ��ÿ��ʹ��ʱ����֤��
(b) ʹ��keytool��*.cerд�뵽�����ļ��У�jre6\lib\security\cacerts