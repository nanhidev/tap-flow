
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ExtendWith(MockitoExtension.class)
class WaitUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private By locator;

    @Mock
    private Alert alert;

    @Test
    void shouldReturnElementWhenWaitForVisibilityByLocator() {
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        
        WebElement result = WaitUtils.waitForVisibility(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnElementWhenWaitForVisibilityWithElement() {
        when(element.isDisplayed()).thenReturn(true);
        
        WebElement result = WaitUtils.waitForVisibility(driver, element);
        
        assertNotNull(result);
        verify(element).isDisplayed();
    }

    @Test
    void shouldReturnElementWhenWaitForClickableByLocator() {
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        when(element.isEnabled()).thenReturn(true);
        
        WebElement result = WaitUtils.waitForClickable(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnElementWhenWaitForClickableWithElement() {
        when(element.isDisplayed()).thenReturn(true);
        when(element.isEnabled()).thenReturn(true);
        
        WebElement result = WaitUtils.waitForClickable(driver, element);
        
        assertNotNull(result);
        verify(element).isDisplayed();
    }

    @Test
    void shouldReturnTrueWhenWaitForInvisibilityByLocator() {
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(false);
        
        boolean result = WaitUtils.waitForInvisibility(driver, locator);
        
        assertTrue(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnTrueWhenWaitForInvisibilityWithElement() {
        when(element.isDisplayed()).thenReturn(false);
        
        boolean result = WaitUtils.waitForInvisibility(driver, element);
        
        assertTrue(result);
        verify(element).isDisplayed();
    }

    @Test
    void shouldReturnAlertWhenWaitForAlert() {
        when(driver.switchTo().alert()).thenReturn(alert);
        
        Alert result = WaitUtils.waitForAlert(driver);
        
        assertNotNull(result);
        verify(driver).switchTo();
    }

    @Test
    void shouldReturnListWhenWaitForAllVisible() {
        List<WebElement> elements = List.of(element);
        when(driver.findElements(locator)).thenReturn(elements);
        when(element.isDisplayed()).thenReturn(true);
        
        List<WebElement> result = WaitUtils.waitForAllVisible(driver, locator);
        
        assertEquals(1, result.size());
        verify(driver).findElements(locator);
    }

    @Test
    void shouldReturnTrueWhenWaitForNumberOfElements() {
        when(driver.findElements(locator)).thenReturn(List.of(element));
        
        boolean result = WaitUtils.waitForNumberOfElements(driver, locator, 1);
        
        assertTrue(result);
        verify(driver).findElements(locator);
    }
}
