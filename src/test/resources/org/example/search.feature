Feature: Search
  Scenario Outline: Find selenium
    Given I browse to yandex.ru
    When I enter "<text>" in text field
    And I click "Search" button
    Then I see <domain> in results

    Examples:
      | text     | domain               |
      | selenium | docs.seleniumhq.org  |
      | junit    | junit.org            |