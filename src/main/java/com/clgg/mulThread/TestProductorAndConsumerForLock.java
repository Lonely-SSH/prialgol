package com.clgg.mulThread;

/**
 * Created by sunshihui on 2019/9/11.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunshihui on 2019/9/10.
 * 生产者和消费者案例
 * 生产者生产的东西给店员，
 * 添加数据的线程是生产者，删除数据的线程叫做消费者；
 * 如果生产者过快，数据丢失
 * 如果消费者过快，错误数据
 * 使用等待唤醒机制
 * 避免虚假唤醒问题，应该使用循环
 */
public class TestProductorAndConsumerForLock {
    public static void main(String[] args) {
        Clerk1 clerk1 = new Clerk1();
        Productor1 prodcutor1 = new Productor1(clerk1);
        Consumer1 consumer1 = new Consumer1(clerk1);
        new Thread(prodcutor1, "生产者A").start();
        new Thread(consumer1, "消费者B").start();
        new Thread(prodcutor1, "生产者C").start();
        new Thread(consumer1, "消费者D").start();

    }
}

class Clerk1 {
    private int product = 0;

    private Lock lock = new ReentrantLock();


    //进货
    public void get() {
        lock.lock();
        try {
            Condition condition = lock.newCondition();
            while (product >= 1) {
                System.out.println("产品已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            condition.signalAll();

        }finally {
            lock.unlock();
        }


    }

    //卖货
    public void sale() {
        lock.lock();
        try{
            Condition condition = lock.newCondition();
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}

class Productor1 implements Runnable {
    private Clerk1 clerk1;

    public Productor1(Clerk1 clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk1.get();
        }
    }
}

class Consumer1 implements Runnable {

    private Clerk1 clerk1;

    public Consumer1(Clerk1 clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk1.sale();
        }
    }
}
