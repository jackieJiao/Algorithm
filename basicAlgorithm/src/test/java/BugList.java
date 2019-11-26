import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BugList {
    public static void main(String[] args) {
        //List<String> strings = Arrays.asList("hello,world");
        List<String> strings=new ArrayList<>();
        strings.add("jiao");
        Object[] objects = strings.toArray();
        System.out.println(objects[0]);
        objects[0]=new Object();

    }
}
