Feature: cancelation of subscription ProPlan

  Scenario: User with Premium subscription can cancel plan
    #given user singed in with Premium Plan account
    Given open "https://dev.easychamp.com/"
    And click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Start3" in "id=EmailOrUsername"
    And type "111111Aa" in "id=Password"
    And click to "css=.text-button"
    #when user navigates to profile
    When click to "css=.ModalMenuContainer_burger__IS_VP"
    When click to "css=.ModalMenuContainer_user-logo__r_oSX"
    #then cancel button is visible
    Then assert element "xpath=//*[@id='__next']/div/div[2]/div/div/form/div[1]/div[2]/div[6]/div" displayed
