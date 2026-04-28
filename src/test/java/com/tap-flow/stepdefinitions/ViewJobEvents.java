package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.tap-flow.pages.ViewJobEventsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ViewJobEvents extends DriverFactory {
ViewJobEventsPage viewJobEventsPage = new ViewJobEventsPage(driver);
@Given("the user is logged in to the recruitment system")
public void the_user_is_logged_in_to_the_recruitment_system() {
viewJobEventsPage.loginToRecruitmentSystem();
}
@Given("the user navigates to the job openings list")
public void the_user_navigates_to_the_job_openings_list() {
viewJobEventsPage.navigateToJobOpeningsList();
}
@Given("the user selects a specific job opening card")
public void the_user_selects_a_specific_job_opening_card() {
viewJobEventsPage.selectJobOpeningCard();
}
@Given("the user clicks on the Events button on the job opening card")
public void the_user_clicks_on_the_events_button_on_the_job_opening_card() {
viewJobEventsPage.clicksEventsButton();
}
@Then("the user is navigated to the events page")
public void the_user_is_navigated_to_the_events_page() {
viewJobEventsPage.isEventsPageDisplayed();
}
@Then("the URL reflects the events page for the selected job opening")
public void the_url_reflects_the_events_page_for_the_selected_job_opening() {
viewJobEventsPage.isUrlCorrectForJobOpening();
}
@When("the user clicks on the {string} button for a job opening")
public void the_user_clicks_on_the_button_for_a_job_opening(String buttonName) {
viewJobEventsPage.clicksButton(buttonName);
}
@Then("the events page loads successfully")
public void the_events_page_loads_successfully() {
viewJobEventsPage.isEventsPageLoaded();
}
@Then("the events are displayed in a card-based layout")
public void the_events_are_displayed_in_a_card_based_layout() {
viewJobEventsPage.isEventsDisplayedInCardLayout();
}
@Then("each event card contains candidate name, email, date & time, and status")
public void each_event_card_contains_candidate_name_email_date_time_and_status() {
viewJobEventsPage.areEventCardsComplete();
}
@Then("the user can scroll through multiple events")
public void the_user_can_scroll_through_multiple_events() {
viewJobEventsPage.canScrollThroughEvents();
}
@Then("the card design is consistent with the application’s UI guidelines")
public void the_card_design_is_consistent_with_the_application_s_ui_guidelines() {
viewJobEventsPage.isCardDesignConsistent();
}
@When("the user waits for the events page to load")
public void the_user_waits_for_the_events_page_to_load() {
viewJobEventsPage.waitForEventsPageToLoad();
}
@When("the user identifies the first event card displayed")
public void the_user_identifies_the_first_event_card_displayed() {
viewJobEventsPage.identifyFirstEventCard();
}
@When("the user notes the candidate name, email, date & time, and status")
public void the_user_notes_the_candidate_name_email_date_time_and_status() {
viewJobEventsPage.noteEventCardDetails();
}
@When("the user cross-references the details with the job opening’s event records")
public void the_user_cross_references_the_details_with_the_job_opening_s_event_records() {
viewJobEventsPage.crossReferenceEventDetails();
}
@Then("the first event card displays accurate candidate name, email, date & time, and status")
public void the_first_event_card_displays_accurate_candidate_name_email_date_time_and_status() {
viewJobEventsPage.isFirstEventCardDetailsAccurate();
}
@Then("the details match the job opening’s event records")
public void the_details_match_the_job_opening_s_event_records() {
viewJobEventsPage.doDetailsMatchEventRecords();
}
@Then("all event cards reflect accurate information")
public void all_event_cards_reflect_accurate_information() {
viewJobEventsPage.doAllEventCardsReflectAccurateInfo();
}
@Then("the user observes the order of event cards displayed")
public void the_user_observes_the_order_of_event_cards_displayed() {
viewJobEventsPage.isOrderOfEventCardsCorrect();
}
@When("the user identifies the date and time of the first and last event cards")
public void the_user_identifies_the_date_and_time_of_the_first_and_last_event_cards() {
viewJobEventsPage.identifyFirstAndLastEventCardDateTime();
}
@Then("the events are in chronological order")
public void the_events_are_in_chronological_order() {
viewJobEventsPage.areEventsInChronologicalOrder();
}
@Then("the first event card has the earliest date and time")
public void the_first_event_card_has_the_earliest_date_and_time() {
viewJobEventsPage.isFirstEventCardEarliest();
}
@Then("the last event card has the latest date and time")
public void the_last_event_card_has_the_latest_date_and_time() {
viewJobEventsPage.isLastEventCardLatest();
}
@Then("the events with the same date and time are displayed consistently")
public void the_events_with_the_same_date_and_time_are_displayed_consistently() {
viewJobEventsPage.areSameDateTimeEventsConsistent();
}
@Then("each event card should display a status")
public void each_event_card_should_display_a_status() {
viewJobEventsPage.doEventCardsDisplayStatus();
}
@Then("the statuses should match the job opening’s event records")
public void the_statuses_should_match_the_job_opening_s_event_records() {
viewJobEventsPage.doStatusesMatchEventRecords();
}
@Then("the statuses should be visually distinct and easy to identify")
public void the_statuses_should_be_visually_distinct_and_easy_to_identify() {
viewJobEventsPage.areStatusesVisuallyDistinct();
}
@When("the user locates the filter options for event statuses")
public void the_user_locates_the_filter_options_for_event_statuses() {
viewJobEventsPage.locateFilterOptions();
}
@When("the user selects the status {string}")
public void the_user_selects_the_status(String status) {
viewJobEventsPage.selectStatus(status);
}
@When("the user applies the filter")
public void the_user_applies_the_filter() {
viewJobEventsPage.applyFilter();
}
@Then("the user should see only events with the selected status displayed")
public void the_user_should_see_only_events_with_the_selected_status_displayed() {
viewJobEventsPage.areFilteredEventsDisplayed();
}
@Then("the back button or link to return to the job opening should be visible")
public void the_back_button_or_link_to_return_to_the_job_opening_should_be_visible() {
viewJobEventsPage.isBackButtonVisible();
}
@When("the recruiter clicks on the back button or link")
public void the_recruiter_clicks_on_the_back_button_or_link() {
viewJobEventsPage.clicksBackButton();
}
@Then("the recruiter should be navigated back to the job opening card")
public void the_recruiter_should_be_navigated_back_to_the_job_opening_card() {
viewJobEventsPage.isNavigatedBackToJobOpening();
}
@Then("the job opening card should be displayed correctly")
public void the_job_opening_card_should_be_displayed_correctly() {
viewJobEventsPage.isJobOpeningCardDisplayedCorrectly();
}
@When("the user observes the UI during the transition to the events page")
public void the_user_observes_the_ui_during_the_transition_to_the_events_page() {
viewJobEventsPage.observeUITransition();
}
@Then("a loading indicator should be displayed during the transition")
public void a_loading_indicator_should_be_displayed_during_the_transition() {
viewJobEventsPage.isLoadingIndicatorDisplayed();
}
@Then("the loading indicator should disappear once the page is fully loaded")
public void the_loading_indicator_should_disappear_once_the_page_is_fully_loaded() {
viewJobEventsPage.isLoadingIndicatorDisplayed();
}
@Then("the events page should display correctly after loading")
public void the_events_page_should_display_correctly_after_loading() {
viewJobEventsPage.isEventsPageDisplayed();
}
@When("the recruiter clicks on the refresh button on the browser")
public void the_recruiter_clicks_on_the_refresh_button_on_the_browser() {
viewJobEventsPage.clicksRefreshButton();
}
@Then("the refresh button is functional")
public void the_refresh_button_is_functional() {
viewJobEventsPage.isRefreshButtonFunctional();
}
@Then("the events displayed are consistent before and after the refresh")
public void the_events_displayed_are_consistent_before_and_after_the_refresh() {
viewJobEventsPage.areEventsConsistentAfterRefresh();
}

@Given("the user clicks on the events button for a job opening")
public void the_user_clicks_on_the_events_button_for_a_job_opening() {
viewJobEventsPage.clicksOnEventsButtonForJobOpening();
}
@When("the user clicks the refresh button on the browser")
public void the_user_clicks_the_refresh_button_on_the_browser() {
viewJobEventsPage.clickRefreshButton();
}
@Then("the events page should load successfully")
public void the_events_page_should_load_successfully() {
viewJobEventsPage.isEventsPageLoaded();
}
@Then("the events page reloads correctly")
public void the_events_page_reloads_correctly() {
viewJobEventsPage.isEventsPageReloaded();
}
@When("the user repeats for multiple event cards")
public void the_user_repeats_for_multiple_event_cards() {
viewJobEventsPage.repeatForMultipleEventCards();
}
@Then("the user should see that the events page loads successfully")
public void the_user_should_see_that_the_events_page_loads_successfully() {
viewJobEventsPage.isEventsPageLoaded();
}
@When("the recruiter clicks on the events button for a job opening")
public void the_recruiter_clicks_on_the_events_button_for_a_job_opening() {
viewJobEventsPage.clicksOnEventsButtonForJobOpening();
}
@When("waits for the events page to load")
public void waits_for_the_events_page_to_load() {
viewJobEventsPage.waitForEventsPageToLoad();
}
@Then("the events page loads")
public void the_events_page_loads() {
viewJobEventsPage.isEventsPageLoaded();
}
}