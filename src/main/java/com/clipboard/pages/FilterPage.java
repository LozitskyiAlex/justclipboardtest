package com.clipboard.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FilterPage {
    static Logger logger = Logger.getLogger(FilterPage.class.getName());

    SelenideElement sortDropDown = $("#s-result-sort-select");

    public FilterPage selectFilter(String type, String name) {
        logger.info("select filter " + type + ": " + name);
        $(byXpath("//*[contains(text(), '" + type + "')]/parent::div/parent::div//ul//*[contains(text(), '" + name + "')]")).click();
        return this;
    }

    public FilterPage sortResultsBy(String value) {
        logger.info("sort results by " + value);
        Select select = new Select(sortDropDown);
        select.selectByVisibleText(value);
        return this;
    }
}
