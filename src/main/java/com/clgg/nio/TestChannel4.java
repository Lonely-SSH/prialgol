package com.clgg.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sunshihui on 2019/9/16.
 * 分散和聚集
 * 分散读取--Scattering Reads：将通道中的数据分散到多个缓冲区中
 * 聚集写入--Gathering Writes:将多个缓冲区的数据聚集到通道中
 */
public class TestChannel4 {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(100);
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer[] byteBuffers = {buffer,buffer1};

            //分散读取
            channel.read(byteBuffers);

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            System.out.println(new String(byteBuffers[0].array(),0,byteBuffers[0].limit()));
            System.out.println("---------------------");
            System.out.println(new String(byteBuffers[1].array(),0,byteBuffers[1].limit()));

            //聚集写入
            RandomAccessFile randomAccessFile1 = new RandomAccessFile("2.txt","rw");
            FileChannel channel1 = randomAccessFile1.getChannel();
            channel1.write(byteBuffers);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
