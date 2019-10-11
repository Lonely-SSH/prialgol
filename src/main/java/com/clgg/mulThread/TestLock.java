package com.clgg.mulThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunshihui on 2019/9/10.
 * 用于解决多线程问题的三种方法
 * 1.同步代码块      Synchronized--隐式锁
 * 2.同步方法        Synchronized--隐式锁
 * 3.同步锁          Lock--显式锁，需要lock()上锁，需要通过unlock()释放锁  更加灵活，更加高效的解决多线程问题
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1= new Thread(ticket,"一号窗口");
        Thread t2= new Thread(ticket,"二号窗口");
        Thread t3= new Thread(ticket,"三号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(tick>0){
            lock.lock();
            try{
                if(tick>0){
                    try {
                        Thread.sleep(200);
                    }catch (Exception e){

                    }

                    System.out.println(Thread.currentThread().getName()+"完成售票，余票为："+--tick);
                }
            }finally {
                lock.unlock();
            }


        }
    }
}