package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablo = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 3);
        System.out.println("tablo = " + tablo);
    }

    public static ArrayList<ArrayList<String>> getListData(String path,String sheetName, int columnCount)   // excel'den verileri alıp arrayliste dönüştüren metod.
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
    public static void writeToExcel(String path, Scenario senaryo, String browserName, String time){

        File f = new File(path);

        if(!f.exists())   // dosya yok ise
        {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("CampusTest");
            // workbook-sheet-row-cell
            Row yeniSatir = sheet.createRow(0);
            Cell yeniHucre = yeniSatir.createCell(0);

            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString());

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            yeniHucre = yeniSatir.createCell(3);
            yeniHucre.setCellValue(time);

            // bu işlemlerin tümü hafızada yapılıyor, fiziksel olarak bir dosya halinde değil, yazılmadı.

            // şimdi hafızada yazılanları kaydetme,yazma işlemi yapılıyor. file SAVE kısmı

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }
        else    // var ise          // burada dosyadan okuma yapılıyor çünkü file zaten var.
        {
            Sheet sheet = null;
            Workbook workbook = null;
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            }
            catch (Exception e)
            {
                System.out.println("Message = " + e);
            }

            // row'u bir önceki satırın altında oluşturacağım çünkü 0'da oluşturursam her zaman aynı yerde yazar. bu yüzden en son kaçıncı satırda kaldığını bulmalıyız.
            int enSonSatirSayisi = sheet.getPhysicalNumberOfRows();     // örn: 5 satır var --> 0,1,2,3,4
            Row yeniSatir = sheet.createRow(enSonSatirSayisi);      //5 indexli satır yeni satır olmuş olacak.

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString());

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            yeniHucre = yeniSatir.createCell(3);
            yeniHucre.setCellValue(time);

            // bu işlemlerin tümü hafızada yapılıyor, fiziksel olarak bir dosya halinde değil, yazılmadı.

            // şimdi hafızada yazılanları kaydetme,yazma işlemi yapılıyor. file SAVE kısmı

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
