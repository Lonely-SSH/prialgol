package com.clgg.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunshihui on 2019/9/16.
 * 字符集
 * 编码：字符串-->字节数组
 * 解码：字节数组-->字符串
 */
public class TestChannel5 {
    public static void main(String[] args) throws Exception {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();
        int sum = 0;
        for (Map.Entry<String, Charset> entry : entries) {
            sum++;
            System.out.println(entry.getValue());
        }
        System.out.println("总数为："+sum);



        Charset charset = Charset.forName("UTF-8");
        //编码
        CharsetEncoder encoder = charset.newEncoder();
        //解码
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);

        charBuffer.put("孙世辉！");

        charBuffer.flip();
        ByteBuffer bBuffer = encoder.encode(charBuffer);

        for (int i = 0; i < 8; i++) {
            System.out.println(bBuffer.get());
        }

        bBuffer.flip();
        CharBuffer charBuffer1 = decoder.decode(bBuffer);

        System.out.println(charBuffer1.toString());
    }

}
