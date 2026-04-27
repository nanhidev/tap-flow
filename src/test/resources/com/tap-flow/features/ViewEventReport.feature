
@feature_view_event_report
Feature: ViewEventReport

  Background: 
    Given the user is logged in as a recruiter
    And the user is on the events dashboard

  @view_event_report
  Scenario Outline: View Event Report
    Given the user locates an event card for a specific event
    When the user clicks on the "Report" button on the event card
    And the user waits for the system to process the request
    Then the user should be navigated to the event report page
    And the URL should reflect the event report page
    And the event report page should display candidate performance and evaluation details

  Examples:
    | event_card          |
    | specific event card  |

  @verify_event_report
  Scenario Outline: View Event Report
    When the user identifies the list of candidates who participated in the event
    And the user reviews the performance metrics displayed for each candidate
    And the user checks for evaluation details such as scores and comments
    And the user compares the displayed data with the expected data from the event
    Then the overall performance summary reflects the correct data

  Examples:
    | event_id |
    | <event_id> |

  @filtering_options
  Scenario Outline: View Event Report
    Then the event report page loads successfully
    And the filtering options are clearly visible and functional
    When the recruiter selects a filter criterion
    And applies the filter
    Then the data updates according to the selected filter criterion
    When the recruiter clears the filter
    Then the original data is restored upon clearing the filter
    When the recruiter tries multiple filters in succession
    Then the filtered results are accurate and relevant

  Examples:
    | filter_criterion       |
    | score range            |
    | evaluation status      |

@event-report-export
Scenario Outline: View Event Report
  When I locate the export button on the page
  And I click on the export button and select <format>
  And I confirm the export action
  Then the file should be downloaded in the <format>
  And the exported file should contain accurate event report data
  And the format of the exported file should match the <format>

  Examples:
    | format |
    | CSV    |
    | PDF    |

  @validate_pagination
  Scenario Outline: View Event Report
    When I observe the pagination controls at the bottom of the report
    Then the pagination controls are visible and functional
    When I click on the next page button
    Then the correct next set of candidates is displayed
    When I click on the previous page button
    Then the correct previous set of candidates is displayed
    Then the pagination updates correctly without errors
    And the total number of candidates is accurately reflected in the pagination

  Examples:
    | step_action                          |
    | Access the event report page        |
    | Observe the pagination controls      |
    | Click on the next page button       |
    | Observe the data displayed on the new page |
    | Click on the previous page button    |
    | Validate the data displayed on the previous page |

  @sort_candidates
  Scenario Outline: View Event Report
    When the user locates the sorting options available on the page
    And the user selects a sorting criterion to sort by <sorting_criterion>
    Then the candidates should be sorted correctly based on the <sorting_criterion>
    When the user changes the sorting criterion to sort by <new_sorting_criterion>
    Then the candidates should be sorted correctly based on the <new_sorting_criterion>

    Examples:
      | sorting_criterion | new_sorting_criterion |
      | score             | name                  |

@event_report_validation
Scenario Outline: View Event Report
  When I identify the list of candidates who participated in the event
  And I review the evaluation comments displayed for each candidate
  And I compare the displayed comments with the expected comments from the evaluation process
  And I check for any formatting issues in the comments
  And I validate that comments are attributed to the correct candidates
  Then the event report page should load successfully
  And the list of candidates should match the expected participants
  And each candidate's evaluation comments should be displayed accurately
  And the comments should match the expected content from evaluations
  And no formatting issues should be present in the comments
  And comments should be correctly attributed to the respective candidates

Examples:
  | event_name          |
  | specific_event_name |

  @verify_summary_section
  Scenario Outline: View Event Report
    When the user locates the summary section on the page
    And the user reviews the metrics displayed in the summary section
    And the user compares the summary metrics with the detailed candidate data
    And the user validates that the summary is easy to read and understand
    And the user checks for any discrepancies between the summary and detailed data
    Then the event report page loads successfully
    And the summary section is clearly visible on the page
    And the metrics displayed in the summary section are accurate
    And the summary aligns with the detailed candidate data
    And the summary is presented in a user-friendly format
    And no discrepancies are found between the summary and detailed data

  Examples:
    | event_id |
    | <event_id> |
