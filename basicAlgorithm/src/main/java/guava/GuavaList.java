package guava;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class GuavaList {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList();
        Lists.newArrayListWithCapacity(20);
        Lists.newArrayListWithExpectedSize(20);
    }
}
