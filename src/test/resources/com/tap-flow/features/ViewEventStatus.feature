
Feature: ViewEventStatus @feature_view_event_status

Background: 
  Given the user is logged into the recruiter dashboard

@view_completed_event
Scenario Outline: View Event Status
  When the user navigates to the events section
  And the user locates an event that has a status of "<event_status>"
  And the user observes the event card for the completed event
  Then the event card should display "<event_display>" clearly
  And the date and time of the event should be accurate and match the event details
  And the completed status should be visually distinct from other statuses

  Examples:
    | event_status | event_display      |
    | completed    | Event completed    |

  @verify_cancelled_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    And the user locates an event that has a status of "<event_status>"
    And the user observes the event card for the cancelled event
    Then the event card displays "<event_display>" clearly
    And the reason for cancellation is displayed if applicable
    And the cancelled status is visually distinct from other statuses

    Examples:
      | event_status | event_display      |
      | cancelled     | Event cancelled     |

  @check_not_started_event
  Scenario Outline: View Event Status
    When the user navigates to the events section
    And the user locates an event that has a status of "not started"
    And the user observes the event card for the not started event
    Then the event card should display "Event not started yet"
    And the scheduled date and time of the event should be accurate and match the event details
    And the not started status should be visually distinct from other statuses

  Examples:
    | event_status     |
    | not started      |

  @event-status-check
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should see multiple events with different statuses
    And each status label should be visually distinct
    And the labels should be easily readable
    And no two status labels should be confused with one another

  Examples:
    | status        |
    | completed     |
    | cancelled     |
    | not started   |

  @view_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should be directed to the events section without errors
    When the user monitors an event that is currently ongoing
    When the user changes the status of the event to "<event_status>" from the admin panel
    When the user refreshes the recruiter dashboard
    Then the status of the event should update to "<expected_status>" after the change
    Then the status should be reflected accurately without delay
    And no errors should occur during the refresh process

    Examples:
      | event_status | expected_status     |
      | completed    | Event completed      |

@verify_event_sorting
Scenario Outline: View Event Status
  When the user navigates to the events section
  And the sorting options are visible and accessible
  And the user selects the option to sort events by status
  Then the events should be sorted correctly by their status
  And completed events should appear first, followed by cancelled, then not started
  And no errors occur during the sorting process

Examples:
  | username | password |
  | <username> | <password> |

@filtering_events
Scenario Outline: View Event Status
  When the user navigates to the events section
  And locates the filtering options available
  And selects the option to filter events by status
  And observes the events displayed after filtering
  Then only events matching the selected status are shown

Examples:
  | status       |
  | completed    |
  | cancelled    |
  | not started  |

  @update-event-status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should be directed to the events section without errors
    When the user locates an event that is currently ongoing
    When the user marks the event as "<event_status>"
    When the user refreshes the events section
    Then the event status updates to "<expected_status>" after the action
    And the status is reflected accurately without delay
    And no errors occur during the refresh process

    Examples:
      | event_status   | expected_status     |
      | completed      | Event completed     |

  @verify_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should be directed to the events section without errors
    When the user locates an event with a status of "<event_status>"
    Then the completed event is visible in the list of events
    When the user observes the event card for the completed event
    Then the event card displays "<event_card_message>" clearly
    Then the mobile layout is user-friendly and accessible
    Then the status label is easily readable on mobile devices

    Examples:
      | event_status  | event_card_message  |
      | completed     | Event completed      |

  @check_cancelled_event_status
  Scenario Outline: View Event Status in Different Browsers
    When the user navigates to the events section on "<browser>"
    And the user locates an event with a status of "cancelled"
    Then the cancelled event is visible in the list of events on "<browser>"
    And the event card displays "Event cancelled" clearly on "<browser>"
    And the layout and functionality are consistent across browsers
    And no browser-specific issues occur during testing

    Examples:
      | browser  |
      | Chrome   |
      | Firefox  |
      | Safari   |

  @check_recurring_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should be directed to the events section without errors
    When the user locates a recurring event with multiple occurrences
    Then the recurring event should be visible in the list of events
    When the user observes the status of each occurrence
    Then each occurrence should display its respective status correctly
    And the statuses should be easily distinguishable for each occurrence
    Then no confusion should arise from the recurring nature of the events

  Examples:
    | username | password |
    | user1    | pass1    |

  @check_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    And the user locates an event with multiple participants
    And the user observes the status of the event
    And the user checks the labels displayed for the event
    Then the status reflects the participation accurately

  Examples:
    | username | password |
    | user1    | pass1    |

  @verify_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    And the user locates an event scheduled in a different time zone
    And the user observes the status of the event
    Then the event card displays its respective status correctly
    And the status reflects the correct time zone information

  Examples:
    | event_time_zone |
    | different_time_zone |

  @verify_event_status
  Scenario Outline: View Event Status
    When the user navigates to the events section
    Then the user should be directed to the events section without errors
    When the user locates an event with a status displayed in a different language
    Then the event with a status displayed in a different language is visible in the list of events
    Then the event card displays its respective status correctly
    Then the status reflects the correct language information
    Then no confusion arises from the language differences

  Examples:
    | username | password |
    | user1    | pass1    |
