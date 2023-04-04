package synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * 跟踪了解 Synchronize 的不同锁状态
 * @author FENGBIAO
 * @create 2023-03-28 10:55:21
 */
public class SynchronizeDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object obj = new Object();
        obj.getClass();
        System.out.println("上锁前:");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+"\n"+ClassLayout.parseInstance(obj).toPrintable());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"线程1").start();


//        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"\n"+ClassLayout.parseInstance(obj).toPrintable());
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+"\n"+ClassLayout.parseInstance(obj).toPrintable());
                }
            }
        },"线程2").start();
    }
}
