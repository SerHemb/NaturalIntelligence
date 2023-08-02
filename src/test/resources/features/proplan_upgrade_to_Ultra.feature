Feature: Upgrade of Premium Plan

  Scenario: As a Premium subscriber I should have un option to upgrade to Ultra plan
    #Given  user user singed in with Premium Plan account
    Given open "https://dev.easychamp.com/"
    And click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Start5" in "id=EmailOrUsername"
    And type "111111Aa" in "id=Password"
    And click to "css=.text-button"
    #When user navigates to profile
    And click to "css=.ModalMenuContainer_burger__IS_VP"
    When click to "css=.ModalMenuContainer_user-logo__r_oSX"
    #And upgrades plan for Ultra
    And click to "xpath=//*[@class='SubscriptionDetails_sub-button__MjSV0 SubscriptionDetails_upgrade-button__EihZj']"
    And click to "css=.Plan_button-ultra__xYAVw"
    #Then user lands on "Contact Us" page
    Then assert text "Contact Us" presented in "css=.contact-us_header__MFuza"