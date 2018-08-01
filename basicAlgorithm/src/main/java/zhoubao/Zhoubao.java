package zhoubao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Zhoubao {
    static String path="D:\\12345";

    public static void main(String[] args) throws Exception {

        //已交周报的人
        List<String> oklist=new Zhoubao().traverseFolder1(path);

        //生成人列表
       /* List<String> nameList=new ArrayList<String>();
        BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\jiaoz\\Desktop\\abc.txt")));
        String name=null;
        while((name = br.readLine())!=null){
            System.out.print("\""+name+"\""+",");
            nameList.add(name);
        }*/
        String [] nameArray ={"安书怡","林迎楠","吕丹丹","杨昭","杜青川","焦志军","石宏磊","杨佳佳","陈松松",
                "崔傅成","王小伟","周朝晨","汪浩","朱思韵","韩校","王姝","胡纯媛","缪双娇","雷星云","王瑜茜",
                "尹旭","吕星","王凯旋","胡文俭","闫蕾","张利","马龙","冯托阳","孙中石"};
        List<String> nameList= Arrays.asList(nameArray);



        System.out.println("以下是没交周报的人:");
        for (String name1:nameList
             ) {
            if(NoThisNam(oklist,name1)){
                //System.out.println("以下是没交周报的人");
                System.out.println("@"+name1);
            }

        }




    }
    //判断没交周报
    private static boolean NoThisNam(List<String> list, String name1) {

        for (String l:list
             ) {

            //System.out.println(name1);
            if(l.contains(name1))

            return false;
        }
        return true;
    }


    public List<String> traverseFolder1(String path) {
        List<String> listr=new ArrayList();
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                   // System.out.println("文件夹:" + file2.getAbsolutePath());
                    list.add(file2);
                    fileNum++;
                } else {
                   // System.out.println("文件:" + file2.getAbsolutePath());
                    listr.add(file2.getAbsolutePath());

                    folderNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                        fileNum++;
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        folderNum++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        //System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
        return listr;

    }

}
