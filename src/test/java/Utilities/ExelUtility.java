package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablo = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 3);
        System.out.println("tablo = " + tablo);
    }

    public static ArrayList<ArrayList<String>> getListData(String path,String sheetName, int columnCount)
    {
            ArrayList<ArrayList<String>> tablo = new ArrayList<>();

            Sheet sheet = null;     // böyle yapıyoruz çünkü try catch içinde tanımlarsak try catch dışında sheet'i tanımıyor.
            try {
                FileInputStream inputStream = new FileInputStream(path);    // java verdiğimiz path'le bu program arasında okuma kanalı açıyor.
                Workbook workbook = WorkbookFactory.create(inputStream);    // hafızaya aldım
                sheet = workbook.getSheet(sheetName); // parametre olarak gelen sheetname
            }
            catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {     // tüm satırları getiriyor
                ArrayList<String> satirData = new ArrayList<>();
                for (int j = 0; j < columnCount; j++) {
                    satirData.add(sheet.getRow(i).getCell(j).toString());   // hücreyi aldım ve satirData arraylist'ine ekledim
                }
                tablo.add(satirData);
            }
            return tablo;
    }
}
