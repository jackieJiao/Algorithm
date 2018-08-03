package zhoubao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JxlTest {/*
    static String sourceFile ="D:\\tttttttttttttttttttt\\（以此为准）部门周工作汇总表-杨佳佳-0727.xls"; //源文件
    static String path="D:\\tttttttttttttttttttt";
    static List<ZBean> zBeanList=new ArrayList<ZBean>();


    public static void main(String[]args) throws IOException, BiffException {
        List<String> list=new Zhoubao().traverseFolder1(path);
        for (String s:list
             ) {
            System.out.println(s);
            List<ZBean> onelist = parseOnefile(s);
            zBeanList.addAll(onelist);



        }
        System.out.println(zBeanList);



    }


    private static List<ZBean> parseOnefile(String path) throws IOException, BiffException {
        Workbook book = Workbook.getWorkbook(new File("D:\\tttttttttttttttttttt\\7.23-7.27 部门周工作汇总表-个人版-  韩校.xlsx"));
        Sheet sheet =book.getSheet(0);

        int rows =sheet.getRows();

        int cols =sheet.getColumns();
        List<ZBean> zBeanList=new ArrayList<ZBean>();
        String con;
        for(int i=3;i<=rows-4;i++){
            if((con = sheet.getCell(3, i).getContents().trim() )!= null&&!con.equals("")){
                System.out.println(i+con);
                String first = null;
                String second = null;
                for (int j=i;j>0;j--){
                    String s;
                    if((s=sheet.getCell(2,j).getContents().trim())!=null&&!s.equals(""))
                    {
                        second=s;
                        break;
                    }

                }
                for (int j=i;j>0;j--){
                    String s;
                    if((s=sheet.getCell(1,j).getContents().trim())!=null&&!s.equals(""))
                    {
                        first=s;
                        break;
                    }

                }
                ZBean zBean = new ZBean(first, second, con, sheet.getCell(4, i).getContents().trim(),
                        sheet.getCell(5, i).getContents().trim(),
                        sheet.getCell(5, i).getContents().trim()
                );
                System.out.println(zBean);
                zBeanList.add(zBean);
            }

        }
        return zBeanList;

    }
*/
}