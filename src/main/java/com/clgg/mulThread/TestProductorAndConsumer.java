package com.clgg.mulThread;

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
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor prodcutor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(prodcutor, "生产者A").start();
        new Thread(consumer, "消费者B").start();
        new Thread(prodcutor, "生产者C").start();
        new Thread(consumer, "消费者D").start();

    }
}

class Clerk {
    private int product = 0;

    //进货
    public synchronized void get() {
        while (product >= 1) {
            System.out.println("产品已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + ++product);
        this.notifyAll();

    }

    //卖货
    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + --product);
        this.notifyAll();

    }
}

class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}