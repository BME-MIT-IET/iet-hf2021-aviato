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
    Then Eskimo has 1 item

