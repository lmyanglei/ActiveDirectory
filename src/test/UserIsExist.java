package test;

import com.woodrice.ad.ActiveDirectoryUtil;

public class UserIsExist {

	public static void main(String[] args) {
		ActiveDirectoryUtil adUtil = new ActiveDirectoryUtil();
		
		if(adUtil.init()){
			boolean bRet = adUtil.userIsExist("testuser");
			if(bRet){
				System.out.println("�û�����");
			}else{
				System.out.println("�û�������");
			}
		}
	}
}
