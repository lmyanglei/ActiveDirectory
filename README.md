ActiveDirectory
===============

ʹ��java��ldap����Active Directory

===========================

* ʵ�������¹��ܣ�
  *У���û��Ƿ��Ѿ�����<br>
  *����û�<br>
  *ɾ���û�<br>
  *�޸��û�����<br>

* ֤�飺
  *ʵ��ʹ��ʱ����Ҫ֤��<br>
  *������ʹ�����´������֤��
  System.setProperty("javax.net.ssl.trustStore", keystore);   
  System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
  *������AD�취һ����֤�飬���磺*.cer
  *ʹ��keytool��*.cer����Ϊ*.keystore���͵��ļ����������
  *����֤�������ַ�ʽ
    *(a) ��1��ʾ����Ե�ǰϵͳ��ÿ��ʹ��ʱ����֤��
    *(b) ʹ��keytool��*.cerд�뵽�����ļ��У�jre6\lib\security\cacerts