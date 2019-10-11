package com.clgg.mulThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sunshihui on 2019/9/10.
 * 闭锁
 * CountDownLatch是一个同步辅助类，在完成一组正在其他线程中执行的操作之前，允许一个或多个线程进行等待
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);

        try {
            LatchDemo latchDemo = new LatchDemo(latch);

            long start = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                new Thread(latchDemo).start();
            }

            latch.await();
            long end = System.currentTimeMillis();
            System.out.println("sssss:" + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }

        } finally {
            latch.countDown();
        }
    }
}

