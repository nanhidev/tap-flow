
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.Scenario;

import java.io.File;

@ExtendWith(MockitoExtension.class)
class CommonUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement dropdownElement;

    @Mock
    private Select select;

    @Mock
    private Scenario scenario;

    @Mock
    private TakesScreenshot takesScreenshot;

    @InjectMocks
    private CommonUtils commonUtils;

    @Test
    void shouldGenerateEmailWithTimestamp() {
        String email = CommonUtils.getEmailWithTimeStamp();
        assertTrue(email.startsWith("newemail"), "Email should start with 'newemail'");
        assertTrue(email.endsWith("@gmail.com"), "Email should end with '@gmail.com'");
    }

    @Test
    void shouldTakeScreenshot() {
        when(driver).thenReturn(takesScreenshot);
        when(takesScreenshot.getScreenshotAs(OutputType.BYTES)).thenReturn(new byte[0]);

        byte[] screenshot = CommonUtils.takeScreenShot(scenario, driver, "testScenario");
        assertNotNull(screenshot);
    }

    @Test
    void shouldScrollToBottom() {
        when(driver).thenReturn((JavascriptExecutor) driver);
        when(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight")).thenReturn(100L).thenReturn(100L);

        CommonUtils.scrollToBottom(driver);
        verify((JavascriptExecutor) driver, times(1)).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Test
    void shouldScrollToTop() {
        when(driver).thenReturn((JavascriptExecutor) driver);
        when(((JavascriptExecutor) driver).executeScript("return window.pageYOffset")).thenReturn(100L);

        CommonUtils.scrollToTop(driver);
        verify((JavascriptExecutor) driver, atLeastOnce()).executeScript("window.scrollBy(0, -1000);");
    }

    @Test
    void shouldVerifyDropdownSelectedOption() {
        when(dropdownElement.getFirstSelectedOption()).thenReturn(dropdownElement);
        when(select.getOptions()).thenReturn(Arrays.asList(dropdownElement));
        when(select.getFirstSelectedOption()).thenReturn(dropdownElement);
        when(dropdownElement.getText()).thenReturn("Option 1");

        CommonUtils.DropdownSelectedOptionVerification(dropdownElement, 0, "Dropdown selection failed");
    }

    @Test
    void shouldCaptureScreenshot() throws IOException {
        File file = new File("dummyPath");
        when(takesScreenshot.getScreenshotAs(OutputType.FILE)).thenReturn(file);
        String path = CommonUtils.captureScreenshot(driver, "testScreenshot");
        assertTrue(path.contains("/screenshots/"), "Path should contain '/screenshots/'");
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
        String filePath = "some/path/to/file.txt";
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
        when(driver).thenReturn(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)));
        CommonUtils.waitForElementVisible(driver, dropdownElement);
        verify(driver, times(1)).wait.until(ExpectedConditions.visibilityOf(dropdownElement));
    }

    @Test
    void shouldWaitForElementClickable() {
        when(driver).thenReturn(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)));
        CommonUtils.waitForElementClickable(driver, dropdownElement);
        verify(driver, times(1)).wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
    }

    @Test
    void shouldWaitForPageLoad() {
        when(driver).thenReturn(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME)));
        CommonUtils.waitForPageLoad(driver);
        verify(driver, times(1)).wait.until(any());
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
    void shouldSleepForGivenTime() throws InterruptedException {
        CommonUtils.sleep(1);
        Thread.sleep(1000);
    }
}
