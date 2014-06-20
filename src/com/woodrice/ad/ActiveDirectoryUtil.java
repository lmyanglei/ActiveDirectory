package com.woodrice.ad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**  
 * ActiveDirectoryUtil
 * 
 * @Project: WRActiveDirectory
 * @Title: ActiveDirectoryUtil.java
 * @Package com.woodrice.ad
 * @Description: ActiveDirectory
 * @author lmyanglei@gmail.com
 * @date 2014-6-20 14:28:01
 * @Copyright: 2014 woodrice.com All rights reserved.
 * @version v1.0  
 */
public class ActiveDirectoryUtil {

	private LdapContext ldapContext = null;
	private DirContext dirContext = null;
	private String DC1 = null;
	private String DC2 = null;
	
    private String IP = null;
    private String PORT = null;
    private String adminName = null;
    private String adminPassword = null;
    private String URL = null;// �����û�ʱ������Ҫdomain��Ϣ����ѯ���޸�����ʱ����Ҫdomain��Ϣ

    private String replaceSuffix = null;// ��ȡDNʱ������С�,DC=domain,DC=com���������ڽ��в���ʱ����Ҫȥ��
	private String domainSuffix = null;
	private String mailSuffix = null;
    
	private int UF_ACCOUNTDISABLE = 0x0002;   
	private int UF_PASSWD_NOTREQD = 0x0020;   
	private int UF_PASSWD_CANT_CHANGE = 0x0040;   
	private int UF_NORMAL_ACCOUNT = 0x0200;   
	private int UF_DONT_EXPIRE_PASSWD = 0x10000;   
	private int UF_PASSWORD_EXPIRED = 0x800000;   

	/**
	 * �����û���
	 * 
	 * distinguishedName
	 * 
	 * @param userID �û���
	 * @return 
	 */
	public String getUserDN(String userID){
		String distinguishedName = "";
        String returnedAtts[] = { "objectClass","distinguishedName"};
        try { 
            String searchFilter = "(&(objectClass=user)(cn="+userID+"))";
            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            searchCtls.setReturningAttributes(returnedAtts);
            NamingEnumeration answer = ldapContext.search("", searchFilter,searchCtls);
            if (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				if (attrs != null) {
					Attribute attr = attrs.get("distinguishedName");
                    if(attr != null) {
                    	distinguishedName = (String)attr.get();
                    }
				}
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

		return distinguishedName;
	}
	
	/**
	 * �����Ƿ�����û�
	 * 
	 * @param userID �û���
	 * @return false=�����ڣ�true=����
	 */
	public boolean userIsExist(String userID){
		boolean returnValue = false;
		
		String distinguishedName = getUserDN(userID);
		
		if(null != distinguishedName && !"".equals(distinguishedName)){
			returnValue = true;
        }
		
		return returnValue;
	}
	
	/**
	 * config file
	 * 
	 * @param propertiesName
	 * @return
	 */
	public static Properties getProperties(String propertiesName){
		Properties prop = new Properties();
    	
    	String currpath = new File("").getAbsolutePath()+"\\"+propertiesName;
		try {
			InputStream in = new FileInputStream(new File(currpath));
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
    	
    	return prop;
	}
	
	public ActiveDirectoryUtil(){

	}
	
	/**
	 * init
	 * 
	 * @return true:success;false:fail
	 */
	public boolean init(){
		try {
			Properties properties = getProperties("LdapConfig.properties");
			
			// ����AD֤��
	        String keystore = new File("").getAbsolutePath()+"\\"+properties.getProperty("keystore");
	        String keyPassword = "changeit";
	        System.setProperty("javax.net.ssl.trustStore", keystore);   
	        System.setProperty("javax.net.ssl.trustStorePassword", keyPassword);
	        
			// ��������
	        adminName = properties.getProperty("adminName");
	        adminPassword = properties.getProperty("adminPwd");
	        
			DC1 = properties.getProperty("DC1");
	        DC2 = properties.getProperty("DC2");
	        
	        IP = properties.getProperty("IP");
	        PORT = properties.getProperty("PORT");
	        URL = "ldap://"+IP+":"+PORT +"/DC="+DC1+",DC="+DC2;
	        
	        replaceSuffix = ",DC="+DC1+",DC="+DC2;
	        domainSuffix = properties.getProperty("domainSuffix");
	        mailSuffix = properties.getProperty("mailSuffix");
	        
	        Properties env = new Properties();
	        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");// java.naming.factory.initial   
	        env.put(Context.SECURITY_AUTHENTICATION, "simple");// java.naming.security.authentication   
	        env.put(Context.SECURITY_PRINCIPAL,adminName);// java.naming.security.principal   
	        env.put(Context.SECURITY_CREDENTIALS, adminPassword);// java.naming.security.credentials   
	        env.put(Context.SECURITY_PROTOCOL, "ssl");   
	        env.put(Context.PROVIDER_URL, URL);// java.naming.provider.url   
	        
			ldapContext = new InitialLdapContext(env, null);
			
		} catch (NamingException e) {
			e.printStackTrace(System.err);
		}
		
		return (null != ldapContext?true:false);
	}

	/**
	 * remember to release it
	 */
	public void release(){
		try {
			if(null != ldapContext){
				ldapContext.close();
			}
		} catch (NamingException e) {
			e.printStackTrace(System.err);
		}
	}
}
