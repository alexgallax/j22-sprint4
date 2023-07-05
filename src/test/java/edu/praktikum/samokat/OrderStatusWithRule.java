package edu.praktikum.samokat;

import edu.praktikum.samokat.pom.MainPage;
import edu.praktikum.samokat.rules.BrowserRule;
import edu.praktikum.samokat.steps.Steps;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static edu.praktikum.samokat.utils.Utils.randomString;

public class OrderStatusWithRule {

    private static final String NOT_EXISTING_ORDER = randomString();

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage
                .open()
                .clickCheckOrder()
                .inputOrder(NOT_EXISTING_ORDER)
                .clickGo();

        Assert.assertTrue("Нет сообщения 'Заказ не найден'",
                mainPage.notFoundPage().checkExists());
    }

    @Test
    public void notFoundIfOrderNotExists2() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps
                .open(mainPage.getUrl())
                .click(mainPage.getCheckOrderButton())
                .inputText(mainPage.getInputOrder(), NOT_EXISTING_ORDER)
                .click(mainPage.getGoButton());

        Assert.assertTrue("Нет сообщения 'Заказ не найден'",
                mainPage.notFoundPage().checkExists());
    }
}
