package com.glyxybxhtxt.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesTra {
	public static String encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");            // ����AES��Key������
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);                                         // �����û�������Ϊ�������ʼ����(����һ�����Ϳ��Խ���)
 
            SecretKey secretKey = kgen.generateKey();                       // �����û����룬����һ����Կ
            byte[] enCodeFormat = secretKey.getEncoded();                   // ���ػ��������ʽ����Կ���������Կ��֧�ֱ��룬�򷵻�null
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");     // ת��ΪAESר����Կ
 
            Cipher cipher = Cipher.getInstance("AES");                      // ����������
            byte[] byteContent = content.getBytes("utf-8");                 // ����ת����ʽ
            cipher.init(Cipher.ENCRYPT_MODE, key);                          // ��ʼ��Ϊ����ģʽ��������
            byte[] encrypt = cipher.doFinal(byteContent);                   // ����
            String result = parseByte2HexStr(encrypt);                      // ��ֹ���룬ת������
 
            return result;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public static String decrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");            // ����AES��Key������
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);                                         // �����û�������Ϊ�������ʼ����(����һ�����Ϳ��Խ���)
 
            SecretKey secretKey = kgen.generateKey();                       // �����û����룬����һ����Կ
            byte[] enCodeFormat = secretKey.getEncoded();                   // ���ػ��������ʽ����Կ���������Կ��֧�ֱ��룬�򷵻�null
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");     // ת��ΪAESר����Կ
 
            Cipher cipher = Cipher.getInstance("AES");                      // ����������
            cipher.init(Cipher.DECRYPT_MODE, key);                          // ��ʼ��Ϊ����ģʽ��������
            byte[] results = cipher.doFinal(parseHexStr2Byte(content));     // ����
            return new String(results);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
	
	private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
	
	/*public static void main(String[] b){
		String a = AesTra.decrypt("58202929C74EBBF43AD679CC2A5EC5B5", "glmcbx176");
		String a = encrypt("4", "glmcbx176");
		System.out.println(a);
	}*/
}
