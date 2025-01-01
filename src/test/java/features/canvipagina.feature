Feature: Next search page

Scenario: Search for botas and go to page 2

Given the user is in the index page
When the user enters "botas" in the search bar
And the user clicks the search button
And the user is on the search results
And the user clicks the next page button
Then the product page is updated

Scenario: Search for raqueta and go to page 2

Given the user is in the index page
When the user enters "raqueta" in the search bar
And the user clicks the search button
And the user is on the search results
And the user clicks the next page button
Then the product page is updated