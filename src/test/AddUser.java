package test;

import com.woodrice.ad.ActiveDirectoryUtil;

public class AddUser {

	public static void main(String[] args) {
		ActiveDirectoryUtil adUtil = new ActiveDirectoryUtil();
		
		if(adUtil.init()){
			boolean bRet = adUtil.addUser("tu9", "tu9", "123.com", "00000008");
			if(bRet){
				System.out.println("����û��ɹ�");
			}else{
				System.out.println("����û�ʧ��");
			}
		}
		
		adUtil.release();
	}
}
