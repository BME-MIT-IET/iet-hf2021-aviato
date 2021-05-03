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