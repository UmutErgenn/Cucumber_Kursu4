package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    /*
     * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
     * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
     * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
     * bulup ve sonucun döndürülmesi için metod kullanınız.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */

    public static void main(String[] args) throws IOException {

        System.out.println("Aranacak kelime=");
        Scanner scn = new Scanner(System.in);
        String arananKelime = scn.next();

        String donenSonuc = bul(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);

    }
    public static String bul(String arananKelime){
        String donecek="";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Sheet sheet = null;


        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//            Row row = sheet.getRow(i);
//            Cell cell = row.getCell(0);   ikisini birleştirebiliriz
//              Cell cell = sheet.getRow(i).getCell(0);   // her satırın 0. hücresine bak

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(arananKelime))   // her bir satırın 0. hücresi aradığım kelimeye eşit mi?
            {
                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {  // satırda ne kadar hücre varsa ekle getir
                    donecek+=sheet.getRow(i).getCell(j)+" ";
                }
            }
        }
        return donecek;
    }
}
