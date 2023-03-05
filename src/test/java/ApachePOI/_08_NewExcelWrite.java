package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // Workbook var olan excelin workbook'u idi(hafıza), bunu oluşmamış bir excel için kullanamıyoruz.

        XSSFWorkbook workbook = new XSSFWorkbook(); //  hafızada bir workbook oluşturuldu
        XSSFSheet sheet = workbook.createSheet("Sayfa1");   // içinde sheet oluşturdum.

        // Hafızada işlemlere devam ediliyor
        Row yeniSatir = sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre = yeniSatir.createCell(0);   // yeni satırda ilk hücre oluşturuldu.
        yeniHucre.setCellValue("Merhaba Yeni Dünya");    // bilgi yazıldı

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);    // 1 2 3 satır başlarına yazmak için
        }

        //        yazma işlemi için yazma modunu açmalıyız(SAVE)
        String path ="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);   // workbook excel dosyasına yazıldı.
        workbook.close();       // workbook için ayrılan hafıza boşaltıldı.
        outputStream.close();  // yazma için açılan kanal kapatıldı.
        System.out.println("işlem tamamlandı");
    }
}
