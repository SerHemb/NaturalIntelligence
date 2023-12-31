Feature: competition creating

  Scenario Outline: Admin creates new competition with types data in to required fields
    Given user logs in as "iserhiy888@gmail.com" "Parol123" and saveAuthorization token
    Given new league with "<leagueName>" name creates via API request
    When admin user navigates to competition creation page
    And admin types "<competitionName>" in Name field and selects "<leagueName>" from dropdown menu
    Then the cart with "<competitionName>" title presents on competitions list page
    And delete created league via API

    Examples:
      | competitionName | leagueName          |
      | Fifa Champ      | Intelligence fifa   |
      | Tennis Champ    | Intelligence tennis |


  Scenario: Admin clicks on Save button on competition creating page when one required field is blank
    Given user logs in as "iserhiy888@gmail.com" "Parol123"
    When admin user navigates to competition creation page
    And admin types "My new champ" in Name field and doesn't select league from dropdown menu
    Then save button is not highlighted and not clickable
