Feature: Product Deleted

Scenario: Delete a product added previously to the cart

Given the user is in the index page
When the user clicks on a product2
And the user adds the product to the cart2
And the user goes back to the homepage
And the user enters the cart
And the user clicks on the eliminate product icon
Then the product is not on the cart anymore
