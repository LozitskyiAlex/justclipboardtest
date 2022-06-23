package com.clipboard;

import com.clipboard.pages.FilterPage;
import com.clipboard.pages.ItemPage;
import com.clipboard.pages.MenuPage;
import com.clipboard.pages.SearchResultPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class ItemPageTest {

    MenuPage menuPage = new MenuPage();
    FilterPage filterPage = new FilterPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ItemPage itemPage = new ItemPage();
    static Logger logger = Logger.getLogger(ItemPageTest.class.getName());
    static String url = support.PropertiesCache.getInstance().getProperty("url");

    @BeforeAll
    public static void before() {
        logger.info("open url " + url);
        open(url);
    }

    @AfterAll
    public static void after() {
        logger.info("after all close driver");
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    public void verifyAboutSectionIsPresentOnItemPage() {
        menuPage.clickOnHamburgerMenu()
                .clickOnMenuByText("TV, Appliances, Electronics")
                .clickOnMenuByText("Televisions");
        filterPage.selectFilter("Brand", "Samsung")
                .sortResultsBy("Price: High to Low");
        searchResultPage.clickOnSearchResultItemByIndex(2);
        switchTo().window(1);
        itemPage.verifyAboutSectionIsPresentOnPage();
    }
}
