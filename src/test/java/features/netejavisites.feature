Feature: Nateja Visites

Scenario: Netejar productes vists

Given the user is in the index page
When the user goes to product 1 page
And the user enters "camiseta amarilla" in the search bar
And the user clicks the search button
And the user has recently seen products
And the user deletes product history
Then there are no products recently seen