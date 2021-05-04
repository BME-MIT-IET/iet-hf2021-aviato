Feature: Testing the main features of the game including Movement, Special powers, Cleaning fields, Interacting with Items, Falling in Water, Bear Movement and Game Over

  # Move tests
  Scenario: Eskimo can step
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 1
    Then Eskimo movement should be 3
    Then Entity on the last field should be Eskimo


  Scenario: Eskimo can step multiple
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    Given A fresh stable Field
    Given A fresh stable Field
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 2
    Then Eskimo movement should be 2
    Then Entity on the last field should be Nothing
    When Eskimo steps 2
    Then Eskimo movement should be 0
    Then Entity on the last field should be Eskimo

  Scenario: Eskimo cannot step because of lack of energy
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    Given A fresh stable Field
    Given A fresh stable Field
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 4
    Then Eskimo movement should be 0
    Then Entity on the last field should be Eskimo
    When Eskimo steps 1
    Then Eskimo movement should be 0
    Then Entity on the last field should be Eskimo

  Scenario: Eskimo can only step when fields are connected
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    When Eskimo steps 1
    Then Entity on the last field should be Nothing
    When The fields are connected
    When Eskimo steps 1
    Then Entity on the last field should be Eskimo

    #Special power tests
  Scenario: Eskimo builds igloo
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    Then Building on the last field should be Nothing
    When Eskimo steps 1
    When Eskimo builds igloo on their field
    Then Building on the last field should be Iglu

    # Field cleaning tests
  Scenario: Eskimo cleans field
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable field with snow of 2
    Then Snow on the last field should be 2
    When The fields are connected
    When Eskimo steps 1
    When Eskimo cleans field
    Then Snow on the last field should be 1
    When Eskimo cleans field
    Then Snow on the last field should be 0

  Scenario: Eskimo cannot clean field without movement
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable field with snow of 1
    Then Snow on the last field should be 1
    When The fields are connected
    When Eskimo steps 4
    Then Eskimo movement should be 0
    When Eskimo cleans field
    Then Snow on the last field should be 1

    # Item pickup tests
  Scenario: Eskimo can pick up item
    Given A fresh game
    Given A fresh Item
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 1
    When Eskimo picks up item
    Then Eskimo should have 1 item

  Scenario: Eskimo cant pick up item
    Given A fresh game
    Given A fresh Item
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 4
    Then Eskimo movement should be 0
    When Eskimo picks up item
    Then Eskimo should have 0 item

  Scenario: Eskimo cannot get item from field covered in snow
    Given A fresh game
    Given A fresh Item
    Given A fresh stable field with snow of 1
    Given A fresh Eskimo
    When The fields are connected
    When Eskimo steps 1
    When Eskimo picks up item
    Then Eskimo should have 0 item
    When Eskimo cleans field
    When Eskimo picks up item
    Then Eskimo should have 1 item
  
    # Item tests
  Scenario: Eskimo can get over max health
    Given A fresh game
    Given A fresh Eskimo
    When We give the eskimo Food
    When Eskimo eats food
    Then Eskimo health should be 6

  Scenario: Food restores health
    Given A fresh game
    Given A fresh Eskimo
    When We give the eskimo Food
    When Eskimo health drops 1
    Then Eskimo health should be 4
    When Eskimo eats food
    Then Eskimo health should be 5

  Scenario: Eskimo cant eat without movement
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When We give the eskimo Food
    When Eskimo steps 4
    When Eskimo health drops 1
    When Eskimo eats food
    Then Eskimo health should be 4

  Scenario: Eskimo builds tent
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh stable Field
    Then Building on the last field should be Nothing
    When The fields are connected
    When We give the eskimo Tent
    When Eskimo steps 1
    When Eskimo uses its item
    Then Building on the last field should be Tent

    # Falling in water tests
  Scenario: Eskimo falls into water
    Given A fresh game
    Given A fresh Eskimo
    Given A fresh unstable field with stability of 0
    When The fields are connected
    When Eskimo steps onto unstable field
    Then Number of people under field should be 1

  Scenario: Falling in water depends on number of occupying players
    Given A fresh game
    Given A fresh unstable field with stability of 3
    Given A fresh group of 3 eskimos
    Given A fresh Eskimo
    When The fields are connected
    When Group of eskimos step onto unstable field
    Then Number of people under field should be 0
    When Eskimo steps onto unstable field
    Then Number of people under field should be 4

    # Bear tests
  Scenario: Simple bear movement
    Given A fresh game
    Given A fresh bear
    Given A fresh stable Field
    When The fields are connected
    When Bear moves to field
    Then Entity on the last field should be Bear

  Scenario: Bear attack
    Given A fresh game
    Given A fresh bear
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 1
    When Bear moves to field
    Then Players should lose

  Scenario: Bear attack with igloo
    Given A fresh game
    Given A fresh bear
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 1
    Then Entity on the last field should be Eszkimo
    When Eskimo builds igloo on their field
    When Bear moves to field
    Then Players should not lose

  Scenario: The tent does not protect from bear attacks
    Given A fresh game
    Given A fresh bear
    Given A fresh Eskimo
    Given A fresh stable Field
    When The fields are connected
    When Eskimo steps 1
    Then Entity on the last field should be Eszkimo
    When We give the eskimo Tent
    When Eskimo uses its item
    When Bear moves to field
    Then Players should lose

