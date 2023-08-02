Feature: Upgrade of Premium Plan

  Scenario: As a Premium subscriber I should have an option to upgrade plan
    #Given user singed in with Premium Plan account
    Given open "https://dev.easychamp.com/"
    And click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Start5" in "id=EmailOrUsername"
    And type "111111Aa" in "id=Password"
    And click to "css=.text-button"
    #When user navigates to profile
    And click to "css=.ModalMenuContainer_burger__IS_VP"
    When click to "css=.ModalMenuContainer_user-logo__r_oSX"
    #Then "upgrade" button is enabled
    Then assert button "xpath=//*[@class='SubscriptionDetails_sub-button__MjSV0 SubscriptionDetails_upgrade-button__EihZj']" is enabled