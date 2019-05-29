package java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Liucaozuo {
    static class Student{
        /** 学号 */
        private long id;

        private String name;

        private int age;

        /** 年级 */
        private int grade;

        /** 专业 */
        private String major;

        /** 学校 */
        private String school;

        public Student(long id, String name, int age, int grade, String major, String school) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.major = major;
            this.school = school;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", grade=" + grade +
                    ", major='" + major + '\'' +
                    ", school='" + school + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        // 初始化
        List<Student> students = new ArrayList<Student>() {
            {

                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .map(student ->{student.setAge(80);return student;})
                .forEach(student-> System.out.println(student));


    }
}
