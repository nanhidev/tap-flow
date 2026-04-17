
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
import org.openqa.selenium.support.ui.ExpectedConditions;

@ExtendWith(MockitoExtension.class)
class WaitUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private Alert alert;

    @Mock
    private By locator;

    @Test
    void shouldReturnWebElementWhenVisible() {
        when(driver).thenReturn(driver);
        when(driver.findElement(locator)).thenReturn(element);
        when(driver.waitForVisibility(driver, element)).thenReturn(element);
        
        WebElement result = WaitUtils.waitForVisibility(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnTrueWhenElementIsClickable() {
        when(driver).thenReturn(driver);
        when(driver.waitForClickable(driver, element)).thenReturn(element);
        
        WebElement result = WaitUtils.waitForClickable(driver, element);
        
        assertNotNull(result);
        verify(driver).waitForClickable(driver, element);
    }

    @Test
    void shouldReturnTrueWhenPresenceOfElement() {
        when(driver.findElements(locator)).thenReturn(List.of(element));
        
        boolean result = WaitUtils.waitForPresence(driver, locator);
        
        assertTrue(result);
        verify(driver).findElements(locator);
    }

    @Test
    void shouldReturnTrueWhenElementIsInvisible() {
        when(driver.waitForInvisibility(driver, locator)).thenReturn(true);
        
        boolean result = WaitUtils.waitForInvisibility(driver, locator);
        
        assertTrue(result);
        verify(driver).waitForInvisibility(driver, locator);
    }

    @Test
    void shouldReturnAlertWhenAlertIsPresent() {
        when(driver.waitForAlert(driver)).thenReturn(alert);
        
        Alert result = WaitUtils.waitForAlert(driver);
        
        assertNotNull(result);
        verify(driver).waitForAlert(driver);
    }

    @Test
    void shouldReturnTrueWhenUrlContainsText() {
        when(driver.waitForUrlContains(driver, "test")).thenReturn(true);
        
        boolean result = WaitUtils.waitForUrlContains(driver, "test");
        
        assertTrue(result);
        verify(driver).waitForUrlContains(driver, "test");
    }

    @Test
    void shouldReturnTrueWhenNumberOfWindowsIsCorrect() {
        when(driver.waitForNumberOfWindows(driver, 1)).thenReturn(true);
        
        boolean result = WaitUtils.waitForNumberOfWindows(driver, 1);
        
        assertTrue(result);
        verify(driver).waitForNumberOfWindows(driver, 1);
    }

    @Test
    void shouldCompletePageLoad() {
        doNothing().when(driver).waitForPageLoad(driver);
        
        WaitUtils.waitForPageLoad(driver);
        
        verify(driver).waitForPageLoad(driver);
    }
}
