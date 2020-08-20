Feature: Beer cans
  Scenario Outline: Counting beer cans
    Given I have <opening balance> beer cans2
    And I have drunk <processed> beer cans2
    When I go to my fridge2
    Then I should have <in stock> beer cans2
    Examples:
      | opening balance | processed | in stock |
      | 123             | 50        | 73       |
