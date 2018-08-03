package zhoubao;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class PoiWriteTest {
    public static void main(String[] args) throws IOException {

        Map<String, Map<String, List<ZBean>>> stringMapMap = PoiTest.generateMap();
        int count=0;

        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();


        //Iterator<String> iterator = stringMapMap.keySet().iterator();
        String [] a={"产品建设","内容采编","项目服务","综合管理"};
        Iterator<String> iterator= Arrays.asList(a).iterator();
        while (iterator.hasNext()){
            String thisfirst=iterator.next();
            Iterator<String> iterator1 = stringMapMap.get(thisfirst).keySet().iterator();
            while (iterator1.hasNext()){
                String thisSecond=iterator1.next();
                for (ZBean zbean:stringMapMap.get(thisfirst).get(thisSecond)
                     ) {
                    HSSFRow row=sheet.createRow(count);
                    HSSFCell cell=null;
                    //把bean写入该行
                    cell=row.createCell(0);
                    cell.setCellValue(zbean.first);
                    cell=row.createCell(1);
                    cell.setCellValue(zbean.second);
                    cell=row.createCell(2);
                    cell.setCellValue(zbean.resp);
                    cell=row.createCell(3);
                    cell.setCellValue(zbean.owner);
                    cell=row.createCell(4);
                    cell.setCellValue(zbean.isDone);
                    cell=row.createCell(5);
                    cell.setCellValue(zbean.future);

                    count++;


                }

            }
        }


        File file=new File("D://poi周报总结自动生成.xls");
        try {
            file.createNewFile();
            //将excel写入
            FileOutputStream stream= new FileOutputStream(file);
            workbook.write(stream);
            stream.close();
    } catch (IOException e) {
            e.printStackTrace();
        }
    }}
