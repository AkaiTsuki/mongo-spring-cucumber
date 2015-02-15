package me.msc.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by jiachiliu on 2/14/15.
 */
public class BrowserDriver {
    private static WebDriver webDriver;

    public synchronized static WebDriver getCurrentDriver() {

        if (webDriver == null) {
            try {
                webDriver = new FirefoxDriver(new FirefoxProfile());
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return webDriver;
    }

    public static class BrowserCleanup implements Runnable {

        @Override
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            webDriver = null;
        } catch (UnreachableBrowserException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadPage(String url) {
        getCurrentDriver().get(url);
    }

    public static WebElement waitForElement(WebElement element) {
        return waitForElement(element, null);
    }

    public static WebElement waitForElement(WebElement element, Integer timeInSeconds) {
        if (timeInSeconds == null) {
            timeInSeconds = 10;
        }
        WebDriverWait webDriverWait = new WebDriverWait(getCurrentDriver(), timeInSeconds);
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilFindById(String id, Integer seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(getCurrentDriver(), seconds);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static WebElement findElementById(String id) {
        return getCurrentDriver().findElement(By.id(id));
    }

    public static List<WebElement> findElementByClass(String className) {
        return getCurrentDriver().findElements(By.className(className));
    }

    public static List<WebElement> waitUntilFindAllByClass(String className, Integer seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(getCurrentDriver(), seconds);
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(className)));
    }
}
