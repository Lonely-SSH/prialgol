package com.clgg.nio;

import java.nio.ByteBuffer;

/**
 * Created by sunshihui on 2019/9/9.
 */
public class TestNIO {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("---------------------------------");


        String string = "asdfghjkl";
        buffer.put(string.getBytes());

        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("---------------------------------");


        //切换到数据读取模式
        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("---------------------------------");

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("---------------------------------");


        //可重复读数据
        buffer.rewind();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println("---------------------------------");

        //清空缓冲区，但是缓冲区的数据还在，只是被标记为被遗忘状态
        buffer.clear();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println((char)buffer.get());

        //mark():标记，记录position的位置
        //reset():回到上个标记的位置
        //hasRemaining():判断缓冲区是否还有剩余的数据

    }
}
