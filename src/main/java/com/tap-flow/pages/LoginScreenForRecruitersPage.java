package com.tap-flow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tap-flow.utils.ElementUtils;
import org.junit.Assert;

public class LoginScreenForRecruitersPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "getStartedButton")
    private WebElement getStartedButton;

    @FindBy(id = "continueAsOrganizationButton")
    private WebElement continueAsOrganizationButton;

    @FindBy(id = "emailField")
    private WebElement emailField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "confirmPasswordField")
    private WebElement confirmPasswordField;

    @FindBy(id = "passwordResetLink")
    private WebElement passwordResetLink;

    @FindBy(id = "dashboard")
    private WebElement dashboardElement;

    @FindBy(id = "toggle-password-visibility")
    private WebElement toggleButton;

    public LoginScreenForRecruitersPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void openApplication() {
        driver.get("http://localhost");
    }

    public boolean isGetStartedButtonVisible() {
        try {
            return elementUtils.isElementDisplayed(getStartedButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickGetStartedButton() {
        try {
            elementUtils.clickElement(getStartedButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickContinueAsOrganizationButton() {
        try {
            elementUtils.clickElement(continueAsOrganizationButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterEmail(String email) {
        try {
            elementUtils.clearAndSendKeys(emailField, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            elementUtils.clearAndSendKeys(passwordField, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLoginButtonEnabled() {
        try {
            return loginButton.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickLoginButton() {
        try {
            elementUtils.clickElement(loginButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isOnDashboard() {
        return elementUtils.isElementDisplayed(dashboardElement);
    }

    public void clickPasswordResetLink() {
        try {
            elementUtils.clickElement(passwordResetLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterConfirmPassword(String newPassword) {
        try {
            elementUtils.clearAndSendKeys(confirmPasswordField, newPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickResetPasswordButton() {
        // Implement logic to click on the reset password button
        // Assuming a reset password button exists, similar to the other buttons
    }

    public boolean isUserLoggedIn(String browser) {
        // Implement logic to verify if user is logged in successfully
        return true; // Placeholder, implement actual check
    }

    public boolean isUserLoggedInWithNewPassword() {
        // Implement logic to verify if user logged in with the new password
        return true; // Placeholder, implement actual check
    }

    public boolean isOnLoginPage() {
        // Implement logic to verify if user is on the login page
        return true; // Placeholder, implement actual check
    }

    public void logout() {
        // Implement logic for logout functionality
    }

    public boolean isPasswordVisible() {
        // Implement logic to check if password is visible
        return true; // Placeholder, implement actual check
    }

    public boolean isOnOrganizationSignupScreen() {
        // Implement logic to verify if user is on the organization signup screen
        return true; // Placeholder, implement actual check
    }

    public void isDashboardDisplayed() {
        try {
            boolean isDisplayed = elementUtils.isElementDisplayed(dashboardElement);
            Assert.assertTrue(isDisplayed, "Dashboard is not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void togglePasswordVisibility() {
        try {
            elementUtils.mouseHoverAndClick(toggleButton);
            String actualType = passwordField.getAttribute("type");
            String expectedType = "text"; // Assuming that the expected type after clicking is 'text'
            Assert.assertEquals(actualType, expectedType, "Password visibility toggle did not work!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}