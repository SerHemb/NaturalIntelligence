Feature: The Games Played results are displayed on the player's statistics page

  Scenario: as a user I should be able to see Games played for the player on the player's statistics page
    #Given the user logged-in
    Given open "https://dev.easychamp.com/"
    When click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Irina_k" in "xpath=//input[@id='EmailOrUsername']"
    And type "Bootcamp23@" in "xpath=//input[@id='Password']"
    And click to "xpath=//div[5]"
    #When user navigates to the player's statistic page
    And click to "xpath=//span[contains(.,'Players')]"
    And click to "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div"
    Then type "tom" in "xpath=//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/input"
    And wait for "xpath=//div[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/table/tbody/tr/td/a/div/div[2]" is visible
    And click to "xpath=//div[@id='__next']/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/table/tbody/tr/td/a/div/div[2]"
	#Then user should to see the Games played statistic
    Then assert element "css=.css-1lo93ge:nth-child(1) > .css-szc92y" displayed
