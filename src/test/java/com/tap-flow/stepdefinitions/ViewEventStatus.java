package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.tap-flow.pages.ViewEventStatusPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ViewEventStatus extends DriverFactory {
ViewEventStatusPage viewEventStatusPage = new ViewEventStatusPage(driver);
@Given("the user is logged into the recruiter dashboard")
public void the_user_is_logged_into_the_recruiter_dashboard() {
viewEventStatusPage.loginToRecruiterDashboard();
}
@When("the user navigates to the events section")
public void the_user_navigates_to_the_events_section() {
viewEventStatusPage.navigateToEventsSection();
}
@When("the user locates an event that has a status of {string}")
public void the_user_locates_an_event_that_has_a_status_of(String eventStatus) {
viewEventStatusPage.locateEventByStatus(eventStatus);
}
@When("the user observes the event card for the completed event")
public void the_user_observes_the_event_card_for_the_completed_event() {
viewEventStatusPage.observeEventCardForCompletedEvent();
}
@Then("the event card should display {string} clearly")
public void the_event_card_should_display_clearly(String eventDisplay) {
Assert.assertEquals(eventDisplay, viewEventStatusPage.getEventCardDisplay());
}
@Then("the date and time of the event should be accurate and match the event details")
public void the_date_and_time_of_the_event_should_be_accurate_and_match_the_event_details() {
viewEventStatusPage.isEventDateTimeAccurate();
}
@Then("the completed status should be visually distinct from other statuses")
public void the_completed_status_should_be_visually_distinct_from_other_statuses() {
viewEventStatusPage.isCompletedStatusDistinct();
}
@When("the user observes the event card for the cancelled event")
public void the_user_observes_the_event_card_for_the_cancelled_event() {
viewEventStatusPage.observeEventCardForCancelledEvent();
}
@Then("the reason for cancellation is displayed if applicable")
public void the_reason_for_cancellation_is_displayed_if_applicable() {
viewEventStatusPage.isCancellationReasonDisplayed();
}
@Then("the cancelled status is visually distinct from other statuses")
public void the_cancelled_status_is_visually_distinct_from_other_statuses() {
viewEventStatusPage.isCancelledStatusDistinct();
}
@When("the user observes the event card for the not started event")
public void the_user_observes_the_event_card_for_the_not_started_event() {
viewEventStatusPage.observeEventCardForNotStartedEvent();
}
@Then("the event card should display {string}")
public void the_event_card_should_display(String message) {
Assert.assertEquals(message, viewEventStatusPage.getEventCardDisplay());
}
@Then("the scheduled date and time of the event should be accurate and match the event details")
public void the_scheduled_date_and_time_of_the_event_should_be_accurate_and_match_the_event_details() {
viewEventStatusPage.isScheduledDateTimeAccurate();
}
@Then("the not started status should be visually distinct from other statuses")
public void the_not_started_status_should_be_visually_distinct_from_other_statuses() {
viewEventStatusPage.isNotStartedStatusDistinct();
}
@Then("the user should see multiple events with different statuses")
public void the_user_should_see_multiple_events_with_different_statuses() {
viewEventStatusPage.areMultipleEventsDisplayed();
}
@Then("each status label should be visually distinct")
public void each_status_label_should_be_visually_distinct() {
viewEventStatusPage.areStatusLabelsDistinct();
}
@Then("the labels should be easily readable")
public void the_labels_should_be_easily_readable() {
viewEventStatusPage.areLabelsReadable();
}
@Then("no two status labels should be confused with one another")
public void no_two_status_labels_should_be_confused_with_one_another() {
viewEventStatusPage.areStatusLabelsDistinct();
}
@Then("the user should be directed to the events section without errors")
public void the_user_should_be_directed_to_the_events_section_without_errors() {
viewEventStatusPage.isNavigatedToEventsSection();
}
@When("the user monitors an event that is currently ongoing")
public void the_user_monitors_an_event_that_is_currently_ongoing() {
viewEventStatusPage.monitorOngoingEvent();
}
@When("the user changes the status of the event to {string} from the admin panel")
public void the_user_changes_the_status_of_the_event_to_from_the_admin_panel(String eventStatus) {
viewEventStatusPage.changeEventStatus(eventStatus);
}
@When("the user refreshes the recruiter dashboard")
public void the_user_refreshes_the_recruiter_dashboard() {
viewEventStatusPage.refreshRecruiterDashboard();
}
@Then("the status of the event should update to {string} after the change")
public void the_status_of_the_event_should_update_to_after_the_change(String expectedStatus) {
Assert.assertEquals(expectedStatus, viewEventStatusPage.getUpdatedEventStatus());
}
@Then("the status should be reflected accurately without delay")
public void the_status_should_be_reflected_accurately_without_delay() {
viewEventStatusPage.isStatusReflectedAccurately();
}
@Then("no errors should occur during the refresh process")
public void no_errors_should_occur_during_the_refresh_process() {
viewEventStatusPage.isRefreshErrorOccurred();
}
@When("the user selects the option to sort events by status")
public void the_user_selects_the_option_to_sort_events_by_status() {
viewEventStatusPage.selectSortByStatus();
}
@Then("the events should be sorted correctly by their status")
public void the_events_should_be_sorted_correctly_by_their_status() {
viewEventStatusPage.isEventsSortedByStatus();
}
@Then("completed events should appear first, followed by cancelled, then not started")
public void completed_events_should_appear_first_followed_by_cancelled_then_not_started() {
viewEventStatusPage.isSortingOrderCorrect();
}
@Then("only events matching the selected status are shown")
public void only_events_matching_the_selected_status_are_shown() {
viewEventStatusPage.areFilteredEventsDisplayed();
}
@When("the user marks the event as {string}")
public void the_user_marks_the_event_as(String eventStatus) {
viewEventStatusPage.markEventAs(eventStatus);
}
@Then("the event status updates to {string} after the action")
public void the_event_status_updates_to_after_the_action(String expectedStatus) {
Assert.assertEquals(expectedStatus, viewEventStatusPage.getUpdatedEventStatus());
}
@Then("the mobile layout is user-friendly and accessible")
public void the_mobile_layout_is_user_friendly_and_accessible() {
viewEventStatusPage.isMobileLayoutUserFriendly();
}
@Then("the status label is easily readable on mobile devices")
public void the_status_label_is_easily_readable_on_mobile_devices() {
viewEventStatusPage.isStatusLabelReadableOnMobile();
}
@When("the user locates an event with a status of {string}")
public void the_user_locates_an_event_with_a_status_of(String eventStatus) {
viewEventStatusPage.locateEventByStatus(eventStatus);
}
@Then("the cancelled event is visible in the list of events on {string}")
public void the_cancelled_event_is_visible_in_the_list_of_events_on(String browser) {
viewEventStatusPage.isCancelledEventVisible(browser);
}
@Then("the event card displays {string} clearly on {string}")
public void the_event_card_displays_clearly_on(String eventDisplay, String browser) {
Assert.assertEquals(eventDisplay, viewEventStatusPage.getEventCardDisplay(browser));
}
@Then("the layout and functionality are consistent across browsers")
public void the_layout_and_functionality_are_consistent_across_browsers() {
viewEventStatusPage.isLayoutConsistentAcrossBrowsers();
}
@Then("no browser-specific issues occur during testing")
public void no_browser_specific_issues_occur_during_testing() {
viewEventStatusPage.isBrowserSpecificIssueOccurred();
}
@When("the user locates a recurring event with multiple occurrences")
public void the_user_locates_a_recurring_event_with_multiple_occurrences() {
viewEventStatusPage.locateRecurringEvent();
}
@Then("the recurring event should be visible in the list of events")
public void the_recurring_event_should_be_visible_in_the_list_of_events() {
viewEventStatusPage.isRecurringEventVisible();
}
@Then("each occurrence should display its respective status correctly")
public void each_occurrence_should_display_its_respective_status_correctly() {
viewEventStatusPage.areOccurrencesStatusDisplayedCorrectly();
}
@Then("the statuses should be easily distinguishable for each occurrence")
public void the_statuses_should_be_easily_distinguishable_for_each_occurrence() {
viewEventStatusPage.areStatusesDistinguishable();
}
@Then("no confusion should arise from the recurring nature of the events")
public void no_confusion_should_arise_from_the_recurring_nature_of_the_events() {
viewEventStatusPage.isConfusionArisingFromRecurringEvents();
}
@When("the user locates an event scheduled in a different time zone")
public void the_user_locates_an_event_scheduled_in_a_different_time_zone() {
viewEventStatusPage.locateEventInDifferentTimeZone();
}
@Then("the event card displays its respective status correctly")
public void the_event_card_displays_its_respective_status_correctly() {
viewEventStatusPage.isEventCardStatusCorrect();
}
@Then("the status reflects the correct time zone information")
public void the_status_reflects_the_correct_time_zone_information() {
viewEventStatusPage.isTimeZoneInformationCorrect();
}
@When("the user locates an event with a status displayed in a different language")
public void the_user_locates_an_event_with_a_status_displayed_in_a_different_language() {
viewEventStatusPage.locateEventWithDifferentLanguageStatus();
}
@Then("the event with a status displayed in a different language is visible in the list of events")
public void the_event_with_a_status_displayed_in_a_different_language_is_visible_in_the_list_of_events() {
viewEventStatusPage.isEventVisibleInDifferentLanguage();
}
@Then("the status reflects the correct language information")
public void the_status_reflects_the_correct_language_information() {
viewEventStatusPage.isLanguageInformationCorrect();
}
@Then("no confusion arises from the language differences")
public void no_confusion_arises_from_the_language_differences() {
viewEventStatusPage.isConfusionFromLanguageDifferences();
}

@Given("the user locates an event that is currently ongoing")
public void the_user_locates_an_event_that_is_currently_ongoing() {
viewEventStatusPage.locateOngoingEvent();
}
@Then("the event card displays {string} clearly")
public void the_event_card_displays_clearly(String eventName) {
viewEventStatusPage.isEventCardDisplayed(eventName);
}
@Then("the status reflects the participation accurately")
public void the_status_reflects_the_participation_accurately() {
viewEventStatusPage.isParticipationStatusAccurate();
}
@Then("the event card displays event cancelled clearly on {string}")
public void the_event_card_displays_event_cancelled_clearly_on(String eventName) {
viewEventStatusPage.isEventCancelledDisplayed(eventName);
}
@Given("locates the filtering options available")
public void locates_the_filtering_options_available() {
viewEventStatusPage.locateFilteringOptions();
}
@Then("the sorting options are visible accessible")
public void the_sorting_options_are_visible_accessible() {
viewEventStatusPage.areSortingOptionsVisible();
}
@Then("the completed event is visible in the list of events")
public void the_completed_event_is_visible_in_the_list_of_events() {
viewEventStatusPage.isCompletedEventVisible();
}
@Then("the user checks the labels displayed for the event")
public void the_user_checks_the_labels_displayed_for_the_event() {
viewEventStatusPage.checkEventLabels();
}
@Then("no errors occur during the refresh process")
public void no_errors_occur_during_the_refresh_process() {
viewEventStatusPage.isRefreshProcessErrorFree();
}
@Given("the user navigates to the events section on {string}")
public void the_user_navigates_to_the_events_section_on(String section) {
viewEventStatusPage.navigateToEventsSection(section);
}
@When("selects the option to filter events by status")
public void selects_the_option_to_filter_events_by_status() {
viewEventStatusPage.selectFilterByStatus();
}
@Then("the status is reflected accurately without delay")
public void the_status_is_reflected_accurately_without_delay() {
viewEventStatusPage.isStatusReflectedAccurately();
}
@Then("observes the events displayed after filtering")
public void observes_the_events_displayed_after_filtering() {
viewEventStatusPage.areFilteredEventsDisplayed();
}
@Given("the user locates an event that has a status of not started")
public void the_user_locates_an_event_that_has_a_status_of_not_started() {
viewEventStatusPage.locateNotStartedEvent();
}
@Then("the user observes the status of each occurrence")
public void the_user_observes_the_status_of_each_occurrence() {
viewEventStatusPage.observeStatusOfOccurrences();
}
@Then("the user observes the status of the event")
public void the_user_observes_the_status_of_the_event() {
viewEventStatusPage.observeEventStatus();
}
@Given("the user locates an event with multiple participants")
public void the_user_locates_an_event_with_multiple_participants() {
viewEventStatusPage.locateEventWithMultipleParticipants();
}
@When("the user refreshes the events section")
public void the_user_refreshes_the_events_section() {
viewEventStatusPage.refreshEventsSection();
}
@Then("the event card should display event not started yet")
public void the_event_card_should_display_event_not_started_yet() {
viewEventStatusPage.isEventNotStartedDisplayed();
}
@Then("no errors occur during the sorting process")
public void no_errors_occur_during_the_sorting_process() {
viewEventStatusPage.isSortingProcessErrorFree();
}
@Given("the user locates an event with a status of cancelled")
public void the_user_locates_an_event_with_a_status_of_cancelled() {
viewEventStatusPage.locateCancelledEvent();
}
}