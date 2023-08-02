Feature: Win/lose/draw icons are displayed on the team's statistics page according to the match results

  Scenario: as a user I should be able to see Win icon on the team's statistics page when the team won
    #Given the user logged-in
    Given open "https://dev.easychamp.com/"
    When click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Irina_k" in "xpath=//input[@id='EmailOrUsername']"
    And type "Bootcamp23@" in "xpath=//input[@id='Password']"
    And click to "xpath=//div[5]"
    #When the user navigates to the Team's Statistics Page
    And click to "css=div:nth-child(3) .VerticalTabButtons_button-label____AzZ"
    And click to "css=.MuiTableRow-root:nth-child(2) img"
    #Then win icon should be present
    And wait for 'css=.css-15gfwt1:nth-child(5)' is visible
    Then assert element 'css=.css-15gfwt1:nth-child(5)' present

  Scenario: as a user I should be able to see Lose icon on the team's statistics page when the team lost
    #Given the user logged-in
    Given open "https://dev.easychamp.com/"
    When click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Irina_k" in "xpath=//input[@id='EmailOrUsername']"
    And type "Bootcamp23@" in "xpath=//input[@id='Password']"
    And click to "xpath=//div[5]"
    #When the user navigates to the Team's Statistics Page
    And click to "css=div:nth-child(3) .VerticalTabButtons_button-label____AzZ"
    And click to "css=.MuiTableRow-root:nth-child(2) img"
    #Then win icon should be present
    And wait for 'css=.css-tpks0n:nth-child(3)' is visible
    Then assert element 'css=.css-tpks0n:nth-child(3)' present

  Scenario: as a user I should be able to see Draw icon on the team's statistics page when the team drew
    #Given the user logged-in
    Given open "https://dev.easychamp.com/"
    When click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Irina_k" in "xpath=//input[@id='EmailOrUsername']"
    And type "Bootcamp23@" in "xpath=//input[@id='Password']"
    And click to "xpath=//div[5]"
    #When the user navigates to the Team's Statistics Page
    And click to "css=div:nth-child(3) .VerticalTabButtons_button-label____AzZ"
    And click to "css=.MuiTableRow-root:nth-child(2) img"
    #Then win icon should be present
    And wait for 'css=.css-147dy5z > .css-9henx5' is visible
    Then assert element 'css=.css-147dy5z > .css-9henx5' present