Feature: Donation

  Scenario: an unauthorized user tries to make donation but cancel it
    #given an unauthorized user has landed on the EasyChamp/donation page
    Given open "https://dev.easychamp.com/donate"
    #When user donates default amount (15$)
    And click to "xpath=//*[@id='__next']/div/div[2]/div/div/form/button"
    #And waits for Payment page is loaded
    And wait for "xpath=//a[contains(@href,'/payment-canceled')]" is visible
    #When user clicks "Back" button without finishing payment process
    When click to "xpath=//a[contains(@href,'/payment-canceled')]"
    #Then user lands on the page with cancellation message
    Then assert text "Your payment was canceled" presented in "css=h1"
