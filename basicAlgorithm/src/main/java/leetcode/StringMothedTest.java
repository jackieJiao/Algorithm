package leetcode;

public class StringMothedTest {

    public static void main(String[] args) {
        int a =new StringMothedTest().strStr("hello","ll");
        System.out.println(a);
    }
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        for (int i = 0; i+needle.length() <= haystack.length(); i++) {
            String tempString=haystack.substring(i,i+needle.length());
            if (tempString.equals(needle))
                return i;

        }
        return -1;
    }
}
