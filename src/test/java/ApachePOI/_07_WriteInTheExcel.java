package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan excel'e yazma işlemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);    // okuma modu açıldı
        Workbook workbook = WorkbookFactory.create(inputStream);    // excel'deki workbook'u hafızaya aldı,okudu
        Sheet sheet = workbook.getSheetAt(0);

        // Hafızada işlemlere devam ediliyor
        Row yeniSatir = sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre = yeniSatir.createCell(0);   // yeni satırda ilk hücre oluşturuldu.
        yeniHucre.setCellValue("Merhaba Dünya");    // bilgi yazıldı

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);    // 1 2 3 satır başlarına yazmak için
        }

        inputStream.close(); // okuma modu , kanalı kapatılıyor.    buraya kadar yapılanlar hafızada yapıldı, henüz geçerli değil,perform yapılması bekleniyor.

//        yazma işlemi için yazma modunu açmalıyız(save)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);   // workbook excel dosyasına yazıldı.
        workbook.close();       // workbook için ayrılan hafıza boşaltıldı.
        outputStream.close();  // yazma için açılan kanal kapatıldı.
        System.out.println("işlem tamamlandı");
    }
}
