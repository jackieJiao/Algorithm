package zhoubao;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

public class JxlTest {
    static String sourceFile ="C:\\Users\\jiaoz\\Desktop\\img\\123.xls"; //源文件

    public static void main(String[]args)
    {
        try

        {

            Workbook book = Workbook.getWorkbook(new File(sourceFile));



            //0代表第一个工作表对象

            Sheet sheet =book.getSheet(0);

            int rows =sheet.getRows();

            int cols =sheet.getColumns();

            for(int i=3;i<=rows-4;i++){

            }





            System.out.println(rows+"jjjjj"+cols+"jsdfajkjlk");

            System.out.println(sheet.getCell(3,rows-4).getContents().trim());
            System.out.println(sheet.getCell(4,4).getContents().trim());
            System.out.println(sheet.getCell(4,5).getContents().trim());
            System.out.println(sheet.getCell(2,1).getContents().trim());

            String colname1 =sheet.getCell(0, 0).getContents().trim();

            String colname2 =sheet.getCell(1, 0).getContents().trim();

            String colname3 =sheet.getCell(2, 0).getContents().trim();

            System.out.println(colname1+","+colname2+","+colname3);

            for (int z = 1; z <rows; z++)

            {

                //0代表列数，z代表行数

                String name =sheet.getCell(0, z).getContents();

                String sex =sheet.getCell(1, z).getContents();

                String ID =sheet.getCell(2, z).getContents();

                System.out.println(name+","+sex+","+ID);

            }

        }

        catch(Exception e)

        {

            e.printStackTrace();

        }

    }

}