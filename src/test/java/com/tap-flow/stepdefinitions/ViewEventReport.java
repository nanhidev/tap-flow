package com.tap-flow.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.tap-flow.pages.ViewEventReportPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ViewEventReport extends DriverFactory {
ViewEventReportPage viewEventReportPage = new ViewEventReportPage(driver);
@Given("the user is logged in as a recruiter")
public void the_user_is_logged_in_as_a_recruiter() {
viewEventReportPage.loginAsRecruiter();
}
@Given("the user is on the events dashboard")
public void the_user_is_on_the_events_dashboard() {
viewEventReportPage.navigateToEventsDashboard();
}
@Given("the user locates an event card for a specific event")
public void the_user_locates_an_event_card_for_a_specific_event() {
viewEventReportPage.locateEventCard("specific event card");
}
@When("the user clicks on the {string} button on the event card")
public void the_user_clicks_on_the_button_on_the_event_card(String button) {
viewEventReportPage.clicksOnEventCardButton(button);
}
@When("the user waits for the system to process the request")
public void the_user_waits_for_the_system_to_process_the_request() {
viewEventReportPage.waitForProcessing();
}
@Then("the user should be navigated to the event report page")
public void the_user_should_be_navigated_to_the_event_report_page() {
viewEventReportPage.isOnEventReportPage();
}
@Then("the URL should reflect the event report page")
public void the_url_should_reflect_the_event_report_page() {
viewEventReportPage.isEventReportPageUrl();
}
@Then("the event report page should display candidate performance and evaluation details")
public void the_event_report_page_should_display_candidate_performance_and_evaluation_details() {
viewEventReportPage.isCandidatePerformanceDisplayed();
}
@When("the user identifies the list of candidates who participated in the event")
public void the_user_identifies_the_list_of_candidates_who_participated_in_the_event() {
viewEventReportPage.identifyCandidatesList();
}
@When("the user reviews the performance metrics displayed for each candidate")
public void the_user_reviews_the_performance_metrics_displayed_for_each_candidate() {
viewEventReportPage.reviewPerformanceMetrics();
}
@When("the user checks for evaluation details such as scores and comments")
public void the_user_checks_for_evaluation_details_such_as_scores_and_comments() {
viewEventReportPage.checkEvaluationDetails();
}
@When("the user compares the displayed data with the expected data from the event")
public void the_user_compares_the_displayed_data_with_the_expected_data_from_the_event() {
viewEventReportPage.compareDisplayedData();
}
@Then("the overall performance summary reflects the correct data")
public void the_overall_performance_summary_reflects_the_correct_data() {
viewEventReportPage.isPerformanceSummaryCorrect();
}
@Then("the event report page loads successfully")
public void the_event_report_page_loads_successfully() {
viewEventReportPage.isEventReportPageLoaded();
}
@Then("the filtering options are clearly visible and functional")
public void the_filtering_options_are_clearly_visible_and_functional() {
viewEventReportPage.areFilteringOptionsVisible();
}
@When("the recruiter selects a filter criterion")
public void the_recruiter_selects_a_filter_criterion() {
viewEventReportPage.selectFilterCriterion("score range");
}
@When("applies the filter")
public void applies_the_filter() {
viewEventReportPage.applyFilter();
}
@Then("the data updates according to the selected filter criterion")
public void the_data_updates_according_to_the_selected_filter_criterion() {
viewEventReportPage.isDataUpdated();
}
@When("the recruiter clears the filter")
public void the_recruiter_clears_the_filter() {
viewEventReportPage.clearFilter();
}
@Then("the original data is restored upon clearing the filter")
public void the_original_data_is_restored_upon_clearing_the_filter() {
viewEventReportPage.isOriginalDataRestored();
}
@When("the recruiter tries multiple filters in succession")
public void the_recruiter_tries_multiple_filters_in_succession() {
viewEventReportPage.tryMultipleFilters();
}
@Then("the filtered results are accurate and relevant")
public void the_filtered_results_are_accurate_and_relevant() {
viewEventReportPage.areFilteredResultsAccurate();
}
@When("I locate the export button on the page")
public void i_locate_the_export_button_on_the_page() {
viewEventReportPage.locateExportButton();
}
@When("I click on the export button and select {string}")
public void i_click_on_the_export_button_and_select(String format) {
viewEventReportPage.clickExportButton(format);
}
@When("I confirm the export action")
public void i_confirm_the_export_action() {
viewEventReportPage.confirmExport();
}
@Then("the file should be downloaded in the {string}")
public void the_file_should_be_downloaded_in_the(String format) {
viewEventReportPage.isFileDownloaded(format);
}
@Then("the exported file should contain accurate event report data")
public void the_exported_file_should_contain_accurate_event_report_data() {
viewEventReportPage.isExportedFileDataAccurate();
}
@Then("the format of the exported file should match the {string}")
public void the_format_of_the_exported_file_should_match_the(String format) {
viewEventReportPage.isExportedFileFormatCorrect(format);
}
@When("I observe the pagination controls at the bottom of the report")
public void i_observe_the_pagination_controls_at_the_bottom_of_the_report() {
viewEventReportPage.observePaginationControls();
}
@Then("the pagination controls are visible and functional")
public void the_pagination_controls_are_visible_and_functional() {
viewEventReportPage.arePaginationControlsFunctional();
}
@When("I click on the next page button")
public void i_click_on_the_next_page_button() {
viewEventReportPage.clickNextPageButton();
}
@Then("the correct next set of candidates is displayed")
public void the_correct_next_set_of_candidates_is_displayed() {
viewEventReportPage.isNextSetOfCandidatesDisplayed();
}
@When("I click on the previous page button")
public void i_click_on_the_previous_page_button() {
viewEventReportPage.clickPreviousPageButton();
}
@Then("the correct previous set of candidates is displayed")
public void the_correct_previous_set_of_candidates_is_displayed() {
viewEventReportPage.isPreviousSetOfCandidatesDisplayed();
}
@Then("the pagination updates correctly without errors")
public void the_pagination_updates_correctly_without_errors() {
viewEventReportPage.isPaginationUpdatedCorrectly();
}
@Then("the total number of candidates is accurately reflected in the pagination")
public void the_total_number_of_candidates_is_accurately_reflected_in_the_pagination() {
viewEventReportPage.isTotalCandidatesAccurate();
}
@When("the user locates the sorting options available on the page")
public void the_user_locates_the_sorting_options_available_on_the_page() {
viewEventReportPage.locateSortingOptions();
}
@When("the user selects a sorting criterion to sort by {string}")
public void the_user_selects_a_sorting_criterion_to_sort_by(String sortingCriterion) {
viewEventReportPage.selectSortingCriterion(sortingCriterion);
}
@Then("the candidates should be sorted correctly based on the {string}")
public void the_candidates_should_be_sorted_correctly_based_on_the(String sortingCriterion) {
viewEventReportPage.isCandidatesSortedCorrectly(sortingCriterion);
}
@When("the user changes the sorting criterion to sort by {string}")
public void the_user_changes_the_sorting_criterion_to_sort_by(String newSortingCriterion) {
viewEventReportPage.changeSortingCriterion(newSortingCriterion);
}
@When("I identify the list of candidates who participated in the event")
public void i_identify_the_list_of_candidates_who_participated_in_the_event() {
viewEventReportPage.identifyCandidatesList();
}
@When("I review the evaluation comments displayed for each candidate")
public void i_review_the_evaluation_comments_displayed_for_each_candidate() {
viewEventReportPage.reviewEvaluationComments();
}
@When("I compare the displayed comments with the expected comments from the evaluation process")
public void i_compare_the_displayed_comments_with_the_expected_comments_from_the_evaluation_process() {
viewEventReportPage.compareDisplayedComments();
}
@When("I check for any formatting issues in the comments")
public void i_check_for_any_formatting_issues_in_the_comments() {
viewEventReportPage.checkFormattingIssues();
}
@When("I validate that comments are attributed to the correct candidates")
public void i_validate_that_comments_are_attributed_to_the_correct_candidates() {
viewEventReportPage.validateCommentAttribution();
}
@Then("the event report page should load successfully")
public void the_event_report_page_should_load_successfully() {
viewEventReportPage.isEventReportPageLoaded();
}
@Then("the list of candidates should match the expected participants")
public void the_list_of_candidates_should_match_the_expected_participants() {
viewEventReportPage.isCandidatesListMatching();
}
@Then("each candidate's evaluation comments should be displayed accurately")
public void each_candidate_s_evaluation_comments_should_be_displayed_accurately() {
viewEventReportPage.areCommentsDisplayedAccurately();
}
@Then("the comments should match the expected content from evaluations")
public void the_comments_should_match_the_expected_content_from_evaluations() {
viewEventReportPage.isCommentsMatchingExpected();
}
@Then("no formatting issues should be present in the comments")
public void no_formatting_issues_should_be_present_in_the_comments() {
viewEventReportPage.hasFormattingIssues();
}
@Then("comments should be correctly attributed to the respective candidates")
public void comments_should_be_correctly_attributed_to_the_respective_candidates() {
viewEventReportPage.isCommentAttributionCorrect();
}
@When("the user locates the summary section on the page")
public void the_user_locates_the_summary_section_on_the_page() {
viewEventReportPage.locateSummarySection();
}
@When("the user reviews the metrics displayed in the summary section")
public void the_user_reviews_the_metrics_displayed_in_the_summary_section() {
viewEventReportPage.reviewSummaryMetrics();
}
@When("the user compares the summary metrics with the detailed candidate data")
public void the_user_compares_the_summary_metrics_with_the_detailed_candidate_data() {
viewEventReportPage.compareSummaryWithDetailedData();
}
@When("the user validates that the summary is easy to read and understand")
public void the_user_validates_that_the_summary_is_easy_to_read_and_understand() {
viewEventReportPage.isSummaryReadable();
}
@When("the user checks for any discrepancies between the summary and detailed data")
public void the_user_checks_for_any_discrepancies_between_the_summary_and_detailed_data() {
viewEventReportPage.hasDiscrepancies();
}
@Then("the summary section is clearly visible on the page")
public void the_summary_section_is_clearly_visible_on_the_page() {
viewEventReportPage.isSummarySectionVisible();
}
@Then("the metrics displayed in the summary section are accurate")
public void the_metrics_displayed_in_the_summary_section_are_accurate() {
viewEventReportPage.isSummaryMetricsAccurate();
}
@Then("the summary aligns with the detailed candidate data")
public void the_summary_aligns_with_the_detailed_candidate_data() {
viewEventReportPage.isSummaryAlignedWithDetailedData();
}
@Then("the summary is presented in a user-friendly format")
public void the_summary_is_presented_in_a_user_friendly_format() {
viewEventReportPage.isSummaryUserFriendly();
}

@When("the user clicks on the report button on the event card")
public void the_user_clicks_on_the_report_button_on_the_event_card() {
viewEventReportPage.clickReportButtonOnEventCard();
}
@Then("no discrepancies are found between the summary detailed data")
public void no_discrepancies_are_found_between_the_summary_detailed_data() {
viewEventReportPage.verifyNoDiscrepanciesInSummaryData();
}
}