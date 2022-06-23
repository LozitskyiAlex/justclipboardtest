package com.clipboard.pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    static Logger logger = Logger.getLogger(SearchResultPage.class.getName());

    ElementsCollection searchResults = $$("[data-component-type='s-search-result']");

    public SearchResultPage clickOnSearchResultItemByIndex(int index) {
        logger.info("click on search result item by index " + index);
        searchResults.get(index - 1).click();
        return this;
    }
}
