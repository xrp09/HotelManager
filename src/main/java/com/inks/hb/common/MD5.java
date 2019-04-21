package com.inks.hb.common;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 思路过程：
 * 1、str.getBytes()：将字符串转化为字节数组。字符串中每个字符转换为对应的ASCII值作为字节数组中的一个元素
 * 2、将字节数组通过固定算法转换为16个元素的有符号哈希值字节数组
 * 3、将哈希字节数组的每个元素通过0xff与运算转换为两位无符号16进制的字符串
 * 4、将不足两位的无符号16进制的字符串前面加0
 * 5、通过StringBuffer.append()函数将16个长度为2的无符号进制字符串合并为一个32位String类型的MD5码
 * 填充：将输入信息进行512求余分组，若不等于448，那么进行填充 1 和0，一个1 N个0。最后的数据就为N*512+448
    记录信息长度：将得到的信息用64位存储填充之前的信息长度，这样448+64=512，总信息为N+1个512
    以四个常数ABCD与每组512位进行函数运算，最后输出的结果就是4组32位的常数。拼接得到MD5码
 */

public class MD5 {

    public String getMD5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String strMD5 = null;
        try {
            strMD5 = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strMD5;
    }

    public boolean checkMD5(String newStr, String oldStr) {
        return getMD5(newStr).equals(oldStr);
    }
}
