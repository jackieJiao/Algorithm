package java8;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {
   /* private int a=0xDada_Cafe;
    private float b=0x1.fffffeP+127f;
    private float c=1996;
    private float d=1996.3;
    private int f=9999e2;
    private double g=33e2;
    private float h=0x1.fffep-12f;
    private float i=1.fffep-12f;
    private long p=0b1_1_1_0_1;
    private long q=0b1_1_1_0_2;
*/


    private static Lock lock = new ReentrantLock();
    private static Condition condition=lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        int a = 0xDada_Cafe;//小写十六进制（等价于0x002f）
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
        int b = 0x2F;//大写十六进制
        System.out.println(Integer.toBinaryString(b));





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
