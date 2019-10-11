package com.clgg.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sunshihui on 2019/9/9.
 * 通道
 * 用于源点与目标节点的连接，在NIO中负责缓冲区的数据传输
 * java.nio.channels.Channel
 * FileChannel              本地文件传输
 * SocketChannel            网络传输-TCP
 * ServiceSocketChannel     网络传输-TCP
 *             网络传输-UDP
 */
public class TestChannel {
    //非直接缓冲区
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileInputStreamChannel = null;
        FileChannel fileOutputStreamChannel = null;
        try {
            //创建输入输出流
            fileInputStream = new FileInputStream("C:\\Users\\sunshihui\\Desktop\\API\\common-system.jar");
            fileOutputStream = new FileOutputStream("C:\\Users\\sunshihui\\Desktop\\API\\common-system2.jar");

            //获取通道
            fileInputStreamChannel= fileInputStream.getChannel();
            fileOutputStreamChannel = fileOutputStream.getChannel();

            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while ((fileInputStreamChannel.read(buffer))!=-1){
                buffer.flip();
                fileOutputStreamChannel.write(buffer);
                buffer.clear();
            }
            System.out.println("完成传输！");

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(fileOutputStreamChannel != null){
                try {
                    fileOutputStreamChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStreamChannel != null){
                try {
                    fileInputStreamChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
