package dao;

import java.security.MessageDigest;

public class AddMD5 {
	public static String getMD5(String source){
        MessageDigest md5;
        StringBuilder sb=new StringBuilder();
        byte[] buf=source.getBytes();
        try{
            md5=MessageDigest.getInstance("MD5");
            md5.update(buf);
            byte[] data=md5.digest();
            for(byte b:data){
                sb.append(Integer.toHexString(b&0xff));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
