Feature: Finding New Cars

  Scenario Outline: Finding New Cars
    Given user navigates to care wale
    When user mouseover to new cars
    Then usee clicks on FindNewCar
    And user clicks on "<CarBrand>"
    And user validates car "<title>"

    Examples: 
      | CarBrand | title        |
      | toyota   | totyotaTitle |
      | kia      | kiaTitle     |
