package com.clgg.mulThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunshihui on 2019/9/6.
 *
 * 一、i++的原子性问题
 *      int i= 10
 *      i = i++;//10
 *
 *      int temp = i;
 *      i = i+1;
 *      i = temp;
 *
 * 二、原子变量：java.util.atomic
 *      1.volatile 保证内存可见性
 *      2.采用了CAS算法  Compare-And-Swap
 *      V-内存 A-预估值 B-更新值
 *      当V=A时，才把B的值赋给V，否则不做任何操作
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }



}

class AtomicDemo implements Runnable{

//    private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
//        return serialNumber++;
        return serialNumber.getAndIncrement();
    }


}
