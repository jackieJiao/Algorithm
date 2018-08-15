package java8;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition=lock.newCondition();
    public static void main(String[] args) throws InterruptedException {

        new Thread() {
            public void run() {
                new ReentrantlockTest().testMethod();
            }
        }.start();
        Thread.sleep(3000);
        System.out.println("to wakeup");
        condition.signal();






    }

    public void testMethod() {

        try {
            lock.lock();
            System.out.println("开始wait");
            condition.await();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()
                        + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }
}
