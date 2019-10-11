package com.clgg.mulThread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunshihui on 2019/9/11.
 * ReadWriteLock:读写锁
 * 写写/读写都需要互斥
 * 读读不需要互斥
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set(100);
            }
        },"写操作").start();

        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }


    }
}

class ReadWriteLockDemo{
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" : "+number);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" : "+number);
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
