package com.clgg.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by sunshihui on 2019/9/9.
 * 使用直接缓冲区完成文件的复制（内存映射文件）
 */
public class TestChannel2 {
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{
            inChannel = FileChannel.open(Paths.get("C:\\Users\\sunshihui\\Desktop\\API\\JDK_API_1_6_zh_CN.CHM"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("C:\\Users\\sunshihui\\Desktop\\API\\JDK_API_1_6_zh_CN.CHM_copy1"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);

            //内存映射文件  （只支持byteBuffer）
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接操作缓冲区的数据
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

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
