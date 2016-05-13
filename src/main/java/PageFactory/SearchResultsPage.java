package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends MainPage {


    private static SearchResultsPage INSTANCE;

    @FindBy(how = How.XPATH, using = "/html/body/center/div[@class='allbody allbody2 allbody_ru']/div[@class='body']/div[@class='body_left_3']/div[@class='hatbox']/div[@class='hat_body']/div[@class='hat_content']/div[@class='stpage']/div[@class='search']/div[@class='search_2']")
    static WebElement searchResults;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static synchronized SearchResultsPage getSearchResultsPage(WebDriver webDriver) {
        if (INSTANCE == null) {
            INSTANCE = new SearchResultsPage(webDriver);
        }
        return INSTANCE;
    }

    public int getSearchResultsCount() {
        System.out.println(searchResults.getText());
        String results = searchResults.getText().substring(13);
        System.out.println(results);
        return Integer.valueOf(results);
    }

}
