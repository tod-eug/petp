#language: en

Feature: As a client, I want to find used car, so I can get actual information

  @Regress
  Scenario: Filter sedan body type
    Given site "https://auto.ru/" opened
    When click on the element "Car" in widget Main
    Then text "Легковые автомобили" should be visible
    When choose value "Седан" from list "Body types" in widget Filter
    And choose value "BMW" from list "Companies"
    And click on the element "Apply"
    Then element "Body type" should have text "Седан" in widget Search Car/Result Item[1]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[2]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[3]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[4]