package zhoubao;

import java.util.Map;

public class ZBean {
    public  String first;
    public  String second;
    public  String resp;
    public  String owner;
    public  String isDone;
    public  String future;

    public ZBean(String first, String second, String resp, String owner, String isDone, String future) {
        this.first = first;
        this.second = second;
        this.resp = resp;
        this.owner = owner;
        this.isDone = isDone;
        this.future = future;
    }

    @Override
    public String toString() {
        return "ZBean{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", resp='" + resp + '\'' +
                ", owner='" + owner + '\'' +
                ", isDone='" + isDone + '\'' +
                ", future='" + future + '\'' +
                '}';
    }
}
