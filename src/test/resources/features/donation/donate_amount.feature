Feature: donation

  Scenario: guest user able to donate 15 (2-999999) USD with Visa card
    When open "https://dev.easychamp.com"
    #Given guest user and default amount of donation.
    #When scroll down to "Donation" button and click on it
    When scroll to element "css=#__next > div > div.Footer_background__Ut2_p > div > div:nth-child(1) > div.Footer_pages__CEL4Z > div:nth-child(2) > a:nth-child(3) > div"
    And click to "css=#__next > div > div.Footer_background__Ut2_p > div > div:nth-child(1) > div.Footer_pages__CEL4Z > div:nth-child(2) > a:nth-child(3) > div"
    And click to "css=#__next > div > div.MainLayout_children__BC6Ti > div > div > form > button"
    #And the page with payment details opens, fill all required fields
    And wait for "css=#root > div > div > div.App-Overview > div > div > div" is visible
    And wait for "id=email" is visible
    And type "test@test.com" in "id=email"
    And type "4242424242424242" in "id=cardNumber"
    And type "12/34" in "id=cardExpiry"
    And type "123" in "id=cardCvc"
    And type "User" in "id=billingName"
    And type "12345" in "id=billingPostalCode"
    And click to "id=enableStripePass"
    And click to "css=#root > div > div > div.App-Payment.is-noBackground > div > div.flex-container.direction-column > form > div.PaymentForm-confirmPaymentContainer.mt4.flex-item.width-grow > div > div:nth-child(2) > button > div.SubmitButton-IconContainer"
    #Then if payment successful I get confirmation page with "Thanks for using our services!" text
    And wait for "css=#__next > header > div.onetime-payment-success_wrapper__w_Mye > h4" is visible
    Then assert text "Thanks for using our services!" presented in "css=#__next > header > div.onetime-payment-success_wrapper__w_Mye > h4"

  Scenario: guest user unable to donate 1000000 USD
    When open "https://dev.easychamp.com"
    #Given guest user and 1000000 amount of donation.
    #When scroll down to "Donation" button and click on it
    When scroll to element "css=#__next > div > div.Footer_background__Ut2_p > div > div:nth-child(1) > div.Footer_pages__CEL4Z > div:nth-child(2) > a:nth-child(3) > div"
    And click to "css=#__next > div > div.Footer_background__Ut2_p > div > div:nth-child(1) > div.Footer_pages__CEL4Z > div:nth-child(2) > a:nth-child(3) > div"
    #And edit donation amount field and input 1000000 USD.
    And clear field "id=amount"
    And type "1000000" in "id=amount"
    And click to "css=#__next > div > div.MainLayout_children__BC6Ti > div > div > form > button"
    #Then nothing happens - the page is the same, no alerts or errors on the page present
    Then assert page title is "Donate | EasyChamp"
