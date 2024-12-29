Feature: Product List

Scenario: Mostrar cerca botes

Given the user is in the index page
When the user enters "botas" in the search bar
And the user clicks the search button
Then the "botas" product line appears

Scenario: Mostrar cerca raqueta

Given the user is in the index page
When the user enters "raqueta" in the search bar
And the user clicks the search button
Then the "raqueta" product line appears
