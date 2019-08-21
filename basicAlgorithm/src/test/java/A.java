public class A {
    // 静态块
    static {
        A c ;
        System.out.println(200);
        c = new A();
        i = 10;
    }

    public static int i;
    public int j;

    public A() {
        System.out.println(A.i);
        System.out.println(j);
    }

    public static void main(String[] args) {
        A a = null;
        System.out.println(100);
        a = new A();
        //A b = new A();
    }
}