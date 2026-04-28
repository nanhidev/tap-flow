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
"Expected matching records to be displayed", searchEventsPage.areResultsMatchingKeyword();
}
@Then("the search results are relevant to the keyword entered")
public void the_search_results_are_relevant_to_the_keyword_entered() {
"Expected search results to be relevant", searchEventsPage.areResultsRelevant();
}
@Then("the total number of matching records is displayed")
public void the_total_number_of_matching_records_is_displayed() {
"Expected total matching records to be displayed", searchEventsPage.isTotalMatchingRecordsDisplayed();
}
@Then("each displayed record includes relevant details")
public void each_displayed_record_includes_relevant_details() {
"Expected each record to include relevant details", searchEventsPage.areDetailsRelevant();
}
@Then("the search bar retains the entered keyword for user reference")
public void the_search_bar_retains_the_entered_keyword_for_user_reference() {
"Expected search bar to retain the entered keyword", searchEventsPage.isKeywordRetained();
}
@Then("the user can click on an event record to view more details")
public void the_user_can_click_on_an_event_record_to_view_more_details() {
"Expected user to be able to clickElement on an event record", searchEventsPage.canClickEventRecord();
}
@When("the user enters {string}")
public void the_user_enters_keywords(String keywords) {
searchEventsPage.enterKeywords(keywords);
}
@Then("the system displays only the event records that match any of the entered keywords")
public void the_system_displays_only_the_event_records_that_match_any_of_the_entered_keywords() {
"Expected matching records for any of the entered keywords", searchEventsPage.areResultsMatchingAnyKeyword();
}
@Then("the system displays event records that match the keyword, regardless of case")
public void the_system_displays_event_records_that_match_the_keyword_regardless_of_case() {
"Expected case insensitive matching records", searchEventsPage.areResultsCaseInsensitive();
}
@Then("the system displays a \"No records found\" message")
public void the_system_displays_a_no_records_found_message() {
"Expected 'No records found' message to be displayed", searchEventsPage.isNoRecordsFoundMessageDisplayed();
}
@Then("the user is not presented with any irrelevant event records")
public void the_user_is_not_presented_with_any_irrelevant_event_records() {
"Expected no irrelevant records to be displayed", searchEventsPage.areNoIrrelevantRecordsDisplayed();
}
@Then("the user can clearElement the search bar to return to the full list of events")
public void the_user_can_clear_the_search_bar_to_return_to_the_full_list_of_events() {
"Expected user to be able to clearElement the search bar", searchEventsPage.canClearSearchBar();
}
@Then("the user can still access other functionalities on the Events page")
public void the_user_can_still_access_other_functionalities_on_the_events_page() {
"Expected user to access other functionalities", searchEventsPage.canAccessOtherFunctionalities();
}
@Then("the user can attempt a new search with a different keyword")
public void the_user_can_attempt_a_new_search_with_a_different_keyword() {
"Expected user to attempt a new search", searchEventsPage.canAttemptNewSearch();
}
@Then("pagination controls are visible and functional")
public void pagination_controls_are_visible_and_functional() {
"Expected pagination controls to be visible", searchEventsPage.arePaginationControlsVisible();
}
@Then("the results should be sorted according to the selected criteria")
public void the_results_should_be_sorted_according_to_the_selected_criteria() {
"Expected results to be sorted correctly", searchEventsPage.isResultsSorted();
}
@Then("the sorting order is clearly indicated")
public void the_sorting_order_is_clearly_indicated() {
"Expected sorting order to be indicated", searchEventsPage.isSortingOrderIndicated();
}
@Then("the total number of results remains consistent after sorting")
public void the_total_number_of_results_remains_consistent_after_sorting() {
"Expected total results to remain consistent after sorting", searchEventsPage.isTotalResultsConsistent();
}
@Then("the user should see the previous state of the Events page")
public void the_user_should_see_the_previous_state_of_the_events_page() {
"Expected previous state of Events page to be displayed", searchEventsPage.isPreviousStateDisplayed();
}
@Then("the search bar should retain the keyword {string}")
public void the_search_bar_should_retain_the_keyword(String keyword) {
"Expected search bar to retain the keyword", searchEventsPage.isKeywordRetained(keyword);
}
@Then("the recruiter should see event records relevant to their role")
public void the_recruiter_should_see_event_records_relevant_to_their_role() {
"Expected recruiter to see relevant event records", searchEventsPage.areRecruiterRelevantRecordsDisplayed();
}
@Then("the admin should see event records relevant to their role, which may include additional events")
public void the_admin_should_see_event_records_relevant_to_their_role_which_may_include_additional_events() {
"Expected admin to see relevant event records", searchEventsPage.areAdminRelevantRecordsDisplayed();
}

@Given("the user logs in as an admin")
public void the_user_logs_in_as_an_admin() {
searchEventsPage.loginAsAdmin();
}
@When("the user enters {string} in the search bar")
public void the_user_enters_in_the_search_bar(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@And("the recruiter clicks the search button")
public void the_recruiter_clicks_the_search_button() {
searchEventsPage.clicksSearchButton();
}
@Then("the system displays a limited number of results per page")
public void the_system_displays_a_limited_number_of_results_per_page() {
searchEventsPage.isLimitedResultsDisplayed();
}
@Then("each displayed record should include relevant details")
public void each_displayed_record_should_include_relevant_details() {
searchEventsPage.areRelevantDetailsDisplayed();
}
@Then("the total number of matching records should be displayed")
public void the_total_number_of_matching_records_should_be_displayed() {
searchEventsPage.isTotalNumberOfRecordsDisplayed();
}
@Then("no error or crash occurs in the application")
public void no_error_or_crash_occurs_in_the_application() {
searchEventsPage.isApplicationCrashed();
}
@When("the user logs out")
public void the_user_logs_out() {
searchEventsPage.logout();
}
@Then("the search bar retains the entered keywords for user reference")
public void the_search_bar_retains_the_entered_keywords_for_user_reference() {
searchEventsPage.isSearchBarRetainingKeywords();
}
@Then("the user can return to the first page of results")
public void the_user_can_return_to_the_first_page_of_results() {
searchEventsPage.returnToFirstPage();
}
@Then("the user can switch between different sorting options")
public void the_user_can_switch_between_different_sorting_options() {
searchEventsPage.canSwitchSortingOptions();
}
@Then("the results load")
public void the_results_load() {
searchEventsPage.areResultsLoaded();
}
@Then("the search results are relevant to the keywords entered")
public void the_search_results_are_relevant_to_the_keywords_entered() {
searchEventsPage.areSearchResultsRelevant();
}
@Then("the system displays a no records found message")
public void the_system_displays_a_no_records_found_message() {
searchEventsPage.isNoRecordsFoundMessageDisplayed();
}
@When("the user enters the keyword {string}")
public void the_user_enters_the_keyword(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@Then("the total number of results is displayed")
public void the_total_number_of_results_is_displayed() {
searchEventsPage.isTotalResultsDisplayed();
}
@Then("the user should see the full list of events before the search")
public void the_user_should_see_the_full_list_of_events_before_the_search() {
searchEventsPage.isFullListOfEventsDisplayed();
}
@Then("the user can perform a new search if desired")
public void the_user_can_perform_a_new_search_if_desired() {
searchEventsPage.canPerformNewSearch();
}
@When("the user performs a search")
public void the_user_performs_a_search() {
searchEventsPage.performSearch();
}
@Then("the user can access other functionalities on the events page")
public void the_user_can_access_other_functionalities_on_the_events_page() {
searchEventsPage.canAccessOtherFunctionalities();
}
@When("the recruiter enters {string}")
public void the_recruiter_enters(String keyword) {
searchEventsPage.enterKeywordInSearchBar(keyword);
}
@Then("the user can navigate through pages of results")
public void the_user_can_navigate_through_pages_of_results() {
searchEventsPage.canNavigatePages();
}
@Then("the user waits for the results to load")
public void the_user_waits_for_the_results_to_load() {
searchEventsPage.waitForResultsToLoad();
}
// DUPLICATE: @Then("the user can clearElement the search bar to return to the full list of events")
// DUPLICATE: public void the_user_can_clear_the_search_bar_to_return_to_the_full_list_of_events() {
// DUPLICATE: searchEventsPage.clearSearchBar();
// DUPLICATE: }
@When("the user clicks on the browser back button")
public void the_user_clicks_on_the_browser_back_button() {
searchEventsPage.clickBrowserBackButton();
}
@When("the user enters a keyword that matches a large number of event records")
public void the_user_enters_a_keyword_that_matches_a_large_number_of_event_records() {
searchEventsPage.enterKeywordForLargeRecords();
}
@Then("the system displays event records that match the keyword with special characters")
public void the_system_displays_event_records_that_match_the_keyword_with_special_characters() {
searchEventsPage.areRecordsDisplayedWithSpecialCharacters();
}
@When("the user clicks on the sorting option {string}")
public void the_user_clicks_on_the_sorting_option(String sortingOption) {
searchEventsPage.clickSortingOption(sortingOption);
}
}