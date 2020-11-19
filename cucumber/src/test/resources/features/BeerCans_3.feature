Feature: Beer cans3
  Scenario Outline: Counting beer cans3
    Given I have <opening balance> beer cans3
    And I have drunk <processed> beer cans3
    When I go to my fridge3
    Then I should have <in stock> beer cans3
    Examples:
      | opening balance | processed | in stock |
      | 123             | 50        | 73       |
