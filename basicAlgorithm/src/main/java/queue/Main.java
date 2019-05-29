package queue;

import java.util.Random;

public class Main {
    /*
    * q 运行opcount个操作所需时间
    *
    * */
    private static double testQueue(Queue<Integer> q,int opCount){
        long start=System.nanoTime();
        Random random=new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            q.dequeue();

        return (System.nanoTime()-start)/1000000000.0;

    }
    public static void main(String[] args) {
        int opCount=100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        System.out.println(testQueue(arrayQueue, opCount));

        LoopQueue<Integer> objectLoopQueue = new LoopQueue<>();
        System.out.println(testQueue(objectLoopQueue, opCount));


    }

}
