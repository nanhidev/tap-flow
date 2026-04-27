package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.tap-flow.pages.LoginScreenForRecruitersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginScreenForRecruiters extends DriverFactory {
LoginScreenForRecruitersPage loginScreenForRecruitersPage = new LoginScreenForRecruitersPage(driver);
@Given("the user has opened the application")
public void the_user_has_opened_the_application() {
driver = DriverFactory.getDriver();
}
@And("the 'Get Started' button is visible")
public void the_get_started_button_is_visible() {
"Get Started button should be visible", loginScreenForRecruitersPage.isGetStartedButtonVisible();
}
@When("the user clicks on the 'Get Started' button")
public void the_user_clicks_on_the_get_started_button() {
loginScreenForRecruitersPage.clickGetStartedButton();
}
@Then("the user should be navigated to the Organization signup screen")
public void the_user_should_be_navigated_to_the_organization_signup_screen() {
"User should be on Organization signup screen", loginScreenForRecruitersPage.isOnOrganizationSignupScreen();
}
@When("the user clicks on the 'Continue as Organization' button")
public void the_user_clicks_on_the_continue_as_organization_button() {
loginScreenForRecruitersPage.clickContinueAsOrganizationButton();
}
@Then("the user should be navigated to the Login page")
public void the_user_should_be_navigated_to_the_login_page() {
"User should be on Login page", loginScreenForRecruitersPage.isOnLoginPage();
}
@Given("the user enters {string} in the Email field")
public void the_user_enters_email_in_the_email_field(String email) {
loginScreenForRecruitersPage.enterEmail(email);
}
@Given("the user enters {string} in the Password field")
public void the_user_enters_password_in_the_password_field(String password) {
loginScreenForRecruitersPage.enterPassword(password);
}
@Then("the Login button should be enabled")
public void the_login_button_should_be_enabled() {
"Login button should be enabled", loginScreenForRecruitersPage.isLoginButtonEnabled();
}
@When("the user clicks on the Login button")
public void the_user_clicks_on_the_login_button() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should be redirected to the dashboard")
public void the_user_should_be_redirected_to_the_dashboard() {
"User should be redirected to the dashboard", loginScreenForRecruitersPage.isDashboardDisplayed();
}
@When("I enter {string} in the Password field")
public void i_enter_password_in_the_password_field(String password) {
loginScreenForRecruitersPage.enterPassword(password);
}
@When("I click on the 'Show/Hide Password' option")
public void i_click_on_the_show_hide_password_option() {
loginScreenForRecruitersPage.togglePasswordVisibility();
}
@Then("the password should be visible")
public void the_password_should_be_visible() {
"Password should be visible", loginScreenForRecruitersPage.isPasswordVisible();
}
@Then("the password should be hidden")
public void the_password_should_be_hidden() {
"Password should be hidden", loginScreenForRecruitersPage.isPasswordVisible();
}
@Given("the user opens the application on a {string}")
public void the_user_opens_the_application_on_a_device(String device) {
loginScreenForRecruitersPage.openApplicationOnDevice(device);
}
@When("the user logs in")
public void the_user_logs_in() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should log in successfully in {string}")
public void the_user_should_log_in_successfully_in_browser(String browser) {
"User should log in successfully in " + browser, loginScreenForRecruitersPage.isUserLoggedInSuccessfully(browser);
}
@Given("the user clicks on the password reset link in the email")
public void the_user_clicks_on_the_password_reset_link_in_the_email() {
loginScreenForRecruitersPage.clickPasswordResetLink();
}
@Then("the password is reset successfully")
public void the_password_is_reset_successfully() {
"Password should be reset successfully", loginScreenForRecruitersPage.isPasswordResetSuccessful();
}
@Given("the user confirms {string} in the Confirm Password field")
public void the_user_confirms_new_password_in_the_confirm_password_field(String newPassword) {
loginScreenForRecruitersPage.confirmNewPassword(newPassword);
}
@Then("the user logs in successfully with the new password")
public void the_user_logs_in_successfully_with_the_new_password() {
"User should log in successfully with the new password", loginScreenForRecruitersPage.isUserLoggedInSuccessfullyWithNewPassword();
}

@Given("the user enters {string} in the email field")
public void the_user_enters_in_the_email_field(String email) {
loginScreenForRecruitersPage.enterEmail(email);
}
@When("the user enters a valid password {string} in the password field")
public void the_user_enters_a_valid_password_in_the_password_field(String password) {
loginScreenForRecruitersPage.enterPassword(password);
}
@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should be logged in successfully")
public void the_user_should_be_logged_in_successfully() {
loginScreenForRecruitersPage.isUserLoggedIn();
}
@Then("the dashboard should load successfully")
public void the_dashboard_should_load_successfully() {
loginScreenForRecruitersPage.isDashboardLoaded();
}
@When("the user clicks on the 'show/hide password' option")
public void the_user_clicks_on_the_show_hide_password_option() {
loginScreenForRecruitersPage.toggleShowHidePassword();
}
// DUPLICATE: @When("the user logs out")
// DUPLICATE: public void the_user_logs_out() {
// DUPLICATE: loginScreenForRecruitersPage.logout();
// DUPLICATE: }
@Then("the user should be redirected to the login page")
public void the_user_should_be_redirected_to_the_login_page() {
loginScreenForRecruitersPage.isOnLoginPage();
}
@When("i enter {string} {string}")
public void i_enter(String email, String password) {
loginScreenForRecruitersPage.enterEmail(email);
loginScreenForRecruitersPage.enterPassword(password);
}
@Then("the user confirms {string}")
public void the_user_confirms(String confirmationMessage) {
Assert.assertEquals(confirmationMessage, loginScreenForRecruitersPage.getConfirmationMessage());
}
@Then("the dashboard is displayed without errors")
public void the_dashboard_is_displayed_without_errors() {
loginScreenForRecruitersPage.isDashboardDisplayedWithoutErrors();
}
@Then("the login button is enabled")
public void the_login_button_is_enabled() {
loginScreenForRecruitersPage.isLoginButtonEnabled();
}
@Then("the user should be directed to the dashboard")
public void the_user_should_be_directed_to_the_dashboard() {
loginScreenForRecruitersPage.isOnDashboard();
}
@When("the user clicks on the 'reset password' button")
public void the_user_clicks_on_the_reset_password_button() {
loginScreenForRecruitersPage.clickResetPasswordButton();
}
@When("i log in")
public void i_log_in() {
loginScreenForRecruitersPage.performLogin();
}
// DUPLICATE: @Then("the user should log in successfully in {string}")
public void the_user_should_log_in_successfully_in(String browser) {
loginScreenForRecruitersPage.isUserLoggedInInBrowser(browser);
}
@When("the user logs in successfully on {string}")
public void the_user_logs_in_successfully_on(String device) {
loginScreenForRecruitersPage.loginSuccessfullyOnDevice(device);
}
@Then("the user should be logged in successfully in chrome")
public void the_user_should_be_logged_in_successfully_in_chrome() {
loginScreenForRecruitersPage.isUserLoggedInInBrowser("chrome");
}
@Then("the user should be logged in successfully in firefox")
public void the_user_should_be_logged_in_successfully_in_firefox() {
loginScreenForRecruitersPage.isUserLoggedInInBrowser("firefox");
}
@Then("the user should be logged in successfully in safari")
public void the_user_should_be_logged_in_successfully_in_safari() {
loginScreenForRecruitersPage.isUserLoggedInInBrowser("safari");
}
@Then("the user logs in successfully on desktop")
public void the_user_logs_in_successfully_on_desktop() {
loginScreenForRecruitersPage.loginSuccessfullyOnDevice("desktop");
}
@Then("the user logs in successfully on tablet")
public void the_user_logs_in_successfully_on_tablet() {
loginScreenForRecruitersPage.loginSuccessfullyOnDevice("tablet");
}
@Then("the user logs in successfully on mobile")
public void the_user_logs_in_successfully_on_mobile() {
loginScreenForRecruitersPage.loginSuccessfullyOnDevice("mobile");
}
@When("i clickElement on the 'show/hide password' option again")
public void i_click_on_the_show_hide_password_option_again() {
loginScreenForRecruitersPage.toggleShowHidePassword();
}
@When("i clickElement on the login button")
public void i_click_on_the_login_button() {
loginScreenForRecruitersPage.clickLoginButton();
}
}