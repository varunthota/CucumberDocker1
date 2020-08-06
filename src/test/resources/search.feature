Feature: Search and select product from the list

  Scenario: Search product
    Given I open argos page
    When I search for a product nike
    And I select a random product from the list
    And I click on Add to cart
    Then I verify the product value with quantity 2
