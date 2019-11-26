package proxytest;

import org.jsoup.Jsoup;

import java.io.IOException;

public class jsoup {
    private static String url="https://auto.credit100.com/xhxyauto/upload/resources/video/2019/11/16/77740.mp4";

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            System.out.println(Jsoup.connect(url).get());
        }

    }

}
