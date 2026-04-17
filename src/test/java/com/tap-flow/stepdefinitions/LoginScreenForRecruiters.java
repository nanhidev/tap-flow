package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.tap-flow.driverfactory.DriverFactory;
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
loginScreenForRecruitersPage.openApplication();
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
@And("the user enters {string} in the Password field")
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
"User should be redirected to the dashboard", loginScreenForRecruitersPage.isOnDashboard();
}
@And("the dashboard is displayed")
public void the_dashboard_is_displayed() {
"Dashboard should be displayed", loginScreenForRecruitersPage.isDashboardDisplayed();
}
@When("I enter {string} in the Password field")
public void i_enter_password_in_the_password_field(String password) {
loginScreenForRecruitersPage.enterPassword(password);
}
@And("I click on the 'Show/Hide Password' option")
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
@When("I log in")
public void i_log_in() {
loginScreenForRecruitersPage.clickLoginButton();
}
@Then("the user should be logged in successfully in {string}")
public void the_user_should_be_logged_in_successfully_in(String browser) {
"User should be logged in successfully in " + browser, loginScreenForRecruitersPage.isUserLoggedIn(browser);
}
@And("the user logs out")
public void the_user_logs_out() {
loginScreenForRecruitersPage.logout();
}
@When("the user clicks on the password reset link in the email")
public void the_user_clicks_on_the_password_reset_link_in_the_email() {
loginScreenForRecruitersPage.clickPasswordResetLink();
}
@And("the user enters {string} in the Confirm Password field")
public void the_user_enters_new_password_in_the_confirm_password_field(String newPassword) {
loginScreenForRecruitersPage.enterConfirmPassword(newPassword);
}
@And("the user clicks on the 'Reset Password' button")
public void the_user_clicks_on_the_reset_password_button() {
loginScreenForRecruitersPage.clickResetPasswordButton();
}
@Then("the user logs in successfully with the new password")
public void the_user_logs_in_successfully_with_the_new_password() {
"User should log in successfully with the new password", loginScreenForRecruitersPage.isUserLoggedInWithNewPassword();
}

@Given("the user opens the application on a {string}")
public void the_user_opens_the_application_on_a_browser(String browser) {
driver = DriverFactory.getDriver(browser);
}
@When("the user enters a valid password {string} in the password field")
public void the_user_enters_a_valid_password_in_the_password_field(String password) {
loginScreen.enterPassword(password);
}
@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
loginScreen.clickLoginButton();
}
@Then("the user should be logged in successfully")
public void the_user_should_be_logged_in_successfully() {
loginScreen.isUserLoggedIn();
}
@Then("the user should be directed to the dashboard")
public void the_user_should_be_directed_to_the_dashboard() {
loginScreen.isOnDashboard();
}
// DUPLICATE: @Then("the user should be logged in successfully in {string}")
public void the_user_should_be_logged_in_successfully_in_browser(String browser) {
loginScreen.isUserLoggedIn();
}
@When("i clickElement on the 'show/hide password' option again")
public void i_click_on_the_show_hide_password_option_again() {
loginScreen.toggleShowHidePassword();
}
@Then("the login button is enabled")
public void the_login_button_is_enabled() {
loginScreen.isLoginButtonEnabled();
}
@When("the user confirms {string} in the confirm password field")
public void the_user_confirms_in_the_confirm_password_field(String confirmPassword) {
loginScreen.confirmPassword(confirmPassword);
}
@When("i enter {string} in the email field")
public void i_enter_in_the_email_field(String email) {
loginScreen.enterEmail(email);
}
@When("the user enters {string}")
public void the_user_enters(String username) {
loginScreen.enterUsername(username);
}
@Then("the user should be redirected to the login page")
public void the_user_should_be_redirected_to_the_login_page() {
loginScreen.isOnLoginPage();
}
@When("i log out")
public void i_log_out() {
loginScreen.logOut();
}
}