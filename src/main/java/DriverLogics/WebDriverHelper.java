package DriverLogics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public synchronized static WebDriver getCurrentDriver() {
        if (driver == null) {
            try {
                ProxyServer.start();
                driver = ProxyServer.getWebDriver();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            //    Runtime.getRuntime().addShutdownHook(
            //            new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    public synchronized static WebDriverWait getCurrentDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(getCurrentDriver(), 300);
        }
        return wait;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            ProxyServer.stop();
        } catch (UnreachableBrowserException e) {
            e.printStackTrace();
        }
    }

}
