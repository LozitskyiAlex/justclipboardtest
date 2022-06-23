package com.clipboard.pages;

import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    static Logger logger = Logger.getLogger(ItemPage.class.getName());

    SelenideElement featureBullets = $("#feature-bullets");

    public ItemPage verifyAboutSectionIsPresentOnPage() {
        logger.info("verify that about section is present on page. Section text: " + featureBullets.getText());
        Assert.isTrue(featureBullets.exists(),  "The about section is not present on item page");
        return this;
    }
}