package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.tap-flow.driverfactory.DriverFactory;
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
public void the_user_enters_a_valid_keyword_that_matches_existing_event_records(String validKeyword) {
searchEventsPage.enterKeyword(validKeyword);
}
@When("the user clicks the search button")
public void the_user_clicks_the_search_button() {
searchEventsPage.clicksSearchButton();
}
@Then("the system displays only the event records that match the entered keyword")
public void the_system_displays_only_the_event_records_that_match_the_entered_keyword() {
searchEventsPage.areResultsMatchingKeyword();
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
searchEventsPage.doRecordsIncludeRelevantDetails();
}
@Then("the search bar retains the entered keyword for user reference")
public void the_search_bar_retains_the_entered_keyword_for_user_reference() {
searchEventsPage.isKeywordRetainedInSearchBar();
}
@Then("the user can click on an event record to view more details")
public void the_user_can_click_on_an_event_record_to_view_more_details() {
searchEventsPage.canClickEventRecord();
}
@When("the user enters {string}")
public void the_user_enters_keywords(String keywords) {
searchEventsPage.enterKeywords(keywords);
}
@Then("the system displays event records that match the keyword, regardless of case")
public void the_system_displays_event_records_that_match_the_keyword_regardless_of_case(String keyword) {
searchEventsPage.areResultsMatchingKeywordIgnoringCase(keyword);
}
@When("the recruiter enters {string}")
public void the_recruiter_enters_keyword(String keyword) {
searchEventsPage.enterKeyword(keyword);
}
@Then("the system displays a {string} message")
public void the_system_displays_a_message(String message) {
Assert.assertEquals(message, searchEventsPage.getNoRecordsFoundMessage());
}
@Then("the user is not presented with any irrelevant event records")
public void the_user_is_not_presented_with_any_irrelevant_event_records() {
searchEventsPage.noIrrelevantRecordsDisplayed();
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
@Then("the user can navigate through pages of results")
public void the_user_can_navigate_through_pages_of_results() {
searchEventsPage.canNavigatePages();
}
@Then("the user can return to the first page of results")
public void the_user_can_return_to_the_first_page_of_results() {
searchEventsPage.canReturnToFirstPage();
}
@When("the user clicks on the sorting option {string}")
public void the_user_clicks_on_the_sorting_option(String sortingOption) {
searchEventsPage.clicksSortingOption(sortingOption);
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
searchEventsPage.isTotalResultsConsistentAfterSorting();
}
@When("the user performs a search")
public void the_user_performs_a_search() {
searchEventsPage.performSearch();
}
@Then("the user should see the previous state of the Events page")
public void the_user_should_see_the_previous_state_of_the_events_page() {
searchEventsPage.isPreviousStateVisible();
}
@Then("the search bar should retain the keyword {string}")
public void the_search_bar_should_retain_the_keyword(String keyword) {
searchEventsPage.isKeywordRetainedInSearchBar(keyword);
}
@Then("no error or crash occurs in the application")
public void no_error_or_crash_occurs_in_the_application() {
searchEventsPage.isApplicationCrashed();
}
@When("the user logs out")
public void the_user_logs_out() {
searchEventsPage.logout();
}
@When("the user logs in as an admin")
public void the_user_logs_in_as_an_admin() {
searchEventsPage.loginAsAdmin();
}
}