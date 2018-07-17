import java.io.*;

public class ReadlineTest {
    public static void main(String[] args) throws IOException {
        File file=new File("H:\\mysql\\test.txt");
        BufferedReader  br = new BufferedReader(new FileReader(file));
        System.out.println(br.readLine());

    }
}
