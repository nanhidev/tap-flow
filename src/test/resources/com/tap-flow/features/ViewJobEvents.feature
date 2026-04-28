
@feature_view_job_events
Feature: ViewJobEvents

  Background: 
    Given the user is logged in to the recruitment system

  @navigate_to_events_page
  Scenario Outline: View Job Events
    Given the user navigates to the job openings list
    And the user selects a specific job opening card
    And the user clicks on the Events button on the job opening card
    Then the user is navigated to the events page
    And the URL reflects the events page for the selected job opening

  Examples:
    | username | password |
    | user1    | pass1    |

  @verify_events_displayed
  Scenario Outline: View Job Events
    When the user clicks on the "Events" button for a job opening
    Then the events page loads successfully
    And the events are displayed in a card-based layout
    And each event card contains candidate name, email, date & time, and status
    And the user can scroll through multiple events
    And the card design is consistent with the application’s UI guidelines

  Examples:
    | event_card_details |
    | candidate name     |
    | email              |
    | date & time       |
    | status             |

  @verify_event_details
  Scenario Outline: View Job Events
    When the user clicks on the "Events" button for a job opening
    And the user waits for the events page to load
    And the user identifies the first event card displayed
    And the user notes the candidate name, email, date & time, and status
    And the user cross-references the details with the job opening’s event records
    And the user repeats for multiple event cards
    Then the user should see that the events page loads successfully
    And the first event card displays accurate candidate name, email, date & time, and status
    And the details match the job opening’s event records
    And all event cards reflect accurate information

  Examples:
    | candidate_name | candidate_email       | event_date_time | event_status |
    | John Doe       | john.doe@example.com   | 2023-10-01 10:00 | Attended     |
    | Jane Smith     | jane.smith@example.com | 2023-10-01 11:00 | Attended     |

  @verify_events_sorted
  Scenario Outline: View Job Events
    When the user clicks on the "Events" button for a job opening
    And waits for the events page to load
    Then the events page loads successfully
    And the user observes the order of event cards displayed
    And the user identifies the date and time of the first and last event cards
    Then the events are in chronological order
    And the first event card has the earliest date and time
    And the last event card has the latest date and time
    And the events with the same date and time are displayed consistently

  Examples:
    | event_card_1_date | event_card_1_time | event_card_2_date | event_card_2_time | event_card_3_date | event_card_3_time |
    | 2023-10-01        | 10:00 AM          | 2023-10-01        | 11:00 AM          | 2023-10-02        | 09:00 AM          |

  @verify_event_statuses
  Scenario Outline: View Job Events
    When the user clicks on the “Events” button for a job opening
    And the events page loads
    Then each event card should display a status
    And the statuses should match the job opening’s event records
    And the statuses should be visually distinct and easy to identify

  Examples:
    | event_status      |
    | Scheduled         |
    | Completed         |
    | Canceled          |

  @filter_job_events
  Scenario Outline: View Job Events
    When the user clicks on the "Events" button for a job opening
    And the user waits for the events page to load
    And the user locates the filter options for event statuses
    And the user selects the status "<status>"
    And the user applies the filter
    Then the user should see only events with the selected status displayed

    Examples:
      | status     |
      | Scheduled  |

  @navigate_back_to_job_opening
  Scenario Outline: View Job Events
    When the recruiter clicks on the “Events” button for a job opening
    And waits for the events page to load
    Then the events page should load successfully
    And the back button or link to return to the job opening should be visible
    When the recruiter clicks on the back button or link
    Then the recruiter should be navigated back to the job opening card
    And the job opening card should be displayed correctly

  Examples:
    | job_opening |
    | <job_opening> |

  @loading-indicator-check
  Scenario Outline: View Job Events
    When the user clicks on the "Events" button for a job opening
    And the user observes the UI during the transition to the events page
    And the user waits for the events page to load
    Then a loading indicator should be displayed during the transition
    Then the loading indicator should disappear once the page is fully loaded
    Then the events page should display correctly after loading

  Examples:
    |   |
    |   |

  @refresh_events
  Scenario Outline: View Job Events
    When the recruiter clicks on the “Events” button for a job opening
    And waits for the events page to load
    And clicks the refresh button on the browser
    And observes the events page reload
    Then the events page loads successfully
    And the refresh button is functional
    And the events page reloads correctly
    And the events displayed are consistent before and after the refresh

  Examples:
    | job_opening |
    | <job_opening> |
