package test;

import com.woodrice.ad.ActiveDirectoryUtil;

public class ModifyPassword {

	public static void main(String[] args) {
		ActiveDirectoryUtil adUtil = new ActiveDirectoryUtil();
		
		if(adUtil.init()){
			boolean bRet = adUtil.modifyPassword("tu11", "1234.com", "12345.com");
			if(bRet){
				System.out.println("�޸�����ɹ�");
			}else{
				System.out.println("�޸�����ʧ��");
			}
		}

		adUtil.release();
	}
}
