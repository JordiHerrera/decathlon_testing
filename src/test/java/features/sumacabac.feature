Feature: Total adds up

Scenario: Add two products to the cart and check price

Given the user is in the index page
When the user goes to product 1 page
And the user adds the product to the cart
And the user goes to product 2 page
And the user adds the product to the cart
And the user goes to the cart page
Then the total adds up to the prices of the items