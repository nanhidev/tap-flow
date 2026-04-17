
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ExtendWith(MockitoExtension.class)
public class ElementUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement webElement;

    @InjectMocks
    private ElementUtils elementUtils;

    @Test
    public void shouldReturnRandomTime() {
        LocalTime randomTime = ElementUtils.getRandomTime();
        assertNotNull(randomTime);
    }

    @Test
    public void shouldReturnTrueWhenElementIsReadOnly() {
        when(webElement.getAttribute("disabled")).thenReturn("false");
        when(webElement.getAttribute("readonly")).thenReturn("true");
        boolean isReadOnly = elementUtils.isElementReadOnly(driver, webElement);
        assertFalse(isReadOnly);
    }

    @Test
    public void shouldClickElementUsingJavaScript() {
        doNothing().when(webElement).click();
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.jsClick(driver, webElement);
        verify(webElement, times(1)).click();
    }

    @Test
    public void shouldScrollToElement() {
        elementUtils.scrollToElement(webElement);
        verify(webElement, times(1)).getAttribute("scrollIntoView");
    }

    @Test
    public void shouldSelectOptionInDropdown() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.selectOptionInDropdown(webElement, "Option 1");
        verify(webElement, times(1)).click();
    }

    @Test
    public void shouldClearAndSendKeys() {
        doNothing().when(webElement).clear();
        doNothing().when(webElement).sendKeys("text");
        elementUtils.clearAndSendKeys(webElement, "text");
        verify(webElement, times(1)).clear();
        verify(webElement, times(1)).sendKeys("text");
    }

    @Test
    public void shouldCheckFieldReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.getAttribute("readonly")).thenReturn("true");
        elementUtils.checkFieldReadOnly(driver, By.id("test"));
        verify(webElement, times(1)).getAttribute("readonly");
    }

    @Test
    public void shouldCheckFieldNotReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.getAttribute("readonly")).thenReturn(null);
        elementUtils.checkFieldNotReadOnly(driver, By.id("test"));
        verify(webElement, times(1)).getAttribute("readonly");
    }

    @Test
    public void shouldVerifyDropdownOptions() {
        List<String> expectedOptions = Collections.singletonList("Option 1");
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        elementUtils.verifyDropdownOptions(webElement, expectedOptions, "Dropdown option count mismatch");
        verify(webElement, times(1)).getAttribute("text");
    }
}
