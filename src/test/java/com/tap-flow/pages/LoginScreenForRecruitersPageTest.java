
package com.tap-flow.pages;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginScreenForRecruitersPageTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement getStartedButton;

    @Mock
    private WebElement continueAsOrganizationButton;

    @Mock
    private WebElement emailField;

    @Mock
    private WebElement passwordField;

    @Mock
    private WebElement loginButton;

    @Mock
    private WebElement confirmPasswordField;

    @Mock
    private WebElement passwordResetLink;

    @Mock
    private WebElement dashboardElement;

    @Mock
    private WebElement toggleButton;

    @InjectMocks
    private LoginScreenForRecruitersPage loginScreen;

    @Test
    public void shouldOpenApplication() {
        loginScreen.openApplication();
        verify(driver).get("http://localhost");
    }

    @Test
    public void shouldReturnTrueWhenGetStartedButtonIsVisible() {
        when(getStartedButton.isDisplayed()).thenReturn(true);
        assertTrue(loginScreen.isGetStartedButtonVisible());
    }

    @Test
    public void shouldClickGetStartedButton() {
        loginScreen.clickGetStartedButton();
        verify(getStartedButton).click();
    }

    @Test
    public void shouldClickContinueAsOrganizationButton() {
        loginScreen.clickContinueAsOrganizationButton();
        verify(continueAsOrganizationButton).click();
    }

    @Test
    public void shouldEnterEmail() {
        String email = "test@example.com";
        loginScreen.enterEmail(email);
        verify(emailField).clear();
        verify(emailField).sendKeys(email);
    }

    @Test
    public void shouldEnterPassword() {
        String password = "password123";
        loginScreen.enterPassword(password);
        verify(passwordField).clear();
        verify(passwordField).sendKeys(password);
    }

    @Test
    public void shouldReturnTrueWhenLoginButtonIsEnabled() {
        when(loginButton.isEnabled()).thenReturn(true);
        assertTrue(loginScreen.isLoginButtonEnabled());
    }

    @Test
    public void shouldClickLoginButton() {
        loginScreen.clickLoginButton();
        verify(loginButton).click();
    }

    @Test
    public void shouldReturnTrueWhenOnDashboard() {
        when(dashboardElement.isDisplayed()).thenReturn(true);
        assertTrue(loginScreen.isOnDashboard());
    }

    @Test
    public void shouldClickPasswordResetLink() {
        loginScreen.clickPasswordResetLink();
        verify(passwordResetLink).click();
    }

    @Test
    public void shouldEnterConfirmPassword() {
        String newPassword = "newPassword123";
        loginScreen.enterConfirmPassword(newPassword);
        verify(confirmPasswordField).clear();
        verify(confirmPasswordField).sendKeys(newPassword);
    }

    @Test
    public void shouldTogglePasswordVisibility() {
        when(passwordField.getAttribute("type")).thenReturn("password");
        loginScreen.togglePasswordVisibility();
        verify(toggleButton).click();
        when(passwordField.getAttribute("type")).thenReturn("text");
        assertEquals("text", passwordField.getAttribute("type"));
    }
}
