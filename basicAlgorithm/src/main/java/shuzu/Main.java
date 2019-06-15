package shuzu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
       String s="{\"UID\":\"a6c08c88d4ae41249d0ac642f90a9185\",\"ORDERINFO\":{\"ORDERDATE\":\"2019-06-05 16:22:11\",\"ORDERNO\":\"190605162211191019697\"},\"VERSION\":\"1.0.2\",\"RESULTDATA\":[{\"JUDGEMENT\":\"是\"},{\"SMS_URL\":\"http://www.chinasafety.gov.cn/fw/xycx/hmdgg/201807/t20180726_219207.shtml\",\"BLACK_INTO_TIME\":\"2018-07-26\",\"BLACK_REASON\":\"采取隐蔽、欺骗或阻碍等方式逃避、对抗监管监察。\",\"SMS_MAJOR_PERON\":\"雷六生\",\"SMS_ADDR\":\"湖南省嘉禾县行廊镇定里村神岭庵\",\"SMS_SXJJ\":\"该企业为省政府批准保留的技改矿井，2018年4月该矿采用伪造采矿许可证骗取扩建项目安全设施设计批复，事情败露后，湖南煤矿安全监察局依法取消了其行政许可。\",\"BLACK_TYPE\":\"2\",\"SMS_PERSONID\":\"431024********1212\",\"SMS_DEPARTMENT\":\"湖南煤矿安监局\",\"SMS_BATCH\":\"2018年第三批\",\"ENTNAME\":\"嘉禾县定里黑金煤业有限公司\",\"SHXYDM\":\"91430000MA4L3A0W9J\",\"STATUS\":\"1\"}]}\n";

        Gson gson = new Gson();
        JsonObject j=gson.fromJson(s, JsonObject.class);
        System.out.println(j.get("RESULTDATA"));
        System.out.println(j.getAsJsonArray("RESULTDATA"));

    }
}
