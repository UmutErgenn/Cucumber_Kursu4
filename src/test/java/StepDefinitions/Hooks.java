package StepDefinitions;

import Utilities._gwd;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {    // her senaryodan sonra çalışır.
    @Before     // her senaryodan önce çalışır.
    public void  before()
    {
        System.out.println("Senaryo başladı");
    }
    @After      // her senaryodan sonra çalışır.
    public void after(Scenario senaryo)
    {
        System.out.println("Senaryo bitti");

        if (senaryo.isFailed())     // senaryo bittiği zaman çalışır
        {
            final byte[] screenshot = ((TakesScreenshot) _gwd.getDriver()).getScreenshotAs(OutputType.BYTES);
            senaryo.attach(screenshot, "image/png", "screenshot name");

//            File hafizadakiHali =((TakesScreenshot) _gwd.getDriver()).getScreenshotAs(OutputType.FILE);   yukardakiyle aynı , sadece file hali.
//
//            TakesScreenshot ts = (TakesScreenshot) _gwd.getDriver();      // 1. Aşama : ekran görüntüsü alma değişkenini tanımladım.
//            File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);      // 2.Aşama : ekran görüntüsü alındı, şuan hafızada
//
//            LocalDateTime time = LocalDateTime.now();
//            DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd_MM_YYHHmmss");
//            try {
//                FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot_"+time.format(tf)+".png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
        _gwd.quitDriver();
    }
}
