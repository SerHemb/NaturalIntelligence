Feature: find a player from all players

  As a logged in user
  I want be able to find specific player by name

  Scenario Outline: User should be able to find a player via Admin panel
    Given user logs in as "<login>" "QKxr3vRxPM8vgSP"
    And user navigates to Players in Admin panel
    When searches for "<player's name>" player
    Then "<player's name>" is found

    Examples:
      | login                | player's name |
      | loveintest@gmail.com | Sasha         |


