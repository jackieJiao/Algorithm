package trie;
import java.util.TreeMap;
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next=new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }


    private Node root;
    private int size;

    public Trie() {
        root=new Node();
        size=0;
    }
    public int getSize(){
        return size;
    }
    //添加字符串,循环每一个字符插入trie树。
    public void insert(String word){
        Node cur=root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if (cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur=cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord= true;
            size++;
        }
    }


    //查询单词Word是否在trie中
    public boolean search(String word){
        Node cur=root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if (cur.next.get(c)==null)
                return false;
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    //前缀搜索
    public boolean startsWith(String prefix){
        Node cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }








}
