#language: en

  Feature: As a client, I want correct work statuses of quality ad, so that I can control filling ad

    Scenario: Filling color and mileage
      Given site "https://auto.ru/" opened
      When click on the element "New Offer"
      Then text "Какой марки ваш автомобиль?" should be visible
      When click on the element "BMW"
      Then element "Company name" should be visible
      When click on the element "M5"
      Then text "Год выпуска" should be visible
      When click on the element "2017"
      Then text "Фотографии и видео" should be visible
#      And element "color and mileage" should be inactive
#      When click on the element "blue"
#      And fill element "" with value ""
#      Then element "color and mileage" should be inactive