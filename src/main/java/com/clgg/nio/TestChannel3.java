package com.clgg.nio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by sunshihui on 2019/9/16.
 * 通道之间的数据传输,直接缓冲区
 * transferFrom（）
 * transferTo()
 */
public class TestChannel3 {
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{
            inChannel = FileChannel.open(Paths.get("C:\\Users\\sunshihui\\Desktop\\API\\JDK_API_1_6_zh_CN.CHM"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("C:\\Users\\sunshihui\\Desktop\\API\\JDK_API_1_6_zh_CN.CHM_copy1"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);

//            inChannel.transferTo(0,inChannel.size(),outChannel);

            outChannel.transferFrom(inChannel,0,inChannel.size());



        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
