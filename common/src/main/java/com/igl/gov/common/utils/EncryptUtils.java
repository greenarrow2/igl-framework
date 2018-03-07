package com.igl.gov.common.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
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

    public  static String getBase64Encode(String param){
        if(StringUtils.isEmpty(param)){
            return null;
        }
        String encode = null;
        try {
            encode =  Base64.encodeBase64String(param.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

    public  static String getBase64Decode(String param){
        if(StringUtils.isEmpty(param)){
            return null;
        }
        String decode = null;
        try {
            decode = new String(Base64.decodeBase64(param),"UTF-8");
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decode;
    }
    /**
     * 得到hex值
     * @param param
     * @return
     */
   public  static String getHexEncode(String param){
        if(StringUtils.isEmpty(param)){
            return null;
        }
       String encode = null;
       try {
         encode =  Hex.encodeHexString(param.getBytes("UTF-8"));
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       return encode;
   }

    public  static String getHexDecode(String param){
        if(StringUtils.isEmpty(param)){
            return null;
        }
        String decode = null;
        try {
            decode = new String(Hex.decodeHex(param),"UTF-8");
        }   catch (DecoderException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decode;
    }

    public static void main(String[] args) {


            String code = "{\n" +
                    "  \"id\": 1,\n" +
                    "  \"mobile\": \"13325914005\",\n" +
                    "  \"roleIds\": \"1\",\n" +
                    "  \"orgIds\": \"1,2\",\n" +
                    "}";
            System.out.println(code);
       /*   String  encode =  Base64Utils.encodeToString(code.getBytes("UTF-8"));
            System.out.println(encode);
         byte [] aa =  Base64Utils.decodeFromString(encode);
            System.out.println(new String(aa,"UTF-8"));*/
       String a1 =   getHexEncode(code);
        System.out.println(a1);
        String a2 = getHexDecode(a1);
        System.out.println(a2);
      /*  String a1 =   getBase64Encode(code);
        System.out.println(a1);
        String a2 = getBase64Decode(a1);
        System.out.println(a2);*/

    }
}


