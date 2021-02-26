package com.example.book_management.util;

import java.security.MessageDigest;

/*
    @author Tktim
 */
public class MD5 {
    public static String generate(String key){
        //十六进制对应字符
        char[] hex = {'0','1','2','3','5',
        '6','7','8','9','A','B','C',
        'D','E','F'};
        try{
            byte[] btInpus = key.getBytes();
            //MD5的MessageDigest对象，并声明使用MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //更新摘要
            digest.update(btInpus);
            //获得密文
            byte[] md = digest.digest();
            //转换为十六进制字符
            int len = md.length;
            StringBuffer hexstr = new StringBuffer();
            for(int i = 0;i<len;i++){
                int high = (md[i] & 0xf0)>>4;//取高4位
                int low = (md[i] & 0x0f);//取低4位
                hexstr.append(hex[high]).append(hex[low]);
            }
            return hexstr.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
