Feature: Product filtered

Scenario: Filter a list of products

Given the user is in the index page
When the user enters "pelotas" in the search bar2
And the user clicks the search button
And the user selects the filter of ascending price
Then the products of the page have reordered
