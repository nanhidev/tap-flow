
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.io.File;

@ExtendWith(MockitoExtension.class)
class CommonUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement dropdownElement;

    @Mock
    private Scenario scenario;

    @Test
    void shouldGenerateUniqueEmail() {
        String email = CommonUtils.getEmailWithTimeStamp();
        assertTrue(email.startsWith("newemail"));
        assertTrue(email.endsWith("@gmail.com"));
    }

    @Test
    void shouldCaptureScreenshot() {
        byte[] screenshot = CommonUtils.takeScreenShot(scenario, driver, "testScenario");
        assertNotNull(screenshot);
    }

    @Test
    void shouldScrollToBottom() {
        JavascriptExecutor js = mock(JavascriptExecutor.class);
        when(driver).thenReturn(js);
        when(js.executeScript("return document.body.scrollHeight")).thenReturn(100L).thenReturn(100L);
        
        CommonUtils.scrollToBottom(driver);
        verify(js, atLeast(1)).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Test
    void shouldScrollToTop() {
        JavascriptExecutor js = mock(JavascriptExecutor.class);
        when(driver).thenReturn(js);
        when(js.executeScript("return window.pageYOffset")).thenReturn(100L).thenReturn(0L);
        
        CommonUtils.scrollToTop(driver);
        verify(js, atLeast(1)).executeScript("window.scrollBy(0, -1000);");
    }

    @Test
    void shouldVerifyDropdownSelectedOption() {
        Select select = mock(Select.class);
        when(dropdownElement.getTagName()).thenReturn("select");
        when(select.getFirstSelectedOption()).thenReturn(mock(WebElement.class));
        when(select.getOptions()).thenReturn(Arrays.asList(mock(WebElement.class), mock(WebElement.class)));
        when(select.getOptions().indexOf(select.getFirstSelectedOption())).thenReturn(1);
        
        CommonUtils.DropdownSelectedOptionVerification(dropdownElement, 1, "Dropdown option mismatch");
        verify(select).getFirstSelectedOption();
    }

    @Test
    void shouldCaptureScreenshotAndReturnPath() throws Exception {
        File file = mock(File.class);
        when(driver).thenReturn((TakesScreenshot) () -> file);
        when(file.getAbsolutePath()).thenReturn(System.getProperty("user.dir") + "/screenshots/test.png");

        String path = CommonUtils.captureScreenshot(driver, "test");
        assertEquals(System.getProperty("user.dir") + "/screenshots/test.png", path);
    }

    @Test
    void shouldSwitchToNewWindow() {
        when(driver.getWindowHandle()).thenReturn("currentWindow");
        when(driver.getWindowHandles()).thenReturn(new HashSet<>(Arrays.asList("currentWindow", "newWindow")));
        
        CommonUtils.switchToNewWindow(driver);
        verify(driver).switchTo().window("newWindow");
    }

    @Test
    void shouldSwitchToParentWindow() {
        when(driver.getWindowHandles()).thenReturn(new HashSet<>(Arrays.asList("parentWindow", "childWindow")));
        
        CommonUtils.switchToParentWindow(driver);
        verify(driver).switchTo().window("parentWindow");
    }

    @Test
    void shouldUploadFile() {
        String filePath = "path/to/file.txt";
        CommonUtils.uploadFile(dropdownElement, filePath);
        verify(dropdownElement).sendKeys(filePath);
    }

    @Test
    void shouldCheckIfAlertIsPresent() {
        when(driver.switchTo().alert()).thenThrow(new NoAlertPresentException());
        boolean isPresent = CommonUtils.isAlertPresent(driver);
        assertFalse(isPresent);
    }

    @Test
    void shouldAcceptAlert() {
        Alert alert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alert);
        CommonUtils.acceptAlert(driver);
        verify(alert).accept();
    }

    @Test
    void shouldDismissAlert() {
        Alert alert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alert);
        CommonUtils.dismissAlert(driver);
        verify(alert).dismiss();
    }

    @Test
    void shouldWaitForElementVisible() {
        WebDriverWait wait = mock(WebDriverWait.class);
        whenNew(WebDriverWait.class).withArguments(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)).thenReturn(wait);
        
        CommonUtils.waitForElementVisible(driver, dropdownElement);
        verify(wait).until(any());
    }

    @Test
    void shouldWaitForElementClickable() {
        WebDriverWait wait = mock(WebDriverWait.class);
        whenNew(WebDriverWait.class).withArguments(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)).thenReturn(wait);
        
        CommonUtils.waitForElementClickable(driver, dropdownElement);
        verify(wait).until(any());
    }

    @Test
    void shouldWaitForPageLoad() {
        WebDriverWait wait = mock(WebDriverWait.class);
        whenNew(WebDriverWait.class).withArguments(driver, Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME)).thenReturn(wait);
        
        CommonUtils.waitForPageLoad(driver);
        verify(wait).until(any());
    }

    @Test
    void shouldRefreshPage() {
        CommonUtils.refreshPage(driver);
        verify(driver).navigate().refresh();
    }

    @Test
    void shouldMaximizeWindow() {
        CommonUtils.maximizeWindow(driver);
        verify(driver).manage().window().maximize();
    }

    @Test
    void shouldSleepForSpecifiedTime() throws InterruptedException {
        CommonUtils.sleep(1);
        verify(Thread.class).sleep(1000L);
    }
}
