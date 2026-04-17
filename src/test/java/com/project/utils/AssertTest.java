
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssertTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @InjectMocks
    private Assert assertClass;

    @Test
    public void shouldPassAssertTrueWhenConditionIsTrue() {
        assertClass.assertTrue(true, "Condition should be true");
    }

    @Test
    public void shouldFailAssertTrueWhenConditionIsFalse() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertTrue(false, "Condition should be true");
        });
        assertTrue(exception.getMessage().contains("Condition should be true"));
    }

    @Test
    public void shouldPassAssertFalseWhenConditionIsFalse() {
        assertClass.assertFalse(false, "Condition should be false");
    }

    @Test
    public void shouldFailAssertFalseWhenConditionIsTrue() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertFalse(true, "Condition should be false");
        });
        assertTrue(exception.getMessage().contains("Condition should be false"));
    }

    @Test
    public void shouldPassAssertNotNullWhenObjectIsNotNull() {
        assertClass.assertNotNull(new Object(), "Object should not be null");
    }

    @Test
    public void shouldFailAssertNotNullWhenObjectIsNull() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertNotNull(null, "Object should not be null");
        });
        assertTrue(exception.getMessage().contains("Object should not be null"));
    }

    @Test
    public void shouldPassAssertEqualsWhenValuesMatch() {
        assertClass.assertEquals("value", "value", "Values should match");
    }

    @Test
    public void shouldFailAssertEqualsWhenValuesDoNotMatch() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertEquals("value", "differentValue", "Values should match");
        });
        assertTrue(exception.getMessage().contains("Values should match"));
    }

    @Test
    public void shouldPassAssertElementVisibleWhenElementIsVisible() {
        when(element.isDisplayed()).thenReturn(true);
        assertClass.assertElementVisible(driver, element, "Element should be visible");
    }

    @Test
    public void shouldFailAssertElementVisibleWhenElementIsNotVisible() {
        when(element.isDisplayed()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertElementVisible(driver, element, "Element should be visible");
        });
        assertTrue(exception.getMessage().contains("Element should be visible"));
    }

    @Test
    public void shouldPassAssertElementClickableWhenElementIsClickable() {
        when(element.isEnabled()).thenReturn(true);
        assertClass.assertElementClickable(driver, element, "Element should be clickable");
    }

    @Test
    public void shouldFailAssertElementClickableWhenElementIsNotClickable() {
        when(element.isEnabled()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertElementClickable(driver, element, "Element should be clickable");
        });
        assertTrue(exception.getMessage().contains("Element should be clickable"));
    }

    @Test
    public void shouldPassAssertListNotEmptyWhenListIsNotEmpty() {
        assertClass.assertListNotEmpty(Collections.singletonList(new Object()), "List should not be empty");
    }

    @Test
    public void shouldFailAssertListNotEmptyWhenListIsEmpty() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertListNotEmpty(Collections.emptyList(), "List should not be empty");
        });
        assertTrue(exception.getMessage().contains("List should not be empty"));
    }

    @Test
    public void shouldPassAssertListContainsWhenListContainsItem() {
        assertClass.assertListContains(Collections.singletonList("item"), "item", "List should contain item");
    }

    @Test
    public void shouldFailAssertListContainsWhenListDoesNotContainItem() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertClass.assertListContains(Collections.emptyList(), "item", "List should contain item");
        });
        assertTrue(exception.getMessage().contains("List should contain item"));
    }
}
