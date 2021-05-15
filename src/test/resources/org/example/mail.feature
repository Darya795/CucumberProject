Feature: Mail
  Scenario Outline: Yandex Mail Log In
    Given I browse to http://yandex.ru
    When I click "Log in" button
    Then I see passport page
    When I enter <username> in login field
    And I enter <password> in password field
    And I click "Enter" button
    Then I see error message

    Examples:
      | username     | password   |
      | test         | Qwerty123  |
      | ivanov.vasya | 12.12.1985 |