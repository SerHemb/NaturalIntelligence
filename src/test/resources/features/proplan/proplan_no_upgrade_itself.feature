Feature: Upgrade of Premium Plan

  Scenario: As a Premium subscriber I should not have an option to upgrade to Premium monthly plan
    #Given user singed in with Premium Plan account
    Given open "https://dev.easychamp.com/"
    And click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Start5" in "id=EmailOrUsername"
    And type "111111Aa" in "id=Password"
    And click to "css=.text-button"
    #When user navigates to profile
    When click to "css=.ModalMenuContainer_burger__IS_VP"
    And click to "css=.ModalMenuContainer_user-logo__r_oSX"
    #And clicks button "upgrade"
    And click to "xpath=//*[@class='SubscriptionDetails_sub-button__MjSV0 SubscriptionDetails_upgrade-button__EihZj']"
    #Then the button "Get Started" is disabled
    And sleep for 5 seconds
    Then assert button "xpath=//div[@class='Plan_tournaments__nr2AE']/p[text()='Pro']/ancestor::div[@class='Plan_wrap__IwuSy']//button[text()='Get Started']" is disabled

  Scenario: As a Premium subscriber I should not have an option to upgrade to Premium annual plan
    #Given user singed in with Premium Plan account
    Given open "https://dev.easychamp.com/"
    And click to "css=.MainLayoutHeaderContainer_button__arMB1"
    And type "Start5" in "id=EmailOrUsername"
    And type "111111Aa" in "id=Password"
    And click to "css=.text-button"
    #When user navigates to profile
    When click to "css=.ModalMenuContainer_burger__IS_VP"
    And click to "css=.ModalMenuContainer_user-logo__r_oSX"
    #And clicks button "upgrade"
    And click to "xpath=//*[@class='SubscriptionDetails_sub-button__MjSV0 SubscriptionDetails_upgrade-button__EihZj']"
    #Then the button "Get Up to 20% Off" is disabled
    And sleep for 5 seconds
    Then assert button "xpath=//div[@class='Plan_tournaments__nr2AE']/p[text()='Pro']/ancestor::div[contains(@class, 'Plan_container__N_4yp')]//button[text()='Get Up to 20% Off!']" is disabled
