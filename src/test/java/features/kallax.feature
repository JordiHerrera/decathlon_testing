Feature: Kallax

Scenario: Mostrar estanteria Kallax

Given the user is in the index page
When the user enters kallax in the search bar
And the user clicks the search button
Then the shelf list appears
