package test;

import com.woodrice.ad.ActiveDirectoryUtil;

public class RemoveUser {

	public static void main(String[] args) {
		ActiveDirectoryUtil adUtil = new ActiveDirectoryUtil();
		
		if(adUtil.init()){
			boolean bRet = adUtil.removeUser("tu9");
			if(bRet){
				System.out.println("ɾ���û��ɹ�");
			}else{
				System.out.println("ɾ���û�ʧ��");
			}
		}
	}
}
