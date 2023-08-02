Feature: player's statistics is appears

  As a logged in user
  I want be able to see player's statistic

  Scenario: User should be able to see player's statistic
    Given open "https://dev.easychamp.com/"
    #Given user logged in to have access to Admin Panel
    And click to "xpath=//*[@id='__next']/div/div[1]/div/header/div[2]/div[2]/button"
    And type "loveintest@gmail.com" in "xpath=//*[@id='EmailOrUsername']"
    And type "QKxr3vRxPM8vgSP" in "xpath=//*[@id='Password']"
    And send key "ENTER" to "xpath=//*[@id='submit-btn']"
    #When user navigates to Player's Statistics page
    Then click to "xpath=//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div[4]/a/button"
    And wait for "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div" is visible
    And scroll to element "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/table/tbody/tr[5]/td[1]/a/div"
    And click to "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/table/tbody/tr[5]/td[1]/a/div"
    #Then Player's Statistics appears in Total statistic tab
    Then assert element "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div" displayed
