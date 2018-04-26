package sy.common;

import javax.crypto.Cipher;   
import javax.crypto.SecretKey;   
import javax.crypto.SecretKeyFactory;   
import javax.crypto.spec.DESKeySpec;   
import javax.crypto.spec.IvParameterSpec;  

import sy.frame.ConstantClass;





public class DES {

	private byte[] desKey;   
	  
    
    //解密数据   
    public static String decrypt(String message,String key) throws Exception {   
            
            byte[] bytesrc =convertHexString(message);      
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");       
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));      
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");      
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);      
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));   
                   
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);         
             
            byte[] retByte = cipher.doFinal(bytesrc);        
            return new String(retByte,"UTF-8");    
    }   
    
    public static String toHexString(byte b[]) {   
        StringBuffer hexString = new StringBuffer();   
        for (int i = 0; i < b.length; i++) {   
            String plainText = Integer.toHexString(0xff & b[i]);   
            if (plainText.length() < 2)   
                plainText = "0" + plainText;   
            hexString.append(plainText);   
        }   
           
        return hexString.toString();   
    } 
  
    public static byte[] toencrypt(String message, String key)   
            throws Exception {   
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");   
  
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));   
  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);   
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));   
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);   
  
        return cipher.doFinal(message.getBytes("UTF-8"));   
    }   
    
    public static String encrypt(String message, String key) throws Exception {
    	String str=toHexString(toencrypt(message, key)).toUpperCase(); 
    	return str;
    }
       
    public static byte[] convertHexString(String ss)    
    {    
    byte digest[] = new byte[ss.length() / 2];    
    for(int i = 0; i < digest.length; i++)    
    {    
    String byteString = ss.substring(2 * i, 2 * i + 2);    
    int byteValue = Integer.parseInt(byteString, 16);    
    digest[i] = (byte)byteValue;    
    }    
  
    return digest;    
    }    
  
  
//    public static void main(String[] args) throws Exception {   
////        String key = "jjoatjdb";   
////        String value="{'id':'adminabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890','loginName':'admin','ch':'中文乱码吗','url':'http://localhost:8080/liu_springmvc'}";   
////        //String jiami=java.net.URLEncoder.encode(value, "utf-8").toLowerCase();   
////           
//////        System.out.println("加密数据:"+jiami);   
////        String a=toHexString(encrypt(value, key)).toUpperCase(); 
////        System.out.println("加密数据:"+a); 
////           
////       
////        System.out.println("加密后的数据为:"+a);   
////        String b=java.net.URLDecoder.decode(decrypt(a,key), "utf-8") ;  
//        
//        
////        System.out.println("解密后的数据:"+b);   
//  
//    }   
  
       
    
	
	 
}