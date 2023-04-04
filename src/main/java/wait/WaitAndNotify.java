package wait;

/**
 * @author FENGBIAO
 * @create 2023-03-28 17:38:47
 */
public class WaitAndNotify {

    private static volatile  Boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    while (flag == false){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + "监听到flag变化");
            }
        },"线程1").start();

        Thread.sleep(10000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    flag = true;
                    obj.notifyAll();
                }
            }
        },"线程2").start();
    }
}
