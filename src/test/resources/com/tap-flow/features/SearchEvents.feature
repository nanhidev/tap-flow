
@feature_search_events
Feature: SearchEvents

Background: 
  Given the user is on the Events Page

@valid_keyword_search
Scenario Outline: Search Events
  Given the user locates the search bar
  When the user enters a valid keyword that matches existing event records
  And the user clicks the search button
  Then the system displays only the event records that match the entered keyword
  And the search results are relevant to the keyword entered
  And the total number of matching records is displayed
  And each displayed record includes relevant details
  And the search bar retains the entered keyword for user reference
  And the user can click on an event record to view more details

Examples:
  | valid_keyword     |
  | <valid_keyword>   |

  @valid-search
  Scenario Outline: Search Events
    Given the user is on the Events page
    When the user locates the search bar
    And the user enters <keywords>
    And the user clicks the search button
    And the results load
    Then the system displays only the event records that match any of the entered keywords
    And the search results are relevant to the keywords entered
    And the total number of matching records is displayed
    And each displayed record includes relevant details
    And the search bar retains the entered keywords for user reference
    And the user can click on an event record to view more details

    Examples:
      | keywords                     |
      | keyword1 keyword2 keyword3   |

  @case_insensitive_search
  Scenario Outline: Search Events
    Given the user locates the search bar
    When the user enters <keyword>
    And the user clicks the search button
    Then the system displays event records that match the keyword, regardless of case
    And the search results are relevant to the keyword entered
    And the total number of matching records is displayed
    And each displayed record includes relevant details
    And the search bar retains the entered keyword for user reference
    And the user can click on an event record to view more details

    Examples:
      | keyword              |
      | UPPERCASEKEYWORD    |

@special-character-search
Scenario Outline: Search Events
  Given the user locates the search bar
  When the user enters <keyword>
  And the user clicks the search button
  Then the system displays event records that match the keyword with special characters
  And the search results are relevant to the keyword entered
  And the total number of matching records is displayed
  And each displayed record includes relevant details
  And the search bar retains the entered keyword for user reference
  And the user can click on an event record to view more details

  Examples:
    | keyword      |
    | Event@2023  |

@no_records_found
Scenario Outline: Search Events
  Given the recruiter locates the search bar
  When the recruiter enters <keyword>
  And the recruiter clicks the search button
  Then the system displays a "No records found" message
  And the search bar retains the entered keyword
  And the user is not presented with any irrelevant event records
  And the user can clear the search bar to return to the full list of events
  And the user can still access other functionalities on the Events page
  And the user can attempt a new search with a different keyword

  Examples:
    | keyword                  |
    | nonexistentkeyword123    |

  @feature_search_events
  @verify_pagination
  Scenario Outline: Search Events
    Given the user locates the search bar
    When the user enters a keyword that matches a large number of event records
    And the user clicks the search button
    Then the system displays a limited number of results per page
    And pagination controls are visible and functional
    And the user can navigate through pages of results
    And the total number of results is displayed
    And the user can return to the first page of results
    And the user can click on an event record to view more details

  Examples:
    | event       |
    | sampleKeyword |

@valid-sort
Scenario Outline: Search Events
  Given the user locates the search bar
  When the user enters <keyword>
  And the user clicks the search button
  And the user waits for the results to load
  And the user clicks on the sorting option <sorting_option>
  Then the results should be sorted according to the selected criteria
  And the sorting order is clearly indicated
  And the user can switch between different sorting options
  And the total number of results remains consistent after sorting
  And the user can click on an event record to view more details
  And the search bar retains the entered keyword for user reference

Examples:
  | keyword | sorting_option       |
  | event   | Sort by Date        |

  @search_events
  Scenario Outline: Search Events
    Given the user locates the search bar
    When the user enters the keyword <keyword>
    And the user performs a search
    And the user waits for the results to load
    And the user clicks on the browser back button
    Then the user should see the previous state of the Events page
    And the search bar should retain the keyword <keyword>
    And the user should see the full list of events before the search
    And the user can perform a new search if desired
    And no error or crash occurs in the application
    And the user can access other functionalities on the Events page

    Examples:
      | keyword  |
      | concert  |

@recruiter_search
Scenario Outline: Search Events as a Recruiter
  When the user enters <keyword> in the search bar
  And the user clicks the search button
  Then the recruiter should see event records relevant to their role
  And the total number of matching records should be displayed
  And each displayed record should include relevant details

  Examples:
    | keyword     |
    | conference  |

@admin_search
Scenario Outline: Search Events as an Admin
  When the user logs out
  And the user logs in as an admin
  And the user is on the Events page
  And the user locates the search bar
  When the user enters <keyword> in the search bar
  And the user clicks the search button
  Then the admin should see event records relevant to their role, which may include additional events
  And the total number of matching records should be displayed
  And each displayed record should include relevant details

  Examples:
    | keyword     |
    | conference  |
