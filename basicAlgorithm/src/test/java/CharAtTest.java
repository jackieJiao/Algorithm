import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class CharAtTest
{
    public static void main(String[] args) {
        System.out.println('b');
        char[] ch={'a','A','b','B'};
        System.out.println();


    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet set=new TreeSet();
        for(String word:words){
            StringBuilder morse=new StringBuilder();
            for(int i=0;i<word.length();i++){
                morse.append(codes[word.charAt(i)-'a']);
            }
            set.add(morse);
        }

        return set.size();

    }
}
