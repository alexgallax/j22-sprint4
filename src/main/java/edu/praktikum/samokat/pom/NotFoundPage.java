package edu.praktikum.samokat.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotFoundPage {

    private final WebDriver webDriver;

    private final By notFoundImage = By.xpath(".//img[@alt='Not found']");

    public NotFoundPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkExists() {
        return webDriver.findElements(notFoundImage).size() > 0;
    }
}
