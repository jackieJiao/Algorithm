import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Dog> map = new HashMap();
        map.put("zhang", new Dog("zhangmao", 4));
        map.put("wang", new Dog("wanggou", 3));
        map.put("zhang", new Dog("zhanggou", 2));
        map.put("zhang", new Dog("zhangzhu", 1));
        map.put("wang", new Dog());

        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
    private static class Dog {
        private String name;
        private int age;

        public Dog() {
            this("default name", 0);
        }
        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return name + " " + age;
        }
    }


}
