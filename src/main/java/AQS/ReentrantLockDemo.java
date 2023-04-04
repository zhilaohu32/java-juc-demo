package AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FENGBIAO
 * @create 2023-04-04 10:11:47
 */
public class ReentrantLockDemo {

    private static volatile Integer number = 0;

    public static void main(String[] args) throws InterruptedException {
        // 非公平锁
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    for (int i = 0; i < 1000; i++) {
                        number++;
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    for (int i = 0; i < 1000; i++) {
                        number++;
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }
        },"线程B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    for (int i = 0; i < 1000; i++) {
                        number++;
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }
        },"线程C").start();
        Thread.sleep(3000);
        System.out.println("count = " + number);
    }
}
