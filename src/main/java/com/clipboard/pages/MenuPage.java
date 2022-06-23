package com.clipboard.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    static Logger logger = Logger.getLogger(MenuPage.class.getName());

    SelenideElement hamburgerMenu = $("#nav-hamburger-menu");

    public MenuPage clickOnHamburgerMenu() {
        logger.info("open hamburger menu");
        hamburgerMenu.click();
        return this;
    }

    public MenuPage clickOnMenuByText(String text) {
        logger.info("click on menu by text " + text);
        $(byXpath("//*[@id='hmenu-content']//*[contains(text(), '"+text+"')]")).click();
        return this;
    }
}
