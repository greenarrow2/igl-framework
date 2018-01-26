package com.igl.gov.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//http://tool.oschina.net/encrypt?type=2
public class EncryptUtils {

    public static String Encrypt(String strSrc,String encName) {
        MessageDigest md = null;
        String strDes=null;
        byte[] bt=strSrc.getBytes();
        try {
            if (encName==null||encName.equals("")) {
                encName="MD5";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes=bytes2Hex(md.digest());  //to HexString
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    private static String bytes2Hex(byte[]bts) {
        String des="";
        String tmp=null;
        for (int i=0;i<bts.length;i++) {
            tmp=(Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length()==1) {
                des+="0";
            }
            des+=tmp;
        }
        return des;
    }

    /**
     * MD5加密算法
     * @param passwod
     * @return
     */
    public static String getMD5(String passwod){
         return Encrypt(passwod,null);
    }

    /**
     * MD5加密算法
     * @param passwod
     * @return
     */
    public static String getSH1(String passwod){
        return Encrypt(passwod,"SHA1");
    }

    public static String getRandomSH1String(){
        return getSH1(StringUtils.getRandomString());
    }

    public static void main(String[] args) {
        System.out.println("args = [" + getSH1("geely@321") + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
        System.out.println("args = [" + getRandomSH1String() + "]");
    }
}


