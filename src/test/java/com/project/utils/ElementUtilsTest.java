
package com.project.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElementUtilsTest {

    @Mock
    private WebDriver driver;

    @InjectMocks
    private ElementUtils elementUtils;

    @Mock
    private WebElement webElement;

    @BeforeEach
    void setUp() {
        elementUtils = new ElementUtils(driver);
    }

    @Test
    void shouldReturnRandomTime() {
        LocalTime randomTime = ElementUtils.getRandomTime();
        assertNotNull(randomTime);
    }

    @Test
    void shouldReturnFalseWhenElementIsNotReadOnly() {
        when(webElement.getAttribute("disabled")).thenReturn("false");
        when(webElement.getAttribute("readonly")).thenReturn("false");
        assertFalse(elementUtils.isElementReadOnly(driver, webElement));
    }

    @Test
    void shouldClickElementUsingJavaScript() {
        doNothing().when(webElement).click();
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.clickElement(webElement);
        verify(webElement, times(1)).click();
    }

    @Test
    void shouldCheckFieldReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.getAttribute("readonly")).thenReturn("true");
        assertDoesNotThrow(() -> ElementUtils.checkFieldReadOnly(driver, By.className("test-class")));
    }

    @Test
    void shouldCheckFieldNotReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.getAttribute("readonly")).thenReturn(null);
        assertDoesNotThrow(() -> ElementUtils.checkFieldNotReadOnly(driver, By.className("test-class")));
    }

    @Test
    void shouldReturnTrueWhenElementIsClickable() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.isEnabled()).thenReturn(false);
        assertTrue(ElementUtils.isElementClickable(driver, By.className("test-class")));
    }

    @Test
    void shouldWaitForElementAndSendKeys() {
        doNothing().when(webElement).clear();
        doNothing().when(webElement).sendKeys("test");
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.clearAndSendKeys(webElement, "test");
        verify(webElement, times(1)).clear();
        verify(webElement, times(1)).sendKeys("test");
    }

    @Test
    void shouldReturnTrueWhenElementIsDisplayed() {
        when(webElement.isDisplayed()).thenReturn(true);
        assertTrue(elementUtils.isElementDisplayed(webElement));
    }

    @Test
    void shouldReturnFalseWhenElementIsNotDisplayed() {
        when(webElement.isDisplayed()).thenThrow(new RuntimeException());
        assertFalse(elementUtils.isElementDisplayed(webElement));
    }

    @Test
    void shouldSelectOptionInDropdownByIndex() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.isDisplayed()).thenReturn(true);
        elementUtils.selectOptionInDropdownByIndex(webElement, 1);
        verify(webElement, times(1)).click();
    }

    @Test
    void shouldCheckIfPaginationIsPresent() {
        when(driver.findElements(any(By.class))).thenReturn(Collections.emptyList());
        assertFalse(elementUtils.isPaginationPresent());
    }

    @Test
    void shouldNavigateToLastPageIfPresent() {
        when(driver.findElements(any(By.class))).thenReturn(Collections.singletonList(webElement));
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.navigateToLastPageIfPresent();
        verify(webElement, times(1)).click();
    }

    @Test
    public void shouldReturnFalseIfElementNotPresent() {
        when(driver.findElements(any(By.class))).thenReturn(Collections.emptyList());
        assertFalse(elementUtils.isElementPresent(By.className("test-class")));
    }

    @Test
    public void shouldReturnTrueIfElementIsPresent() {
        when(driver.findElements(any(By.class))).thenReturn(Collections.singletonList(webElement));
        assertTrue(elementUtils.isElementPresent(By.className("test-class")));
    }
}
