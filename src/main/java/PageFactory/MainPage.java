package PageFactory;


import DriverLogics.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.validation.constraints.NotNull;

public class MainPage {

    private static MainPage INSTANCE;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static synchronized MainPage getMainPage(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new MainPage(webDriver);
        }
        return INSTANCE;
    }

    //search filed and button
    @FindBy(how = How.XPATH, using = "/html/body/div[@class='page_body page_body_ru page_body_2']/div[@class='page_header']/div[@class='search_form search_form_ru']/form/input[@id='query_input']")
    static WebElement searchFiled;

    @FindBy(how = How.XPATH, using = "/html/body/div[@class='page_body page_body_ru page_body_2']/div[@class='page_header']/div[@class='search_form search_form_ru']/form/input[@class='button']")
    static WebElement searchButton;

    //main menu tabs

    final static String TOP_MENU_XPATH = "/html/body/div[@class='page_body page_body_ru page_body_2']/div[@class='page_header']/div[@class='top_menu']";

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div[@class='item home_item']")
    static WebElement homeTab;

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div/a[text()='Скачать игры']")
    static WebElement downloadTab;

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div/a[text()='Онлайн игры']")
    static WebElement onlineTab;

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div/a[text()='Мобильные Игры']")
    static WebElement mobileGamesTab;

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div/a[text()='Видео']")
    static WebElement videoTabs;

    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div[@class='item reviews_item']")
    static WebElement reviewsTabs;

    // reviews menu
    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div[@class='item reviews_item']/div[@id='reviewsubmenu']/a[@id='rev_pc_link']")
    static WebElement reviewsPCItem;
    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div[@class='item reviews_item']/div[@id='reviewsubmenu']/a[@id='rev_iphone_link']")
    static WebElement reviewsiPhoneItem;
    @FindBy(how = How.XPATH, using = TOP_MENU_XPATH + "/div[@class='item reviews_item']/div[@id='reviewsubmenu']/a[@id='rev_android_link']")
    static WebElement reviewsAndroidItem;

    // logos
    @FindBy(how = How.XPATH, using = "/html/body/div[@class='page_body page_body_ru page_body_2']/div[@class='page_header']/div[@class='features']/a[@class='header_rss']")
    static WebElement logoGameForRSS;

    @FindBy(how = How.XPATH, using = "/html/body/div[@class='page_body page_body_ru page_body_2']/div[@class='page_header']/div[@class='logo']")
    static WebElement mpcLogo;

    public void pressTab(@NotNull String tabName) {
        WebDriverHelper.getCurrentDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_MENU_XPATH + "/div[@class='item home_item']")));
        switch (tabName) {
            case "Home":
                homeTab.click();
                break;
            case "Download Games":
                downloadTab.click();
                break;
            case "Online Games":
                onlineTab.click();
                break;
            case "Mobile Games":
                mobileGamesTab.click();
                break;
            case "Reviews":
                reviewsTabs.click();
                break;
            case "Video":
                videoTabs.click();
                break;
        }
    }

    public void pressItemReviewsMenu(@NotNull String itemName) {
        WebDriverHelper.getCurrentDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_MENU_XPATH + "/div[@class='item reviews_item']/div[@id='reviewsubmenu']/a[@id='rev_android_link']")));
        switch (itemName) {
            case "PC":
                reviewsPCItem.click();
                break;
            case "iPhone":
                reviewsiPhoneItem.click();
                break;
            case "Android":
                reviewsAndroidItem.click();
                break;
        }
    }

    public void pressToFreeGamesByRSSLogo() {
        logoGameForRSS.click();
    }

    public void pressToMPCLogo() {
        mpcLogo.click();
    }

    public void enterIntoTheSearchField(String searchWord) {
        searchFiled.sendKeys(searchWord);
    }

    public void pressSearchButton() {
        searchButton.click();
    }
}
