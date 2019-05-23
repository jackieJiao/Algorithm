package shuzu;

public class Student {
    private String name;
    private int score;
    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
    @Override
    public String toString(){
        return String.format("Student(name: %s,score:%d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr=new Array<>(3);
        arr.addLast(new Student("a",100));
        arr.addLast(new Student("b",50));
        arr.addLast(new Student("b",50));
        arr.addLast(new Student("b",50));
        System.out.println(arr);
    }
}
