Feature: competition statistics appears

  As a logged in user
  I want be able to see the competition's statistics

 Scenario: user can see the competition statistics
#Given that the user is logged in
   Given open "https://easychamp.com/"
   And click to "css=.MainLayoutHeaderContainer_button__arMB1"
   And type "fiaovam@gmail.com" in "id=EmailOrUsername"
   And type "Password1" in "id=Password"
   And send key "ENTER" to "id=Password"
# When navigating to the competition statistics page
   And click to "css=div:nth-child(2) > a .VerticalTabButtons_button-label____AzZ"
   And click to "css=.SportEntityCard_card__SQ6lG:nth-child(4) .ChampsCardList_sport-kind__b__O7:nth-child(2)"
   And wait for "css=.MuiButtonBase-root:nth-child(4)" is visible
   And click to "css=.MuiButtonBase-root:nth-child(4)"
#Then the user should see the competition statistics
   Then assert element "xpath=//h5" displayed