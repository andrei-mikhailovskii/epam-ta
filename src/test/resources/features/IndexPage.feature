Feature: Index Page

  Background: Open JDI Github site
    When I open JDI GitHub site

  Scenario: Index Page check
    When I login with username "Roman" and password "Jdi1234"
    Then Browser title equals "Home Page"
    And User is logged in as "ROMAN IOVLEV"
    And Header buttons are displayed and have proper texts
    And 4 images are displayed
    And Images texts are displayed and correct
    And Iframe with “Frame Button” exists
    And Left section menu items are displayed with proper texts
