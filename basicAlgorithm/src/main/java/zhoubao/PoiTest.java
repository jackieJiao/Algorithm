package zhoubao;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PoiTest {
    static String path="D:\\tttttttttttttttttttt";
    static List<ZBean> zBeanList=new ArrayList<ZBean>();
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    private static File file;
    private static FileInputStream is;


    public static void main(String[]args) throws IOException {
        generateMap();
    }

    public static Map<String, Map<String,List<ZBean>>> generateMap() throws IOException {
        List<String> list=new Zhoubao().traverseFolder1(path);
        for (String s:list
                ) {
            System.out.println(s);
            List<ZBean> onelist = parseOnefile(s);
            zBeanList.addAll(onelist);
        }
        System.out.println(zBeanList);

        List<Tar> targetlist=new ArrayList();

        Map<String,Map<String,List<ZBean>>> map=new HashMap();
        for (ZBean z:zBeanList
                ) {
            if(map.containsKey(z.first)){
                if (map.get(z.first).containsKey(z.second)){
                    map.get(z.first).get(z.second).add(z);
                }else{
                    map.get(z.first).put(z.second,new ArrayList<ZBean>());
                    map.get(z.first).get(z.second).add(z);
                }

            }else {
                map.put(z.first,new HashMap<String, List<ZBean>>());
                map.get(z.first).put(z.second,new ArrayList<ZBean>());
                map.get(z.first).get(z.second).add(z);
            }
        }
        return map;
    }

    private static List<ZBean> parseOnefile(String path) throws IOException {

        Workbook workbook = getWorkBook(path);
        Sheet sheet =workbook.getSheetAt(0);
        int rows =sheet.getLastRowNum();
        List<ZBean> zBeanList=new ArrayList<ZBean>();
        String con;
        for(int i=3;i<=rows-4;i++){
            if(sheet.getRow(i).getCell(3)!=null){
                if((con = sheet.getRow(i).getCell(3).toString() )!= null&&!con.equals("")){
                    System.out.println(i+con);
                    String first = null;
                    String second = null;
                    for (int j=i;j>0;j--){
                        String s;
                        if((s=sheet.getRow(j).getCell(2).toString())!=null&&!s.equals(""))
                        {
                            second=s;
                            break;
                        }
                    }
                    for (int j=i;j>0;j--){
                        String s;
                        if((s=sheet.getRow(j).getCell(1).toString())!=null&&!s.equals(""))
                        {
                            first=s;
                            break;
                        }

                    }
                    Cell cell = sheet.getRow(i).getCell(6);
                    String riqi=null;
                    String get=(sheet.getRow(i).getCell(6)==null)?"无":sheet.getRow(i).getCell(6).toString();
                    if(get.startsWith("43")){
                        int i1 = Integer.parseInt(get.substring(0,5));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        Calendar cd = Calendar.getInstance();
                        try {
                            cd.setTime(sdf.parse("1899-12-30"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        cd.add(Calendar.DATE, 43343);//增加一天
                        riqi=sdf.format(cd.getTime());

                    }else if(cell.getCellType()==0){
                        DecimalFormat df = new DecimalFormat("0");
                        String cellText = df.format(cell.getNumericCellValue());
                        riqi=cellText;

                    }
                    else {
                        riqi=get;
                    }
                    ZBean zBean = new ZBean(first, second, con, (sheet.getRow(i).getCell(4)==null)?"无":sheet.getRow(i).getCell(4).toString(),
                            (sheet.getRow(i).getCell(5)==null)?"无":sheet.getRow(i).getCell(5).toString(),
                            riqi
                    );
                    System.out.println(zBean);
                    zBeanList.add(zBean);

                }
            }

        }
        is.close();
        return zBeanList;

    }

    private static Workbook getWorkBook(String fileName) {
        file = new File(fileName);

        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            is = new FileInputStream(file);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(xls)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
        return workbook;
    }

}