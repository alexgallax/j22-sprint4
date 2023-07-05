package edu.praktikum.samokat;

import edu.praktikum.samokat.pom.MainPage;
import edu.praktikum.samokat.steps.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static edu.praktikum.samokat.utils.Utils.randomString;

public class OrderStatus {

    private static final String NOT_EXISTING_ORDER = randomString();

    private WebDriver webDriver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage
                .open()
                .clickCheckOrder()
                .inputOrder(NOT_EXISTING_ORDER)
                .clickGo();

        Assert.assertTrue("Нет сообщения 'Заказ не найден'", mainPage.notFoundPage().checkExists());
    }

    @Test
    public void notFoundIfOrderNotExists2() {
        MainPage mainPage = new MainPage(webDriver);
        Steps steps = new Steps(webDriver);

        steps
                .open(mainPage.getUrl())
                .click(mainPage.getCheckOrderButton())
                .inputText(mainPage.getInputOrder(), NOT_EXISTING_ORDER)
                .click(mainPage.getGoButton());

        Assert.assertTrue("Нет сообщения 'Заказ не найден'", mainPage.notFoundPage().checkExists());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
