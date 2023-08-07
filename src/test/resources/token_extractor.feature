Feature: Save Authorization Bearer token

  Scenario Outline: User extract and save Bearer token from devtools Network logs
    Given user logs in as "iserhiy888@gmail.com" "Parol123" and saveAuthorization token
    Given new league with "<leagueName>" name creates via API request
    Given new championship with "<competitionName>" name creates via API
    And delete created league via API

    Examples:
      | competitionName | leagueName          |
      | Fifa Champ      | Intelligence fifa   |
      | Tennis Champ    | Intelligence tennis |