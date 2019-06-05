package LinkedList;
import java.util.TreeSet;
//treeset 是红黑树、
public class Morse {
    public int uniqueMo(String[] words){
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet treeset=new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                res.append(codes[word.charAt(i)-'a']);
            treeset.add(res.toString());
        }
        return treeset.size();
    }

    public static void main(String[] args) {
        System.out.println(0+'b');
    }

}
