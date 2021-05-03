Feature: Determine if String is Palindrome or not. A string is a palindrome if it reads   the same backwards as forwards.

  Scenario: Eskimo can step
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo steps 1
    Then Eskimo movement should be 3

  Scenario: Eskimo can step
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo steps 2
    Then Eskimo movement should be 2
    When Eskimo steps 2
    Then Eskimo movement should be 0

  Scenario: Eskimo cant step
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo steps 4
    Then Eskimo movement should be 0
    When Eskimo steps 1
    Then Eskimo movement should be 0

  Scenario: Eskimo can pick up item
    Given A fresh Item
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo picks up item
    Then Eskimo should have 1 item

  Scenario: Eskimo cant pick up item
    Given A fresh Item
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo steps 4
    Then Eskimo movement should be 0
    When Eskimo picks up item
    Then Eskimo should have 0 item

  Scenario: Eskimo cant get over max health
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo eats food
    Then Eskimo health should be 5

  Scenario: Food restores health
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo health drops 1
    When Eskimo eats food
    Then Eskimo health should be 5

  Scenario: Eskimo cant eat without movement
    Given A fresh Eskimo
    Given A fresh Field
    When Eskimo steps 4
    When Eskimo health drops 1
    When Eskimo eats food
    Then Eskimo health should be 4

  Scenario: Eskimo falls into water
    Given A fresh Eskimo
    Given A fresh unstable field with stability of 0
    When Eskimo steps onto unstable field
    Then Number of people under field should be 1

  Scenario: Falling in water depends on number of occupying players
    Given A fresh unstable field with stability of 1
    Given A group of 3 eskimos
    Given A fresh Eskimo
    When Eskimo steps onto unstable field
    Then Number of people under field should be 0
    When Group of eskimos step onto unstable field
    Then Number of people under field should be 4

  Scenario: Eskimo cleans field
    Given A stable field with snow of 2
    Given A fresh Eskimo
    Then Snow on field should be 2
    When Eskimo cleans field
    Then Snow on field should be 1
    When Eskimo cleans field
    Then Snow on field should be 0

  Scenario: Eskimo cannot get item from field covered in snow
    Given A fresh Item
    Given A stable field with snow of 1
    Given A fresh Eskimo
    When Eskimo picks up item
    Then Eskimo should have 0 item
    When Eskimo cleans field
    When Eskimo picks up item
    Then Eskimo should have 1 item


