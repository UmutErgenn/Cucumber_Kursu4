package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        // dosyanın yolu alındı
        String path ="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // JavaDosya okuma işlemcisine dosyanın yolunu veriyoruz
        // böylece program ile dosya arasında bağlantı oluştu
        FileInputStream dosyanınOkumaBaglantisi = new FileInputStream(path);

        // Dosya okuma islemcisi üzerinden çalışma kitabını alıyorum
        // hafızada workbook u alıp oluşturdu
        Workbook calismaKitabi = WorkbookFactory.create(dosyanınOkumaBaglantisi);

        // istediğim isimdeki çalışma sayfasını alıyorum
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
//        Sheet calismaSayfasi = calismaKitabi.getSheetAt(0);

        // istenen satırı alıyorum
        Row satir = calismaSayfasi.getRow(0);

        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
    }
}
