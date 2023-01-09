Feature: Different Elements

  Background:
    Given I open JDI GitHub site
    And I login with username "Roman" and password "Jdi1234"
    Then Browser title equals "Home Page"
    And User is logged in as "ROMAN IOVLEV"

  Scenario: Different Elements Page test
    When I open Different Elements page
    And I select two checkboxes
    And I select radio button
    And I select color dropdown
    Then "Different Elements" page should be opened
    And 4 log rows are presented
    And "Water" checkbox log status is correct
    And "Wind" checkbox log status is correct
    And "Selen" radio button log status is correct
    And Color dropdown log status is correct
