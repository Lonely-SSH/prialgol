package com.clgg.nio;

import java.nio.ByteBuffer;

/**
 * Created by sunshihui on 2019/9/9.
 * 直接缓冲区和非直接缓冲区
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM内存中
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 *
 *
 */
public class TestNIO2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buffer.isDirect());
        System.out.println(buf.isDirect());
    }
}
