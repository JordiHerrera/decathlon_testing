Feature: Product Added

Scenario: Add a product to the cart

Given the user is in the index page
When the user clicks on a product
And the user adds the product to the cart
Then the product has to be on the cart
