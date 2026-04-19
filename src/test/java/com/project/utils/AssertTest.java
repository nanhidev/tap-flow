
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssertTest {

    @InjectMocks
    private Assert assertInstance;

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Test
    public void shouldAssertTrueWhenConditionIsTrue() {
        String message = "Condition should be true";
        assertInstance.assertTrue(true, message);
    }

    @Test
    public void shouldAssertFalseWhenConditionIsFalse() {
        String message = "Condition should be false";
        assertInstance.assertFalse(false, message);
    }

    @Test
    public void shouldAssertEqualsWhenValuesAreEqual() {
        String message = "Values should be equal";
        assertInstance.assertEquals("value", "value", message);
    }

    @Test
    public void shouldAssertNotEqualsWhenValuesAreNotEqual() {
        String message = "Values should not be equal";
        assertInstance.assertNotEquals("value1", "value2", message);
    }

    @Test
    public void shouldAssertNotNullWhenObjectIsNotNull() {
        String message = "Object should not be null";
        assertInstance.assertNotNull(new Object(), message);
    }

    @Test
    public void shouldAssertNullWhenObjectIsNull() {
        String message = "Object should be null";
        assertInstance.assertNull(null, message);
    }

    @Test
    public void shouldAssertElementVisibleWhenElementIsVisible() {
        String elementName = "Test Element";
        when(element.isDisplayed()).thenReturn(true);
        assertInstance.assertElementVisible(driver, element, elementName);
    }

    @Test
    public void shouldAssertElementNotVisibleWhenElementIsNotVisible() {
        String elementName = "Test Element";
        when(element.isDisplayed()).thenReturn(false);
        assertInstance.assertElementNotVisible(driver, element, elementName);
    }

    @Test
    public void shouldAssertElementClickableWhenElementIsClickable() {
        String elementName = "Test Element";
        when(element.isEnabled()).thenReturn(true);
        assertInstance.assertElementClickable(driver, element, elementName);
    }

    @Test
    public void shouldAssertElementTextWhenTextMatches() {
        String expectedText = "Expected Text";
        String elementName = "Test Element";
        when(element.getText()).thenReturn(expectedText);
        assertInstance.assertElementText(driver, element, expectedText, elementName);
    }

    @Test
    public void shouldAssertCurrentUrlWhenUrlsMatch() {
        String expectedUrl = "http://expected.url";
        when(driver.getCurrentUrl()).thenReturn(expectedUrl);
        assertInstance.assertCurrentUrl(driver, expectedUrl);
    }
}
