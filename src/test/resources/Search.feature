#language: en

Feature: As a client, I want to find used car, so I can get actual information

  @Regress
  Scenario: Filter sedan body type
    Given created list of offers
    And in database inserted following offers:
      | Company | Model | Color | Price | Body type |
      | BMW     | M5    | Blue  | 10000 | Sedan     |
      | BMW     | M3    | Black | 9000  | Sedan     |
    And site "https://auto.ru/" opened
    When click on the element "Car" in widget Main
    Then text "Легковые автомобили" should be visible
    When click on the field "Body type" in widget Filter
    And choose value "Седан" from list "Options list"
    And click on the element "Price"
    And click on the field "Company"
    And choose value "BMW" from list "Options list"
    And click on the element "Apply"
    Then element "Body type" should have text "Седан" in widget Search Car/Result Item[1]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[2]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[3]
    And element "Body type" should have text "Седан" in widget Search Car/Result Item[4]