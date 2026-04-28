package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com..driverfactory.DriverFactory;
import com.tap-flow.pages.SearchEventsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchEvents extends DriverFactory {
SearchEventsPage searchEventsPage = new SearchEventsPage(driver);
@Given("the user is on the Events Page")
public void the_user_is_on_the_events_page() {
driver = DriverFactory.getDriver();
searchEventsPage.navigateToEventsPage();
}
@Given("the user locates the search bar")
public void the_user_locates_the_search_bar() {
searchEventsPage.locateSearchBar();
}
@When("the user enters a valid keyword that matches existing event records")
public void the_user_enters_a_valid_keyword_that_matches_existing_event_records(String valid_keyword) {
searchEventsPage.enterKeyword(valid_keyword);
}
@When("the user clicks the search button")
public void the_user_clicks_the_search_button() {
searchEventsPage.clicksSearchButton();
}
@Then("the system displays only the event records that match the entered keyword")
public void the_system_displays_only_the_event_records_that_match_the_entered_keyword() {
searchEventsPage.areMatchingRecordsDisplayed();
}
@Then("the search results are relevant to the keyword entered")
public void the_search_results_are_relevant_to_the_keyword_entered() {
searchEventsPage.areSearchResultsRelevant();
}
@Then("the total number of matching records is displayed")
public void the_total_number_of_matching_records_is_displayed() {
searchEventsPage.isTotalMatchingRecordsDisplayed();
}
@Then("each displayed record includes relevant details")
public void each_displayed_record_includes_relevant_details() {
searchEventsPage.areRecordDetailsRelevant();
}
@Then("the search bar retains the entered keyword for user reference")
public void the_search_bar_retains_the_entered_keyword_for_user_reference() {
searchEventsPage.isKeywordRetained();
}
@Then("the user can click on an event record to view more details")
public void the_user_can_click_on_an_event_record_to_view_more_details() {
searchEventsPage.canClickEventRecord();
}
@When("the user enters <keywords>")
public void the_user_enters_keywords(String keywords) {
searchEventsPage.enterKeywords(keywords);
}
@Then("the system displays only the event records that match any of the entered keywords")
public void the_system_displays_only_the_event_records_that_match_any_of_the_entered_keywords() {
searchEventsPage.areMatchingRecordsDisplayed();
}
@When("the user enters <keyword>")
public void the_user_enters_keyword(String keyword) {
searchEventsPage.enterKeyword(keyword);
}
@Then("the system displays event records that match the keyword, regardless of case")
public void the_system_displays_event_records_that_match_the_keyword_regardless_of_case() {
searchEventsPage.areMatchingRecordsDisplayed();
}
@Then("the system displays a \"No records found\" message")
public void the_system_displays_a_no_records_found_message() {
searchEventsPage.isNoRecordsFoundMessageDisplayed();
}
@Then("the user is not presented with any irrelevant event records")
public void the_user_is_not_presented_with_any_irrelevant_event_records() {
searchEventsPage.areNoIrrelevantRecordsDisplayed();
}
@Then("the user can clearElement the search bar to return to the full list of events")
public void the_user_can_clear_the_search_bar_to_return_to_the_full_list_of_events() {
searchEventsPage.canClearSearchBar();
}
@Then("the user can still access other functionalities on the Events page")
public void the_user_can_still_access_other_functionalities_on_the_events_page() {
searchEventsPage.canAccessOtherFunctionalities();
}
@Then("the user can attempt a new search with a different keyword")
public void the_user_can_attempt_a_new_search_with_a_different_keyword() {
searchEventsPage.canAttemptNewSearch();
}
@Then("pagination controls are visible and functional")
public void pagination_controls_are_visible_and_functional() {
searchEventsPage.arePaginationControlsVisible();
}
@Then("the results should be sorted according to the selected criteria")
public void the_results_should_be_sorted_according_to_the_selected_criteria() {
searchEventsPage.isResultsSorted();
}
@Then("the sorting order is clearly indicated")
public void the_sorting_order_is_clearly_indicated() {
searchEventsPage.isSortingOrderIndicated();
}
@Then("the total number of results remains consistent after sorting")
public void the_total_number_of_results_remains_consistent_after_sorting() {
searchEventsPage.isTotalResultsConsistent();
}
@Then("the user should see the previous state of the Events page")
public void the_user_should_see_the_previous_state_of_the_events_page() {
searchEventsPage.isPreviousStateDisplayed();
}
@Then("the search bar should retain the keyword <keyword>")
public void the_search_bar_should_retain_the_keyword(String keyword) {
searchEventsPage.isKeywordRetained(keyword);
}
@Then("the recruiter should see event records relevant to their role")
public void the_recruiter_should_see_event_records_relevant_to_their_role() {
searchEventsPage.areRecruiterRelevantRecordsDisplayed();
}
@Then("the admin should see event records relevant to their role, which may include additional events")
public void the_admin_should_see_event_records_relevant_to_their_role_which_may_include_additional_events() {
searchEventsPage.areAdminRelevantRecordsDisplayed();
}

@Given("the user enters {string}")
public void the_user_enters_keyword(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@When("the user performs a search")
public void the_user_performs_a_search() {
searchEventsPage.clickSearchButton();
}
@Given("the user enters a keyword that matches a large number of event records")
public void the_user_enters_large_keyword() {
searchEventsPage.enterKeywordInSearchBar("largeKeyword");
}
@Given("the user logs out")
public void the_user_logs_out() {
searchEventsPage.clickLogoutButton();
}
@Then("the search bar retains the entered keywords for user reference")
public void the_search_bar_retains_entered_keywords() {
String expectedKeyword = "largeKeyword"; // This should be dynamic based on the previous step
Assert.assertEquals("The search bar should retain the entered keyword.", expectedKeyword, searchEventsPage.getKeywordFromSearchBar());
}
// DUPLICATE: @Then("the user can clearElement the search bar to return to the full list of events")
// DUPLICATE: public void the_user_can_clear_search_bar() {
// DUPLICATE: searchEventsPage.clearSearchBar();
// DUPLICATE: "The full list of events should be displayed.", searchEventsPage.isFullListDisplayed();
// DUPLICATE: }
@Then("the total number of results is displayed")
public void the_total_number_of_results_is_displayed() {
"The total number of results should be displayed.", searchEventsPage.isTotalResultsDisplayed();
}
@Then("the user can switch between different sorting options")
public void the_user_can_switch_sorting_options() {
searchEventsPage.switchSortingOptions();
}
@Given("the recruiter enters {string}")
public void the_recruiter_enters_keyword(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@Then("the user should see the full list of events before the search")
public void the_user_should_see_full_list_before_search() {
"The full list of events should be displayed before the search.", searchEventsPage.isFullListDisplayed();
}
@Then("the user can navigate through pages of results")
public void the_user_can_navigate_pages() {
searchEventsPage.navigateThroughPages();
}
@Given("the user logs in as an admin")
public void the_user_logs_in_as_admin() {
searchEventsPage.loginAsAdmin();
}
@Then("no error or crash occurs in the application")
public void no_error_or_crash_occurs() {
"The application should be stable without errors.", searchEventsPage.isApplicationStable();
}
@Then("the search results are relevant to the keywords entered")
public void the_search_results_are_relevant() {
"The search results should be relevant to the keywords entered.", searchEventsPage.areResultsRelevant();
}
@When("the user clicks on the sorting option {string}")
public void the_user_clicks_on_sorting_option(String sortingOption) {
searchEventsPage.selectSortingOption(sortingOption);
}
@Then("each displayed record should include relevant details")
public void each_displayed_record_should_include_details() {
"Each displayed record should include relevant details.", searchEventsPage.areRecordsDetailsRelevant();
}
@When("the recruiter clicks the search button")
public void the_recruiter_clicks_search_button() {
searchEventsPage.clickSearchButton();
}
@Then("the system displays a limited number of results per page")
public void the_system_displays_limited_results_per_page() {
"The system should display a limited number of results per page.", searchEventsPage.isLimitedResultsPerPageDisplayed();
}
@Then("the user can perform a new search if desired")
public void the_user_can_perform_new_search() {
searchEventsPage.performNewSearch();
}
@Then("the system displays a no records found message")
public void the_system_displays_no_records_found_message() {
"The system should display a no records found message.", searchEventsPage.isNoRecordsFoundMessageDisplayed();
}
@Then("the user can access other functionalities on the events page")
public void the_user_can_access_other_functionalities() {
"The user should be able to access other functionalities on the events page.", searchEventsPage.areOtherFunctionalitiesAccessible();
}
@Then("the system displays event records that match the keyword with special characters")
public void the_system_displays_event_records_with_special_characters() {
"The system should display event records that match the keyword with special characters.", searchEventsPage.areRecordsDisplayedWithSpecialCharacters();
}
@Then("the results load")
public void the_results_load() {
"The results should load successfully.", searchEventsPage.areResultsLoaded();
}
@When("the user enters {string} in the search bar")
public void the_user_enters_in_search_bar(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@Then("the user waits for the results to load")
public void the_user_waits_for_results_to_load() {
searchEventsPage.waitForResultsToLoad();
}
@Then("the search bar should retain the keyword {string}")
public void the_search_bar_should_retain_keyword(String keyword) {
Assert.assertEquals("The search bar should retain the keyword.", keyword, searchEventsPage.getKeywordFromSearchBar());
}
@Then("the user can return to the first page of results")
public void the_user_can_return_to_first_page() {
searchEventsPage.returnToFirstPage();
}
@When("the user clicks on the browser back button")
public void the_user_clicks_browser_back_button() {
searchEventsPage.clickBrowserBackButton();
}
@Then("the total number of matching records should be displayed")
public void the_total_number_of_matching_records_displayed() {
"The total number of matching records should be displayed.", searchEventsPage.isTotalMatchingRecordsDisplayed();
}
}