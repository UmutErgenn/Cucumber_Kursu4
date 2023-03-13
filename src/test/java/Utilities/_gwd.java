package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _gwd { // genel web driver

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();   // her thread'e özel local static driver oluşacak.  WebDriver1,WebDriver2
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();     // Chrome, firefox

    // threadDriver.get() -> bulunduğum thread'deki driver'ı verir.
    // threadDriver.set(driver) -> bulunduğum thread'e driver set ediliyor.


    public  static WebDriver getDriver()
    {
        Locale.setDefault(new Locale("EN"));                    // extend report türkçe bilg çalışmaması sebebiyle kondu
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);    // sadece error'larıı göster
        System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadDriver.get()==null) {

            switch (threadBrowserName.get())
            {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());

                default:
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
            }
        }
        return threadDriver.get(); // driver'ı gönder
    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        if (threadDriver.get() != null) // dolu ise
        {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }

    }
    public static void setThreadBrowserName(String browserName) {   // setter metod.encapsulation.
        _gwd.threadBrowserName.set(browserName);
    }
    public static String getThreadBrowserName() {
        return _gwd.threadBrowserName.get();
    }

}
