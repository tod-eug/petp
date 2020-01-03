#language: en

  Feature: As a client, I want correct work statuses of quality ad, so that I can control filling ad

    @Regress
    Scenario: Filling company and model
      Given site "https://auto.ru/" opened
      When click on the element "New Offer" in widget Main
      Then text "Какой марки ваш автомобиль?" should be visible
      And element "Company and Model" should be visible in widget Progress Bar
      And element "Company and Model" should have class "progress-bar-item_state_inactive"
      When click on the element "BMW" in widget Select company
      Then element "Company name" should be visible in widget Select model
      When click on the element "M5"
      Then text "Год выпуска" should be visible
      When click on the element "2017" in widget Select year
      Then text "Фотографии и видео" should be visible
      And element "Company and Model" should have class "progress-bar-item_state_active" in widget Progress Bar


    @Regress
    Scenario: Filling color and run
      Given site "https://auto.ru/" opened
      When click on the element "New Offer" in widget Main
      Then text "Какой марки ваш автомобиль?" should be visible
      And element "Color and Run" should be visible in widget Progress Bar
      And element "Color and Run" should have class "progress-bar-item_state_inactive"
      When click on the element "BMW" in widget Select company
      Then element "Company name" should be visible in widget Select model
      When click on the element "M5"
      Then text "Год выпуска" should be visible
      When click on the element "2017" in widget Select year
      Then text "Фотографии и видео" should be visible
      And element "Color and Run" should have class "progress-bar-item_state_inactive" in widget Progress Bar
      When click on the element "Blue" in widget Add advertisement
      And fill element "Run" with value "25000"
      Then element "Color and Run" should have class "progress-bar-item_state_active" in widget Progress Bar