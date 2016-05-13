package DriverLogics;


import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public class ProxyServer {

    private static WebDriver driver;
    private static BrowserMobProxy proxyServer;
    private static boolean serverIsStart = false;
    private static String MY_PLAY_CITY = "http://www.myplaycity.ru/";


    protected static void start() throws Exception {
        if (!serverIsStart) {
            serverIsStart = true;
            proxyServer = new BrowserMobProxyServer();
            proxyServer.start(4444);
            Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
            System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver(capabilities);

        }
    }

    public static void stop() {
        if (serverIsStart) {
            driver.quit();
            driver = null;
            proxyServer.stop();
            serverIsStart = false;
        }
    }

    @NotNull
    protected static WebDriver getWebDriver() throws Exception {
        return driver;
    }

    public static void doHar() throws Exception {
        if (serverIsStart) {
            proxyServer.newHar(MY_PLAY_CITY);
        } else {
            start();
            proxyServer.newHar(MY_PLAY_CITY);
        }
    }

    @Nullable
    public static Har getHar() {
        return serverIsStart ? proxyServer.getHar() : null;
    }
}

