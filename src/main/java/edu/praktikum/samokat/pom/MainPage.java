package edu.praktikum.samokat.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver webDriver;

    private final String url = "https://qa-scooter.praktikum-services.ru";

    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By inputOrder = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return url;
    }

    public By getCheckOrderButton() {
        return checkOrderButton;
    }

    public By getInputOrder() {
        return inputOrder;
    }

    public By getGoButton() {
        return goButton;
    }

    public MainPage open() {
        webDriver.get(url);
        return this;
    }

    public MainPage clickCheckOrder() {
        webDriver.findElement(checkOrderButton).click();
        return this;
    }

    public MainPage inputOrder(String orderName) {
        webDriver.findElement(inputOrder).sendKeys(orderName);
        return this;
    }

    public MainPage clickGo() {
        webDriver.findElement(goButton).click();
        return this;
    }

    public NotFoundPage notFoundPage() {
        return new NotFoundPage(webDriver);
    }
}
