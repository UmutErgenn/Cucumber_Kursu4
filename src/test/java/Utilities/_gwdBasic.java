package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _gwdBasic { // genel web driver

    private static WebDriver driver;

    public  static WebDriver getDriver()
    {
        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (driver==null) { // 1 kere başlat. bu olmazsa her driver kullanımında yeni chrome açılır

            Logger.getLogger("").setLevel(Level.SEVERE);    // sadece error'larıı göster
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");    // sessiz modda çalış



            // driver' ı start et,doldur,başlat ve gönder.
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); önceden bu şekilde yapıyorduk
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

//        WebDriverManager.firefoxdriver().setup();
//        driver=new FirefoxDriver();

        return  driver; // driver'ı gönder
    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        if (driver != null) // dolu ise
        {
            driver.quit();
            driver=null;
        }

    }

}
