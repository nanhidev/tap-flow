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
loginScreenForRecruitersPage.isGetStartedButtonVisible();
}
@When("the user clicks on the 'Get Started' button")
public void the_user_clicks_on_the_get_started_button() {
loginScreenForRecruitersPage.clickGetStartedButton();
}
@Then("the user should be navigated to the Organization signup screen")
public void the_user_should_be_navigated_to_the_organization_signup_screen() {
loginScreenForRecruitersPage.isOnOrganizationSignupScreen();
}
@When("the user clicks on the 'Continue as Organization' button")
public void the_user_clicks_on_the_continue_as_organization_button() {
loginScreenForRecruitersPage.clickContinueAsOrganizationButton();
}
@Then("the user should be navigated to the Login page")
public void the_user_should_be_navigated_to_the_login_page() {
loginScreenForRecruitersPage.isOnLoginPage();
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
loginScreenForRecruitersPage.isLoginButtonEnabled();
}
@When("the user clicks on the Login button")
public void the_user_clicks_on_the_login_button() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should be redirected to the dashboard")
public void the_user_should_be_redirected_to_the_dashboard() {
loginScreenForRecruitersPage.isDashboardDisplayed();
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
loginScreenForRecruitersPage.isPasswordVisible();
}
@Then("the password should be hidden")
public void the_password_should_be_hidden() {
loginScreenForRecruitersPage.isPasswordVisible();
}
@Given("the user opens the application on a {string}")
public void the_user_opens_the_application_on_a_device(String device) {
loginScreenForRecruitersPage.openApplicationOnDevice(device);
}
@When("the user logs in")
public void the_user_logs_in() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should log in successfully")
public void the_user_should_log_in_successfully() {
loginScreenForRecruitersPage.isUserLoggedIn();
}
@Given("the user clicks on the password reset link in the email")
public void the_user_clicks_on_the_password_reset_link_in_the_email() {
loginScreenForRecruitersPage.clickPasswordResetLink();
}
@Given("the user confirms {string} in the Confirm Password field")
public void the_user_confirms_new_password_in_the_confirm_password_field(String newPassword) {
loginScreenForRecruitersPage.confirmNewPassword(newPassword);
}
@Then("the password is reset successfully")
public void the_password_is_reset_successfully() {
loginScreenForRecruitersPage.isPasswordResetSuccessful();
}
@Then("the user logs in successfully with the new password")
public void the_user_logs_in_successfully_with_the_new_password() {
loginScreenForRecruitersPage.isUserLoggedIn();
}

// DUPLICATE: @Given("the user enters {string}")
public void the_user_enters(String email) {
loginScreen.enterEmail(email);
}
@Then("the user should be logged in successfully in chrome")
public void the_user_should_be_logged_in_successfully_in_chrome() {
loginScreen.isUserLoggedIn();
}
@Then("the user should be redirected to the login page")
public void the_user_should_be_redirected_to_the_login_page() {
loginScreen.isLoginPageDisplayed();
}
@And("the user clicks on the 'show/hide password' option")
public void the_user_clicks_on_show_hide_password_option() {
loginScreen.togglePasswordVisibility();
}
@When("i log in")
public void i_log_in() {
loginScreen.performLogin();
}
@When("i clickElement on the 'show/hide password' option again")
public void i_click_on_show_hide_password_option_again() {
loginScreen.togglePasswordVisibility();
}
@Then("the user is redirected to the login page")
public void the_user_is_redirected_to_the_login_page() {
loginScreen.isLoginPageDisplayed();
}
@Then("the user logs out")
public void the_user_logs_out() {
loginScreen.logout();
}
@When("i clickElement on the login button")
public void i_click_on_the_login_button() {
loginScreen.clickLoginButton();
}
@Then("the user should be logged in successfully")
public void the_user_should_be_logged_in_successfully() {
loginScreen.isUserLoggedIn();
}
@Then("the dashboard should load successfully")
public void the_dashboard_should_load_successfully() {
loginScreen.isDashboardLoaded();
}
@Then("the login button is enabled")
public void the_login_button_is_enabled() {
loginScreen.isLoginButtonEnabled();
}
@Then("the dashboard is displayed")
public void the_dashboard_is_displayed() {
loginScreen.isDashboardDisplayed();
}
@Then("the user should be directed to the dashboard")
public void the_user_should_be_directed_to_the_dashboard() {
loginScreen.isDashboardDisplayed();
}
@When("the user clicks on the 'reset password' button")
public void the_user_clicks_on_reset_password_button() {
loginScreen.clickResetPasswordButton();
}
@Given("the user enters password {string} }")
public void the_user_enters_password_and_confirmation(String password, String confirmPassword) {
loginScreen.enterPassword(password);
loginScreen.confirmPassword(confirmPassword);
}
@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
loginScreen.clickLoginButton();
}
@Then("the dashboard is displayed without errors")
public void the_dashboard_is_displayed_without_errors() {
loginScreen.isDashboardDisplayedWithoutErrors();
}
@Then("the user logs in successfully on tablet")
public void the_user_logs_in_successfully_on_tablet() {
loginScreen.isUserLoggedInOnTablet();
}
@Then("the user should log in successfully in chrome")
public void the_user_should_log_in_successfully_in_chrome() {
loginScreen.isUserLoggedIn();
}
@Then("i log out")
public void i_log_out() {
loginScreen.logout();
}
@Given("the user enters a valid password {string} in the password field")
public void the_user_enters_a_valid_password_in_the_password_field(String password) {
loginScreen.enterPassword(password);
}
@Given("the user confirms {string}")
public void the_user_confirms(String confirmPassword) {
loginScreen.confirmPassword(confirmPassword);
}
@Then("the user should be logged in successfully in firefox")
public void the_user_should_be_logged_in_successfully_in_firefox() {
loginScreen.isUserLoggedIn();
}
@Then("the user logs in successfully on desktop")
public void the_user_logs_in_successfully_on_desktop() {
loginScreen.isUserLoggedInOnDesktop();
}
@When("the user clicks on the 'show/hide password' option again")
public void the_user_clicks_on_show_hide_password_option_again() {
loginScreen.togglePasswordVisibility();
}
@Given("i enter a valid password {string} in the password field")
public void i_enter_a_valid_password_in_the_password_field(String password) {
loginScreen.enterPassword(password);
}
@Then("the user should log in successfully in safari")
public void the_user_should_log_in_successfully_in_safari() {
loginScreen.isUserLoggedIn();
}
@Given("i enter {string} in the email field")
public void i_enter_in_the_email_field(String email) {
loginScreen.enterEmail(email);
}
@Given("i enter {string} {string}")
public void i_enter(String password, String confirmPassword) {
loginScreen.enterPassword(password);
loginScreen.confirmPassword(confirmPassword);
}
@Then("the user logs in successfully on mobile")
public void the_user_logs_in_successfully_on_mobile() {
loginScreen.isUserLoggedInOnMobile();
}
@Then("the user should be logged in successfully in safari")
public void the_user_should_be_logged_in_successfully_in_safari() {
loginScreen.isUserLoggedIn();
}
}