package java8;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/*
* 修改list的时候，复制一个出来
*public boolean add(T e) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {

        Object[] elements = getArray();

        int len = elements.length;
        // 复制出新数组

        Object[] newElements = Arrays.copyOf(elements, len + 1);
        // 把新元素添加到新数组里

        newElements[len] = e;
        // 把原数组引用指向新数组

        setArray(newElements);

        return true;

    } finally {

        lock.unlock();

    }
*
* */
public class CopyonWrite {


}
